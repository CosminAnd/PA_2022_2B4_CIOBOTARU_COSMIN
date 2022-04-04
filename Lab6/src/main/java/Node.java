
public class Node {
    private final int x;
    private final int y;
    int color;  //for color of stone and to know if it used; 0=blue, 1=red
    int stoneSize= 20;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
        color=-1;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getColor(){ return  this.color;}

    public int getStoneSize(){
        return this.stoneSize;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean compareNode(Node node) {
        return (this.x == node.getX() && this.y == node.getY());
    }

    @Override
    public String toString() {
        return "Node: x=" + x + " y=" + y;
    }
}
