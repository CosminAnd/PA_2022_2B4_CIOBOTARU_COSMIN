import java.util.List;

public class Stick {
    private Node first;
    private Node second;

    Stick(Node first, Node second) {
        this.first = first;
        this.second = second;
    }

    public Node getFirst() {
        return this.first;
    }

    public Node getSecond() {
        return this.second;
    }



    boolean compareStick(List<Stick> sticks) {
        for (Stick stick : sticks) {
            if (first.compareNode(stick.getFirst()) && second.compareNode(stick.getSecond()))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "First:" + this.first + " " + "Second:" + this.second;
    }

}
