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
        retea.print();
    }
}
