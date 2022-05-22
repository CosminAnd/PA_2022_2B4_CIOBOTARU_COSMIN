import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network implements Commands {
    protected volatile Map<String, List<String>> users = new HashMap<>();
    private String nameOfLoggedUser = null;
    protected volatile Map<String, List<String>> usersMessages = new HashMap<>();

    public String getNameOfLoggedUser() {
        return nameOfLoggedUser;
    }

    public void setNameOfLoggedUser(String nameOfLoggedUser) {
        this.nameOfLoggedUser = nameOfLoggedUser;
    }

    @Override
    public boolean login(String name) {
        if (users.containsKey(name)) {
            nameOfLoggedUser = name;
            return true;
        }
        return false;
    }

    @Override
    public boolean register(String name) {
        if (users.containsKey(name)) {
            return false;
        } else {
            users.put(name, new ArrayList<>());
            usersMessages.put(name, new ArrayList<>());
            return true;
        }
    }

    @Override
    public int friend(String friend) {
        if (!friend.equals(nameOfLoggedUser)) {
            if (users.containsKey(friend)) {
                if (users.get(nameOfLoggedUser).contains(friend))
                    return 2;
                else {
                    users.get(nameOfLoggedUser).add(friend);
                    return 1;
                }
            } else {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public boolean send(String message) {
        if (!users.get(nameOfLoggedUser).isEmpty()) {
            for (int i = 0; i < users.get(nameOfLoggedUser).size(); i++) {
                String friend = users.get(nameOfLoggedUser).get(i);
                String newMessage = "From ";
                newMessage += nameOfLoggedUser;
                newMessage += ": ";
                newMessage += message;
                usersMessages.get(friend).add(newMessage);
            }
            return true;
        }
        return false;
    }

    @Override
    public String read() {
        if (usersMessages.get(nameOfLoggedUser) != null) {
            String messages = null;
            for (int i = 0; i < usersMessages.get(nameOfLoggedUser).size(); i++) {
                messages += i + ": " + usersMessages.get(nameOfLoggedUser).get(i);
                messages += " ";
            }
            return messages;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Network{" +
                "users=" + users +
                '}';
    }
}
