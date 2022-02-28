import java.util.Objects;

public class Room {
    public enum RoomType {
        LECTURE_HALL,
        LAB,
    }

    private String name;
    private Integer cap;
    private RoomType type;

    //constructor
    public Room(String name, Integer cap, RoomType type) {
        this.name = name;
        this.cap = cap;
        this.type = type;
    }

    public Room() {

    }

    //getters for class Room
    public String getName() {
        return name;
    }

    public Integer getCap() {
        return cap;
    }

    public RoomType getType() {
        return type;
    }

    //setters for class Room
    public void setName(String newName) {
        this.name = newName;
    }

    public void setCap(Integer newCap) {
        this.cap = newCap;
    }

    public void setType(RoomType newType) {
        this.type = newType;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return name.equals(room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
