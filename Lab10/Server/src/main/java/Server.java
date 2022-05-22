import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;


public class Server {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public static volatile boolean stop = true;
    public static ServerSocket serverSocket = null;


    public Server() throws IOException {
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            //serverSocket.setSoTimeout(12000);//2 minute pt timeout

            do {
                System.out.println("Server is waiting for client..");
                socket = serverSocket.accept();// ascult clientul
                new ClientThreadOOP(socket).start();
            } while (!stop);

        } //catch (InterruptedIOException e) {
        //System.err.println("Timed Out ( 2 minute )!");
        //}
        catch (IOException exception) {
            System.out.println("Ooops... " + exception);
        } finally {
            serverSocket.close();
        }
    }

}


//server pentru aplicatia simpla
/*public class Server {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    private Set<String> userNames = new HashSet<>();
    private Set<User> users = new HashSet<>();
    private boolean stop = false;
    private boolean anyoneConnected = false;


    public Server() throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            serverSocket.setSoTimeout(12000);//2 minute pt timeout

            do {
                System.out.println("Server is waiting for client..");
                socket = serverSocket.accept();// ascult clientul
                new ClientThread(socket, this).start();
            } while (!stop);
            while (anyoneConnected) {
                anyoneConnected = false;
                for (User user : users)
                    if (user.isConnected())
                        anyoneConnected = true;
            }

        } catch (InterruptedIOException e) {
            System.err.println("Timed Out ( 2 minute )!");
        } catch (IOException exception) {
            System.out.println("Ooops... " + exception);
        } finally {
            serverSocket.close();
        }
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<String> getUserNames() {
        return userNames;
    }
    public void setStop(boolean stop) {
        this.stop = stop;
    }

}*/


