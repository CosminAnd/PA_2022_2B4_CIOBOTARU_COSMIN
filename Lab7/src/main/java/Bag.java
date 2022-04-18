import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bag {
    private final CopyOnWriteArrayList<Tile> tiles = new CopyOnWriteArrayList<>();

    public void createTile(char letter, int points, int count) {
        for (int i = 0; i < count; i++) {
            tiles.add(new Tile(letter, points));
        }
    }

    public void shuffleBag() {
        Collections.shuffle(tiles);
    }

    public Bag() {
        createTile('e', 1, 12);
        createTile('a', 1, 9);
        createTile('i', 1, 9);
        createTile('o', 1, 8);
        createTile('n', 1, 6);
        createTile('r', 1, 6);
        createTile('t', 1, 6);
        createTile('l', 1, 4);
        createTile('s', 1, 4);
        createTile('u', 1, 4);
        createTile('d', 2, 4);
        createTile('g', 2, 3);
        createTile('b', 3, 2);
        createTile('c', 3, 2);
        createTile('m', 3, 2);
        createTile('p', 3, 2);
        createTile('f', 4, 2);
        createTile('h', 4, 2);
        createTile('v', 4, 2);
        createTile('w', 4, 2);
        createTile('y', 4, 2);
        createTile('k', 5, 1);
        createTile('j', 8, 1);
        createTile('x', 8, 1);
        createTile('q', 10, 1);
        createTile('z', 10, 1);

        shuffleBag();
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        Random random = new Random();
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            int i1 = random.nextInt(tiles.size());
            extracted.add(tiles.get(i1));
            tiles.remove(i1);
        }
        return extracted;
    }

    public synchronized void addTiles(List<Tile> extracted) {
        for (Tile tile : extracted)
            tiles.add(tile);
    }

}