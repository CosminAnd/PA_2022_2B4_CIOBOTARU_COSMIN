public interface Commands {
    boolean login(String name);

    boolean register(String name);

    int friend(String friend);

    boolean send(String message);

    String read();
}
