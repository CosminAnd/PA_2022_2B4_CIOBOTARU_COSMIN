/**
 * Clasa Problem descrier instantele problemei.
 * Contine de asemenea metode specifice pentru afisare, adugare, setare atat evenimente cat si camere.
 */

import java.util.ArrayList;

public class Problem {
    private final ArrayList<Event> events = new ArrayList<>();
    private final ArrayList<Room> rooms = new ArrayList<>();

    public void addEvent(Event evt) {
        for (Event i : events)
            if (evt.equals(i)) //se verifica daca exista deja evenimetul evt
                return;
        events.add(evt);
    }

    public void addRoom(Room rm) {
        for (Room i : rooms)
            if (rm.equals(i)) //se verifica daca exista deja camera rm
                return;
        rooms.add(rm);
    }

    //getters
    public Event getEvent(int poz) {
        if (poz > events.size() || poz < 0)
            System.out.println("pozitie incorecta");
        return events.get(poz);
    }

    public Room getRoom(int poz) {
        if (poz > events.size() || poz < 0)
            System.out.println("pozitie incorecta");
        return rooms.get(poz);
    }

    public int getEventSize() {
        return events.size();
    }

    public int getRoomSize() {
        return rooms.size();
    }

    //setters
    public void setEvent(Event newEvent, int poz) {
        if (poz > events.size() || poz < 0)
            System.out.println("eroare pozitie");
        events.set(poz, newEvent);
    }

    public void setRoom(Room newRoom, int poz) {
        if (poz > events.size() || poz < 0)
            System.out.println("eroare pozitie");
        rooms.set(poz, newRoom);
    }

    @Override
    public String toString() {
        return "Problem{\n" + "events=" + events + ",\nrooms=" + rooms + "\n}";
    }

}
