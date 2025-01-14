import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.regex.Pattern;

public class TCPClient_Enhanced extends JFrame {
    private JTextField serverIPField, portField, messageField, errorField;
    private JTextArea messageArea;
    private JButton connectButton, disconnectButton, sendButton, clearButton;
    private JLabel connectionStatusLabel;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public TCPClient_Enhanced() {
        setTitle("TCP Client");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // IP and Port Panel
        JPanel ipPanel = new JPanel(new GridLayout(2, 2));
        serverIPField = new JTextField("127.0.0.1");
        portField = new JTextField("31847");
        connectionStatusLabel = new JLabel("Disconnected");
        connectionStatusLabel.setForeground(Color.RED);

        ipPanel.add(new JLabel("Server IP Address:"));
        ipPanel.add(serverIPField);
        ipPanel.add(new JLabel("Port:"));
        ipPanel.add(portField);
        ipPanel.add(new JLabel("Connection Status:"));
        ipPanel.add(connectionStatusLabel);

        // Message Area with Scroll Pane
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        // Message Input and Buttons
        JPanel bottomPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        bottomPanel.add(messageField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        connectButton = new JButton("Connect");
        disconnectButton = new JButton("Disconnect");
        sendButton = new JButton("Send");
        clearButton = new JButton("Clear");
        buttonPanel.add(connectButton);
        buttonPanel.add(disconnectButton);
        buttonPanel.add(sendButton);
        buttonPanel.add(clearButton);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        // Error Field
        errorField = new JTextField();
        errorField.setEditable(false);
        errorField.setForeground(Color.RED);
        errorField.setBorder(BorderFactory.createTitledBorder("Error Message"));

        // Add components to frame
        add(ipPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(bottomPanel, BorderLayout.CENTER);
        southPanel.add(errorField, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);

        // Button Actions
        connectButton.addActionListener(new ConnectAction());
        disconnectButton.addActionListener(e -> closeConnection());
        sendButton.addActionListener(new SendAction());
        clearButton.addActionListener(e -> {
            messageArea.setText("");
            messageField.setText("");
            errorField.setText("");
        });

        setVisible(true);
    }

    private class ConnectAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ip = serverIPField.getText();
            String portText = portField.getText();

            if (!isValidIP(ip)) {
                showError("Invalid IP address!");
                return;
            }

            int port;
            try {
                port = Integer.parseInt(portText);
                if (port < 1 || port > 65535) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                showError("Invalid port number!");
                return;
            }

            try {
                socket = new Socket(ip, port);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                connectionStatusLabel.setText("Connected");
                connectionStatusLabel.setForeground(Color.GREEN);
                new ServerListener().start();
            } catch (IOException ioException) {
                showError("Could not connect to server: " + ioException.getMessage());
            }
        }
    }

    private class SendAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = messageField.getText();
            if (message.isEmpty()) {
                showError("Message cannot be empty!");
                return;
            }

            if (out != null) {
                out.println(message);
                messageField.setText("");
            } else {
                showError("Not connected to server!");
            }
        }
    }

    private class ServerListener extends Thread {
        public void run() {
            try {
                String response;
                while ((response = in.readLine()) != null) {
                    messageArea.append("Server: " + response + "\n");
                }
            } catch (IOException e) {
                showError("Server connection lost.");
            } finally {
                closeConnection();
            }
        }
    }

    private void closeConnection() {
        try {
            if (socket != null) socket.close();
            if (in != null) in.close();
            if (out != null) out.close();
            connectionStatusLabel.setText("Disconnected");
            connectionStatusLabel.setForeground(Color.RED);
        } catch (IOException e) {
            showError("Error closing connection.");
        }
    }

    private void showError(String message) {
        errorField.setText(message);
    }

    private boolean isValidIP(String ip) {
        String ipPattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return Pattern.matches(ipPattern, ip);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TCPClient_Enhanced::new);
    }
}
