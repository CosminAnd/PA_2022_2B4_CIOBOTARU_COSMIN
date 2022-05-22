import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        boolean running = true;
        boolean serverRunning = true;
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("List of commands: ");
            System.out.println("- login [username]");
            System.out.println("- register [username]");
            System.out.println("- friend [friend1] [friend2] ...");
            System.out.println("- send [text]");
            System.out.println("- stop");
            System.out.println("- exit");
            System.out.println("");
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter a command: ");
                String command = keyboard.nextLine();
                if (command.equals("exit") && serverRunning) {
                    running = false;
                    System.out.println("Client exit!");
                    System.exit(1);
                    socket.close();
                }
                out.println(command);
                String response = in.readLine();
                System.out.println(response);
                if (response.equals("Server stopped!")) {
                    serverRunning = false;
                }
                if (response.compareTo("Client exit!") == 0) {
                    running = false;
                    System.exit(1);
                    socket.close();
                }
            } while (running);
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
