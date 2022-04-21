
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();
    Thread timer = new Thread( new Daemon());


    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        timer.setDaemon(true);
        timer.start();
        for (Player player : players) {
            Thread thread = new Thread(player);
            thread.start();
        }
        while (!bag.isEmpty()){
        }


        for(Player it : players){
            it.stop = true;
        }


        for(Player player: players)
        board.displayScore(player);


        board.displayWinner();

        board.displayWord();

    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }


}