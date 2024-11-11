import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class TCPClient extends JFrame {
    private JTextField serverIPField;
    private JLabel clientIPLabel;
    private JTextArea messageArea;
    private JTextField inputField;
    private JButton sendButton, clearButton, quitButton;
    private JTextField errorField;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public TCPClient() {
        setTitle("TCP Client");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel for IP Address
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        serverIPField = new JTextField("127.0.0.1");
        clientIPLabel = new JLabel("Client IP: " + getLocalHostAddress());
        topPanel.add(new JLabel("Server IP Address:"));
        topPanel.add(serverIPField);
        topPanel.add(clientIPLabel);

        // Message Area
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        // Input Field and Buttons
        JPanel bottomPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        bottomPanel.add(inputField, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        sendButton = new JButton("Send");
        clearButton = new JButton("Clear");
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

        // Create a new panel to hold bottomPanel and errorField
        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(bottomPanel);
        combinedPanel.add(errorField);

        // Add all components to the main frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(combinedPanel, BorderLayout.SOUTH);

        // Button Actions
        sendButton.addActionListener(new SendButtonAction());
        clearButton.addActionListener(e -> messageArea.setText(""));
        quitButton.addActionListener(e -> {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
                System.exit(0);
            } catch (IOException ioException) {
                showError("Failed to close connection.");
            }
        });

        setVisible(true);
    }

    private class SendButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String serverIP = serverIPField.getText();
            String message = inputField.getText();
            if (message.isEmpty()) {
                showError("Message cannot be empty!");
                return;
            }

            try {
                if (socket == null || socket.isClosed()) {
                    connectToServer(serverIP);
                }
                out.println(message);
                String response = in.readLine();
                messageArea.append("Server: " + response + "\n");
                inputField.setText("");
            } catch (IOException ioException) {
                showError("Connection closed or failed!");
            }
        }
    }

    private void connectToServer(String serverIP) {
        try {
            socket = new Socket(serverIP, 31847); // Connect to server
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            errorField.setText(""); // Clear error field
        } catch (IOException e) {
            showError("Connection failed: " + e.getMessage()); // Detailed error message
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
        SwingUtilities.invokeLater(TCPClient::new);
    }
}