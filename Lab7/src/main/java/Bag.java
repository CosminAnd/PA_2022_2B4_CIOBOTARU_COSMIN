import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();

    public Bag() {
        Random random = new Random();
        for (char c = 'a'; c < 'z'; c++) {
            Tile tile = new Tile(c,random.nextInt(10)+1 );
            letters.add(tile);
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        Random random= new Random();
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            int i1 = random.nextInt(letters.size());
            extracted.add(letters.get(i1));
            //letters.remove(i1);
        }
        return extracted;
    }


}