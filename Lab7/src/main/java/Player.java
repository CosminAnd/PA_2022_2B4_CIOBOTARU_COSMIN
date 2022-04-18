import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Player implements Runnable, Comparable<Player> {
    private String name;
    private Game game;
    public boolean stop = false;
    private List<Tile> tiles = new ArrayList<>();
    int score = 0;
    public boolean paly=false;

    public void setPaly(){
        paly=true;
    }

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int calculateScore(List<Tile> tiles, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += tiles.get(i).getPoints();
        }
        sum = sum * size;
        return sum;
    }

    private boolean submitWord() throws InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        String word;
        Collections.shuffle(extracted);
        Random random = new Random();
        int size = random.nextInt(7) + 1;
        word = getWord(extracted, size);
        while (!game.getDictionary().isWord(word) && !stop) {
            size = random.nextInt(7) + 1;
            game.getBag().addTiles(extracted);
            extracted = game.getBag().extractTiles(7);
            word = getWord(extracted, size);
        }
        //System.out.println(game.getDictionary().isWord(word));
        game.getBoard().addWord(this, word);
        this.score = score + calculateScore(extracted, size);

        Thread.sleep(50);
        return true;
    }


    private String getWord(List<Tile> myTiles, int size) {
        StringBuilder builder = new StringBuilder(size);
        for (Tile tile : myTiles) {
            builder.append(tile.getLetter());
            if (builder.length() == size) {
                return builder.toString();
            }
        }
        return builder.toString();
    }

    @Override
    public void run() {
        setGame(game);
        try {
            while (!stop) {
                submitWord();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.getScore(), score);
    }
}