
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server{

    public void run() {
       int port=8010;
       try {
           ServerSocket serverSocket = new ServerSocket(port);
           serverSocket.setSoTimeout(10000);
           while (true) {
               try {
                   System.out.println("Server is listening on port " + port);
                   Socket acceptedConnection = serverSocket.accept();
                     System.out.println("Connection accepted from client " + acceptedConnection.getInetAddress());
                     PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                     BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                     toClient.println("Hello from Server");
                     toClient.close();
                     acceptedConnection.close();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
    public static void main(String[] args) {
        Server server = new Server();
        try {
                    server.run();   
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}