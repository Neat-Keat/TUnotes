import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientGUI extends JFrame {
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private Client client;  // Reference to the socket client

    public ClientGUI() {
        // Set up the chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);  // User can't edit chat history
        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Set up the message input field and send button
        messageField = new JTextField(30);
        sendButton = new JButton("Send");

        // Panel to hold the input field and button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Add components to the frame
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Configure frame settings
        setTitle("Chat Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Button action to send message
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                if (!message.isEmpty()) {
                    client.sendMessage(message);  // Send message to server
                    messageField.setText("");  // Clear input field
                }
            }
        });

        // Connect to the server
        try {
            client = new Client("localhost", 12345);  // Replace with your server address and port
            new Thread(this::receiveMessages).start();  // Start a thread to listen for incoming messages
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Continuously receive messages from server
    private void receiveMessages() {
        try {
            String message;
            while ((message = client.receiveMessage()) != null) {
                String finalMessage = message;
                SwingUtilities.invokeLater(() -> chatArea.append(finalMessage + "\n"));  // Update chat area on the Event Dispatch Thread
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientGUI();  // Launch the GUI
    }
}
