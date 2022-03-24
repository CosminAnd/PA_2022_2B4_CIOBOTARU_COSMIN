import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Intersection {
    private String name;
    private List<Street> streets = new ArrayList<>();

    public Intersection(String name) {
        this.name = name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setStreet(Street street) {
        streets.add(street);
    }

    public int getNumberOfStreets() {
        return streets.size();
    }

    public List<Street> getStreets() {
        return streets;
    }

    @Override
    public String toString() {
        return name;
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
