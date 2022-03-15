import java.util.Objects;

public class Intersection {
    private String name;

    public Intersection(String name) {
        this.name = name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Intersection)) return false;
        Intersection intersection = (Intersection) o;
        return Objects.equals(name, intersection.name);
    }
}
