import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.regex.Pattern;

public class TCPServer_Enhanced extends JFrame {
    private JTextField serverIPField, clientIPField, responseField, errorField;
    private JTextArea messageArea;
    private JButton clearButton, sendButton, quitButton;
    private JLabel connectionStatusLabel;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter clientOut;
    private BufferedReader in;

    public TCPServer_Enhanced() {
        setTitle("TCP Server");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Server IP Address Panel with Connection Status
        JPanel ipPanel = new JPanel(new BorderLayout());
        serverIPField = new JTextField(getLocalHostAddress());
        serverIPField.setEditable(false);
        clientIPField = new JTextField("Client disconnected");
        clientIPField.setEditable(false);
        
        connectionStatusLabel = new JLabel("Disconnected");
        connectionStatusLabel.setForeground(Color.RED);

        JPanel connectionPanel = new JPanel(new GridLayout(1, 2));
        connectionPanel.add(new JLabel("Server IP Address:"));
        connectionPanel.add(serverIPField);
        connectionPanel.add(new JLabel("Client IP Address:"));
        connectionPanel.add(clientIPField);
        
        ipPanel.add(connectionPanel, BorderLayout.NORTH);
        ipPanel.add(connectionStatusLabel, BorderLayout.SOUTH);

        // Message Area with Scroll Pane
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
        quitButton.addActionListener(e -> closeServer());

        setVisible(true);
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(31847);
            connectionStatusLabel.setText("Waiting for client...");
            connectionStatusLabel.setForeground(Color.ORANGE);

            while (true) {
                clientSocket = serverSocket.accept(); // Accept client connection
                connectionStatusLabel.setText("Connected");
                connectionStatusLabel.setForeground(Color.GREEN);
                clientIPField.setText(clientSocket.getInetAddress().getHostAddress());
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            showError("Server error: " + e.getMessage());
        }
    }

    private void closeServer() {
        try {
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
            System.exit(0);
        } catch (IOException ioException) {
            showError("Failed to close connection.");
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
                    connectionStatusLabel.setText("Disconnected");
                    connectionStatusLabel.setForeground(Color.RED);
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
            if (clientOut == null) {
                showError("Client disconnected!");
                return;
            }

            clientOut.println(response); // Send response to the client
            responseField.setText("");
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
        SwingUtilities.invokeLater(TCPServer_Enhanced::new);
    }
}
