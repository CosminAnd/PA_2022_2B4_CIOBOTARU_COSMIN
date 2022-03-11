/**
 * Clasa Event cuprinde datele despre evenimente cat si metode specifice pentru accesarea acestor date.
 */

import java.util.Objects;
import java.time.LocalTime;


public class Event {
    private String name;
    private int size;
    private LocalTime start;
    private LocalTime end;

    public Event(String newName, int newSize, LocalTime newStart, LocalTime newEnd) {
        name = newName;
        if (newSize > 0)
            size = newSize;
        else
            System.out.println("eroare capacitate");

        start = newStart;

        if (newEnd.compareTo(start) > 0) {
            end = newEnd;
        } else
            System.out.println("eroare timp");
    }

    public String getName() {
        return this.name;
    }

    public Integer getSize() {
        return this.size;
    }

    public LocalTime getStart() {
        return this.start;
    }

    public LocalTime getEnd() {
        return this.end;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setSize(int newSize) {
        if (newSize > 0)
            size = newSize;
        else
            System.out.println("eroare capacitate");
    }

    public void setStartTime(LocalTime newStart) {
        start = newStart;
    }

    public void setEndTime(LocalTime newEnd) {
        end = newEnd;
    }

    @Override
    public String toString() {
        return "Event name: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return size == event.size && Objects.equals(name, event.name) && Objects.equals(start, event.start) && Objects.equals(end, event.end);
    }

}
