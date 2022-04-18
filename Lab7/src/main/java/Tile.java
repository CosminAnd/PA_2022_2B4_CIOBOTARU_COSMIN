public class Tile {
    private final char letter;
    private final int points;

    //constructor
    Tile(char letter, int points) {
        this.letter = letter;
        this.points = points;

    }

    //getters
    char getLetter() {
        return this.letter;
    }

    int getPoints() {
        return this.points;
    }

    //toString
    @Override
    public String toString() {
        return "Tile{" +
                "letter=" + letter +
                ", points=" + points +
                '}';
    }
}