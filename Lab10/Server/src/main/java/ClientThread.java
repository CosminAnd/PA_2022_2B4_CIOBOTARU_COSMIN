
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private static boolean running = true;
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            do {
                // Get the request from the input stream: client → server
                String request = in.readLine();
                String[] words = request.split(" ");
                // Send the response to the output stream: server → client
                String answear;
                String command = words[0];
                System.out.println("Request: " + request);

                if (command.equals("register")) {
                    answear = "Server received the request ... register as " + words[1];
                    out.println(answear);
                    System.out.println(answear);
                    out.flush();
                } else if (command.equals("login")) {
                    answear = "Server received the request ... login as " + words[1];
                    out.println(answear);
                    System.out.println(answear);
                    out.flush();
                } else if (command.equals("friend")) {
                    answear = "Server received the request ... friend: ";
                    for (int i = 1; i < words.length; i++) {
                        answear += words[i];
                        answear += ", ";
                    }
                    out.println(answear);
                    System.out.println(answear);
                    out.flush();
                } else if (command.equals("read")) {
                    answear = "Server received the request ... read: ";
                    out.println(answear);
                    System.out.println(answear);
                    out.flush();
                } else if (command.equals("send")) {
                    answear = "Server received the request ... send: ";
                    out.println(answear);
                    System.out.println(answear);
                    out.flush();
                } else if (command.equals("exit")) {
                    answear = "Server received the request ... Client stopped!";
                    out.println(answear);
                    System.out.println(answear);
                    out.flush();

                }else if(command.equals("stop")){
                    answear = "Server received the request ... Server stopped!";
                    out.println(answear);
                    System.out.println(answear);
                    running = false;
                    out.flush();
                    this.socket.close();
                    System.exit(1);


                }
                else {
                    answear = "[Server] Command not found, try again!";
                    out.println(answear);
                    System.out.println(answear);
                    out.flush();
                }
                //out.flush();
            } while (running);
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}