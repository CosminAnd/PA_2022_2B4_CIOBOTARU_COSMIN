import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public abstract class Node implements Comparable<Node> { ///interfata pentru metode de comparare
    private String name;
    private final Map<Node, Integer> cost = new HashMap<>();

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

    public void setCost(Node key, int value) {
        cost.put(key, value);
    }

    public void printNodeMap() {
        for (Map.Entry m : cost.entrySet()) {
            System.out.println(m.getKey() + "; cost: " + m.getValue());
        }
    }

    public void addToMatrix(int i, int j, int[][] matrix, Node node) {
        for (Map.Entry m : cost.entrySet()) {
            if (node.equals(m.getKey())) {
                matrix[i][j] = matrix[j][i] = (int) m.getValue();
            }
        }
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Node toCompare) {
        return this.name.compareTo(toCompare.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

}
