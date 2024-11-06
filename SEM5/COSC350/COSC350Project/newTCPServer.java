import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class newTCPServer extends JFrame {
    private JTextField serverIPField;
    private JTextField clientIPField;
    private JTextArea messageArea;
    private JTextField responseField;
    private JTextField errorField;
    private JButton clearButton, sendButton, quitButton;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter clientOut;
    private BufferedReader in;

    public newTCPServer() {
        setTitle("TCP Server");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Server IP Address Panel
        JPanel ipPanel = new JPanel(new GridLayout(1, 2));
        serverIPField = new JTextField(getLocalHostAddress());
        serverIPField.setEditable(false);
        clientIPField = new JTextField("Client disconnected");
        clientIPField.setEditable(false);
        ipPanel.add(new JLabel("Server IP Address:"));
        ipPanel.add(serverIPField);
        ipPanel.add(new JLabel("Client IP Address:"));
        ipPanel.add(clientIPField);

        // Message Area
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        // Response Field and Buttons
        JPanel bottomPanel = new JPanel(new BorderLayout());
        responseField = new JTextField();
        bottomPanel.add(responseField, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        clearButton = new JButton("Clear");
        sendButton = new JButton("Send");
        quitButton = new JButton("Quit");
        buttonPanel.add(sendButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(quitButton);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        // Error Field
        errorField = new JTextField();
        errorField.setEditable(false);
        errorField.setForeground(Color.RED);
        errorField.setBorder(BorderFactory.createTitledBorder("Error Message"));

        // Add components to the frame
        add(ipPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(bottomPanel, BorderLayout.CENTER);
        southPanel.add(errorField, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);

        // Start the server in a new thread
        new Thread(this::startServer).start();

        // Button Actions
        clearButton.addActionListener(e -> {
            messageArea.setText("");
            responseField.setText("");
            errorField.setText("");
        });

        sendButton.addActionListener(new SendButtonAction());
        quitButton.addActionListener(e -> {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
                System.exit(0);
            } catch (IOException ioException) {
                showError("Failed to close connection.");
            }
        });

        setVisible(true);
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(31847);
            showError("Server started on IP: " + serverIPField.getText() + " Port: 31847");

            while (true) {
                clientSocket = serverSocket.accept(); // Accept client connection
                clientIPField.setText(clientSocket.getInetAddress().getHostAddress());
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            showError("Server error: " + e.getMessage());
        }
    }

    private class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                 
                clientOut = out; // Set the clientOut for sending messages

                String message;
                while ((message = in.readLine()) != null) {
                    messageArea.append("Client: " + message + "\n");
                    out.println("Echo: " + message); // Send a response back to the client
                }
            } catch (IOException e) {
                showError("Error in client communication: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                    clientOut = null; // Reset clientOut when done
                } catch (IOException e) {
                    showError("Failed to close client socket.");
                }
            }
        }
    }

    private class SendButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String response = responseField.getText();
            if (response.isEmpty()) {
                showError("Response cannot be empty!");
                return;
            }

            try {
                if (clientOut != null) {
                    clientOut.println(response); // Send response to the client
                    responseField.setText("");
                } else {
                    showError("Client disconnected!");
                }
            } catch (Exception exception) {
                showError("Failed to send message.");
            }
        }
    }

    private void showError(String message) {
        errorField.setText(message);
    }

    private String getLocalHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "Unknown";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TCPServer::new);
    }
}
