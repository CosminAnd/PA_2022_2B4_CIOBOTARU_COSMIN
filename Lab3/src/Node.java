import javax.xml.stream.Location;
import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> { ///interfata pentru metode de comparare
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public abstract void setAddress(String newAddress);

    public abstract void setStorageCapacity(int newStorageCapacity);

    public abstract int getStorageCapacity();

    public abstract String getAddress();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Node toCompare) {
        return this.name.compareTo(toCompare.getName());

    }
}
