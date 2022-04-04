import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    private List<Tile> tiles = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    private boolean submitWord() throws InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        System.out.println(extracted);
        String word= new String();

        Collections.shuffle(extracted);
        word = getWord(extracted);

        game.getBoard().addWord(this, word);
        Thread.sleep(50);
        return true;
    }

    private String getWord(List<Tile> myTiles) {
        StringBuilder builder = new StringBuilder(myTiles.size());
        for(Tile ch: myTiles)
        {
            builder.append(ch.getLetter());
        }
        return builder.toString();
    }

    @Override
    public void run() {
        setGame(game);
        try {
            submitWord();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}