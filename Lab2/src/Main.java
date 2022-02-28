public class Main {
    public static void main(String[] args) {
        Event[] events = new Event[100];
        int i = 0, nrEvents, nrRooms;
        events[i++] = new Event("C1", 100, 8, 10);
        events[i++] = new Event("C2", 100, 10, 12);
        events[i++] = new Event("L1", 30, 8, 10);
        events[i++] = new Event("L2", 30, 8, 10);
        events[i++] = new Event("L3", 30, 10, 12);
        /*events[i]=new Event();
        events[i].setName("L3");
        events[i].setSize(30);
        events[i].setStart(10);
        events[i].setEnd(12);
        i++;*/
        nrEvents = i;

        Room[] rooms = new Room[100];
        i = 0;
        rooms[i++] = new Room("401", 30, Room.RoomType.LAB);
        rooms[i++] = new Room("403", 30, Room.RoomType.LAB);
        rooms[i++] = new Room("405", 30, Room.RoomType.LAB);
        rooms[i++] = new Room("309", 100, Room.RoomType.LECTURE_HALL);
        /*rooms[i]=new Room();
        rooms[i].setName("309");
        rooms[i].setCap(100);
        rooms[i].setType(Room.RoomType.LECTURE_HALL);
        i++;*/
        nrRooms = i;
        for (i = 0; i < nrEvents; i++) {
            System.out.println(events[i].getName() + ' ' + events[i].getSize() + ' ' + events[i].getStart() + ' ' + events[i].getEnd());
        }
        for (i = 0; i < nrRooms; i++) {
            System.out.println(rooms[i].getName() + ' ' + rooms[i].getCap() + ' ' + rooms[i].getType());
        }
    }
}
