import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

class ClientThreadOOP extends Thread {
    private static boolean running = true;
    private final Socket socket;
    private static final Network Network = new Network();

    public ClientThreadOOP(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            socket.setSoTimeout(120000);
            if (Server.stop) {
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                do {
                    // Get the request from the input stream: client → server
                    String request = in.readLine();
                    if (request != null) {
                        System.out.print("Server received the request: ");
                        String[] words = request.split(" ");
                        // Send the response to the output stream: server → client
                        String answer;
                        String command = words[0];
                        System.out.println(request);
                        switch (command) {
                            case "register":
                                if (words.length > 1) {
                                    if (Network.getNameOfLoggedUser() == null) {
                                        if (!Network.register(words[1]))
                                            answer = "This user is registered! Try again!";
                                        else
                                            answer = "Registered!";
                                    } else
                                        answer = "You are logged-in!";
                                } else
                                    answer = "Try again: register [name]!";

                                break;
                            case "login":
                                if (words.length > 1) {
                                    if (Network.getNameOfLoggedUser() == null) {
                                        if (Network.login(words[1]))
                                            answer = "Login success!";
                                        else {
                                            answer = "Register first!";
                                        }
                                    } else
                                        answer = "You are already logged-in!";
                                } else
                                    answer = "Try again: login [name]";
                                break;
                            case "exit":
                                answer = "Client exit!";
                                out.println(answer);
                                running = false;
                                Network.setNameOfLoggedUser(null);
                                break;
                            case "stop":
                                Server.stop = false;
                                answer = "Server stopped!";
                                out.println(answer);
                                Server.serverSocket.close();
                                break;
                            case "friend":
                                if (words.length > 1) {
                                    if (Network.getNameOfLoggedUser() != null) {
                                        answer = null;
                                        for (int i = 1; i < words.length; i++) {
                                            int isFriend = Network.friend(words[i]);
                                            if (isFriend == -1)
                                                answer = "Wrong name!";
                                            else if (isFriend == 1) {
                                                answer = "Friend added! ";
                                            } else if (isFriend == 0)
                                                answer = "That user do not exist! Try again!";
                                            else
                                                answer = "User " + words[i] + " is your friend. Try again!";
                                        }
                                    } else
                                        answer = "Login first!";
                                } else
                                    answer = "Type a new friend!";
                                break;
                            case "read":
                                if (Network.getNameOfLoggedUser() != null) {
                                    answer = Network.read();
                                    if (answer == null) {
                                        answer = "You have no messages!";
                                    }
                                } else
                                    answer = "Login first!";
                                break;
                            case "send":
                                if (words.length > 1) {
                                    if (Network.getNameOfLoggedUser() != null) {
                                        StringBuilder message = new StringBuilder();
                                        for (int i = 1; i < words.length; i++) {
                                            message.append(words[i]);
                                            message.append(" ");
                                        }
                                        if (Network.send(message.toString())) {
                                            answer = "Message send to your friends!";
                                        } else {
                                            answer = "You have no friends!";
                                        }
                                    } else
                                        answer = "Login first!";
                                } else
                                    answer = "Wrong syntax! Try with a message!";
                                break;
                            default:
                                answer = "Bad command! Try again!";

                        }
                        out.println(answer);
                        out.flush();
                    }
                }
                while (running);
            }
        } catch (IOException e) {
            if (e instanceof SocketTimeoutException) {
                System.err.println("Timeout (2 min)!");
            } else
                System.err.println("Communication error: " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}