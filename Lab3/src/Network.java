import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Network {
    private List<Node> nodes = new ArrayList<>();
    private final List<Node> identifiable = new ArrayList<>();

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

    public void sortAllNodes() {
        Collections.sort(nodes);
    }

    public void print() {
        for (Node node : nodes)
            System.out.println("Nume: " + node.getName() + "; Adresa: " + node.getAddress() + "; Capacitate: " + node.getStorageCapacity());
       System.out.println();

    }

    public void printNetworkMap() {
        for (Node n : nodes) {
            System.out.println("From: " + n + " to:");
            n.printNodeMap();
            System.out.println("\n");
        }
    }

    public void buildNodesIdentifiable() {
        for (Node n : nodes) {
            if (n instanceof Identifiable) {
                identifiable.add(n);
            }
        }
    }

    public void printNodesIdentifiable() {
        boolean ordo = false;
        Node aux;
        while (!ordo) {
            ordo = true;
            for (int i = 0; i < identifiable.size() - 1; i++)
                if (identifiable.get(i).getAddress().compareTo(identifiable.get(i + 1).getAddress()) > 0) {
                    aux = identifiable.get(i);
                    identifiable.set(i, identifiable.get(i + 1));
                    identifiable.set(i + 1, aux);
                }
        }
        System.out.println("Idetifiable nodes are:");
        System.out.println(identifiable);
    }

    public void shortestsTimes() {
        int noIdentifiableVertex = identifiable.size();
        int noVertex = nodes.size();
        int[][] matrix = new int[noVertex][noVertex];
        int INF = 9999;

        for (int i = 0; i < noIdentifiableVertex; i++) {
            for (int j = 0; j < noVertex; j++) {
                matrix[i][j] = INF;
            }
            matrix[i][i] = 0;
        }
        for (int i = 0; i < noVertex; i++)
            for (int j = 0; j < noVertex; j++)
                if (i != j) {
                    nodes.get(i).addToMatrix(i, j, matrix, nodes.get(j));
                    //System.out.println(identifiable.get(i)+" "+nodes.get(j));
                }
        for (int k = 0; k < noVertex; k++) {
            for (int i = 0; i < noVertex; i++) {
                for (int j = 0; j < noVertex; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }

        System.out.println("\nAll shortest times from a node to another:");
        for (int i = 0; i < noVertex; ++i) {
            System.out.print(nodes.get(i) + ": ");
            for (int j = 0; j < noVertex; ++j) {
                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
         System.out.println("\nAll shortest times from an identifiable node to another:");
        for (int i = 0; i < noVertex; i++) {
            for (Node node : identifiable) {
                if (nodes.get(i).compareTo(node) == 0) {
                    System.out.print(node + ": ");
                    for (int k = 0; k < noVertex; k++) {
                        System.out.print(matrix[i][k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Network: " + "nodes=" + nodes;
    }

}
