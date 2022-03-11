import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Network retea = new Network();
        Node v1 = new Computer("1234", 200);
        v1.setName("Computer A");
        retea.addNode(v1);

        Node v2 = new Router("55664");
        v2.setName("Router A");
        retea.addNode(v2);

        Node v3 = new Switch();
        v3.setName("Switch A");
        retea.addNode(v3);

        Node v4 = new Switch();
        v4.setName("Switch B");
        retea.addNode(v4);

        Node v5 = new Router();
        v5.setAddress("74673");
        v5.setName("Router B");
        retea.addNode(v5);

        Node v6 = new Computer();
        v6.setName("Computer B");
        v6.setAddress("657");
        v6.setStorageCapacity(256);
        retea.addNode(v6);
        retea.sortAllNodes(); //sortarea nodurilor

        retea.print();

        //PENTRU V1
        retea.getNode(0).setCost(v2,10); //v1-v2
        retea.getNode(0).setCost(v3,50); //v1-v3

        //PENTRU V2
        retea.getNode(1).setCost(v3,20); //v2-v3
        retea.getNode(1).setCost(v4,20); //v2-v4
        retea.getNode(1).setCost(v5,20); //v2-v5

        //PENTRU V3
        retea.getNode(2).setCost(v4,10); //v3-v4

        //PENTRU V4
        retea.getNode(3).setCost(v5,30); //v4-v5
        retea.getNode(3).setCost(v6,10); //v4-v6

        //PENTRU V5
        retea.getNode(4).setCost(v5,20); //v5-v6




    }
}
