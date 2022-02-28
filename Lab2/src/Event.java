import java.util.Objects;

public class Event {
    private String name;
    private Integer size;
    private Integer start;
    private Integer end;

    //constructor
    public Event(String name, Integer size, Integer start, Integer end) {
        this.name = name;
        this.size = size;
        this.start = start;
        this.end = end;
    }

    public Event() {
    }

    //getters for class Event
    public String getName() {
        return this.name;
    }

    public Integer getSize() {
        return this.size;
    }

    public Integer getStart() {
        return this.start;
    }

    public Integer getEnd() {
        return this.end;
    }

    //Setters for class Event
    public void setName(String newName) {
        this.name = newName;
    }

    public void setSize(Integer newSize) {
        this.size = newSize;
    }

    public void setStart(Integer newStart) {
        this.start = newStart;
    }

    public void setEnd(Integer newEnd) {
        this.end = newEnd;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return name.equals(event.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
