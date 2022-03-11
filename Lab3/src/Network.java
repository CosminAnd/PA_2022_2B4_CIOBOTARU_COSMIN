import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import static java.util.Collection.*;


public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network() {
    }

    public void setNodes(List<Node> newNodes) {
        this.nodes = newNodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node newNode) {
        nodes.add(newNode);
    }

    public void setNode(Node newNode, int index) {
        if (index > 0 && index < nodes.size())
            nodes.add(index, newNode);
        else System.out.println("Index incorect.");
    }

    public Node getNode(int index) {
        return nodes.get(index);
    }

    public void print() {
        for (Node node : nodes)
            System.out.println("Nume: " + node.getName() + "; Adresa: " + node.getAddress() + "; Capacitate: " + node.getStorageCapacity());
    }


}
