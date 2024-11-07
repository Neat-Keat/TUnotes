import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Client(String serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    // Send a message to the server
    public void sendMessage(String message) {
        out.println(message);
    }

    // Receive a message from the server
    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    // Close the connection
    public void close() throws IOException {
        socket.close();
        in.close();
        out.close();
    }
}
