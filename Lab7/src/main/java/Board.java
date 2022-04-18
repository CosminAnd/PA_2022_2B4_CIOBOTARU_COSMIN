import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private final List<String> words = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();
    public void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    public void displayScore(Player player) {
        //System.out.println(player.getName() + " are scorul: " + player.score);
        players.add(player);
    }
    public void displayWinner(){
        System.out.println();
        System.out.println("Clasamentul este:");
        Collections.sort(players);
        for (Player player : players){
            System.out.println(player.getName() +" cu scorul: "+ player.getScore());
        }
    }

    public void displayWord(){
        System.out.println(words);
    }

    @Override
    public String toString() {
        return words.toString();
    }
}