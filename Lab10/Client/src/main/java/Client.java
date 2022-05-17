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
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            do {
                // Send a request to the server
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter a command: ");
                String request = keyboard.nextLine();
                out.println(request);
                // Wait the response from the server
                String response = in.readLine();
                System.out.println(response);
                if ("Server received the request ... Client stopped!".compareTo(response) == 0) {
                    running = false;
                }


            } while (running);
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}