import java.util.Objects;

public class Street implements Comparable<Street> {
    private String name;
    private int length;
    private Intersection firstIntersection;
    private Intersection secondIntersection;

    public Street(String name, int length, Intersection firstIntersection, Intersection secondIntersection) {
        this.name = name;
        if (length <= 0) {
            System.out.println("Eroare, lungime negativa");
        } else {
            this.length = length;
        }
        if (firstIntersection != secondIntersection) {
            this.firstIntersection = firstIntersection;
            this.secondIntersection = secondIntersection;
        }
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Intersection getFirstIntersection() {
        return firstIntersection;
    }

    public Intersection getSecondIntersection() {
        return secondIntersection;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setLenght(int newLenght) {
        if (newLenght <= 0) {
            System.out.println("Eroare, lungime negativa");
        } else {
            length = newLenght;
        }
    }

    public void setFirstIntersection(Intersection newIntersection) {
        firstIntersection = newIntersection;
    }

    public void setSecondIntersection(Intersection newIntersection) {
        secondIntersection = newIntersection;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return length == street.length;
    }

    @Override
    public int compareTo(Street o) {
        return this.length - o.length;
    }
}
