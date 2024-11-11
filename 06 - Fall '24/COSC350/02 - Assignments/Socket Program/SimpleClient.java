import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 31847);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Hello, Server!");
            String response = in.readLine();
            System.out.println("Server response: " + response);

            socket.close();
        } catch (IOException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}