import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class implements java socket client
 * @author pankaj
 *
 */
public class SocketClientExample {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        
        
        //get the IP address, if server is running on some other IP, you need to use that
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter server IP address here!");
        InetAddress host = InetAddress.getByName(scanner.nextLine()); 

        //Socket
        Socket socket = null;
        ObjectOutputStream oos = null; //used for send
        ObjectInputStream ois = null; //used for recv
        boolean quit = false;

        while(!quit){
            //Connect
            socket = new Socket(host.getHostName(), 9876);

            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server, enter your message ('quit' to quit)");
            oos.writeObject(scanner.nextLine());

            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);

            //close resources
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
    }
}