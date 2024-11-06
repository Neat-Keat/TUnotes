import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class implements java Socket server
 * @author pankaj
 *
 */
public class SocketServerExample {
    
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        
        //socket
        server = new ServerSocket(port);

        //listen (exits on receiving "quit")
        while(true){
            System.out.println("Waiting for the client request");
            //accept
            Socket socket = server.accept();
            //recv
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //send
            oos.writeObject("Echo: " + message);
            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("quit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }
    
}