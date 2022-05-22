import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientThread extends Thread {
    private Socket socket = null;
    private final Server server;
    private boolean running;
    //private User thisUser = null;
    private boolean connected = false;
    private String[] words = null;
    private String answear;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }
}


   /* public void run() {
        try {
            running = true;
            do {
                // Get the request from the input stream: client → server
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                words = null;
                if (request != null) {
                    words = request.split(" ");
                }
                String command = words[0];
                System.out.println("Server receiver the command: "+ command);

                thisUser = null;
                connected = false;
                answear = null;
                switch (command) {
                    case "stop":
                        if (server.getUsers().isEmpty()) {
                            answear = "You are not registered!";
                            break;
                        }
                        for (User user : server.getUsers()) //verific daca este conectat
                            if (user.getT() == this)
                                if (!user.isConnected()) {
                                    answear = "No client connected (to stop)! Login first!";
                                    thisUser = user;
                                    System.out.println(answear);
                                    connected = true;
                                } else {
                                    thisUser = user;
                                }
                        if (thisUser == null) {
                            answear = "No client connected (to stop)! Login first!";
                            System.out.println(answear);
                            connected = true;
                        }
                        if (connected)
                            break;

                        answear = "Server stopped!";
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                        System.out.println(answear);
                        out.println(answear);
                        out.flush();
                        running = false;
                        this.socket.close();
                        System.exit(1);
                        break;
                    case "exit":
                        if (server.getUsers().isEmpty()) {
                            answear = "You are not registered!";
                            break;
                        }
                        for (User user : server.getUsers()) //verific daca este conectat
                            if (user.getT() == this)
                                if (!user.isConnected()) {
                                    answear = "No client connected (to exit)! Login first!";
                                    thisUser = user;
                                    System.out.println(answear);
                                    connected = true;
                                } else {
                                    thisUser = user;
                                }
                        if (thisUser == null) {
                            answear = "No client connected (to exit)! Login first!";
                            System.out.println(answear);
                            connected = true;
                        }
                        if (connected)
                            break;

                        answear = "Client exit!";
                        this.thisUser.setConnected(false); //setam clientul
                        PrintWriter outt = new PrintWriter(socket.getOutputStream());
                        System.out.println(answear);
                        outt.println(answear);
                        outt.flush();
                        this.socket.close();
                        break;
                    case "login":
                        for (User user : server.getUsers()) //verific daca e logat
                            if (user.getT() == this && user.isConnected() == true) {
                                answear = "You are already logged!";
                                connected = true;
                            }
                        if (connected)
                            break;

                        //comanda corecta
                        if (words.length == 2) {
                            if (server.getUserNames().contains(words[1])) {
                                for (User user : server.getUsers()) {
                                    if (user.getName().compareTo(words[1]) == 0) {
                                        if (!user.isConnected()) {
                                            user.setT(this);
                                            user.setConnected(true);
                                            answear = "User " + words[1] + " connected succesfully!";
                                        } else {
                                            answear = "User is already connected!";
                                        }
                                    }
                                }
                            } else {
                                answear = "Please register!";
                            }
                        } else {
                            answear = "Syntax error! login [name]";
                        }
                        break;
                    case "register":
                        for (User user : server.getUsers()) //verific daca e logat
                            if (user.getT() == this && user.isConnected() == true) {
                                answear = "You are already logged!";
                                connected = true;
                            }
                        if (connected)
                            break;

                        if (words.length == 2) {
                            if (server.getUserNames().contains(words[1])) { //check if name is already used
                                answear = "Name " + words[1] + " is already registered!";
                            } else {
                                server.getUsers().add(new User(words[1]));
                                server.getUserNames().add(words[1]);
                                answear = "User " + words[1] + " is registered successfully!";
                            }
                        } else {
                            String answear = "Syntax error! [register user]";
                        }
                        break;
                    case "friend":
                        if (server.getUsers().isEmpty()) {
                            answear = "You are not registered!";
                            break;
                        }
                        thisUser = null;
                        for (User user : server.getUsers())
                            if (user.getT() == this) {
                                if (!user.isConnected()) {
                                    answear = "You are not logged!";
                                    System.out.println(answear);
                                    connected = true;
                                } else {
                                    thisUser = user;
                                }
                            }
                        if (thisUser == null) {
                            answear = "You are not logged!";
                            System.out.println(answear);
                            connected = true;
                        }

                        if (connected)
                            break;
                        if (words.length > 1) {
                            answear = "List of friend(s): ";
                            for (int i = 1; i < words.length; i++) {
                                if (server.getUserNames().contains(words[i])) {
                                    for (User user : server.getUsers())
                                        if (user.getName().compareTo(words[i]) == 0) {
                                            thisUser.getFriends().add(user);
                                            answear = answear + words[i];
                                            answear = answear + ", ";
                                                                                     }
                                } else {
                                    answear = null;
                                    answear = words[1] + " is not registered!\n";
                                }
                            }
                        } else {
                            answear = "Syntax error! [friend [friend1] [friend2] ...]'";
                        }
                        break;
                    case "message":
                        if (server.getUsers().isEmpty()) {
                            answear = "You are not registered!";
                            break;
                        }
                        for (User user : server.getUsers())
                            if (user.getT() == this)
                                if (!user.isConnected()) {
                                    answear = "You are not logged!";
                                    thisUser = user;
                                    System.out.println(answear);
                                    connected = true;
                                } else {
                                    thisUser = user;
                                }
                        if (thisUser == null) {
                            answear = "You are not logged!";
                            System.out.println(answear);
                            connected = true;
                        }

                        if (connected)
                            break;

                        if (words.length > 1)
                            if (!thisUser.getFriends().isEmpty()) {
                                String message = "Message from " + thisUser.getName() + ": ";
                                for (int i = 1; i < words.length; i++)
                                    message = message + " " + words[i];
                                for (User friend : thisUser.getFriends()) {
                                    friend.getMessages().add(message);
                                }

                                answear = "Message send!";
                            } else {
                                answear = "No friends!";
                            }
                        else {
                            answear = "Type a message!";
                        }
                        break;
                    case "read":
                        for (User user : server.getUsers())
                            if (user.getT() == this)
                                if (!user.isConnected()) {
                                    answear = "You are not logged!";
                                    thisUser = user;
                                    System.out.println(answear);
                                    connected = true;
                                } else {
                                    thisUser = user;
                                }
                        if (thisUser == null) {
                            answear = "You are not logged!";
                            System.out.println(answear);
                            connected = true;
                        }

                        if (connected)
                            break;

                        if (words.length > 1) {
                            answear = "Syntax error! [read]";
                        } else {
                            if (!thisUser.getMessages().isEmpty()) {
                                String aux;
                                answear = "Messages: ";
                                for (String message : thisUser.getMessages()) {
                                    answear = answear + message + " ; ";
                                    //System.out.println(answear);
                                }
                            } else {
                                answear = "You don't have messages!";
                            }
                        }
                        break;
                    default:
                        answear = "Wrong command!";
                }
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(answear);
                out.flush();

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
}*/