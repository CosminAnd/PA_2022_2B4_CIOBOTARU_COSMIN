public class Street implements Comparable<Street> {
    private String name;
    private int length;
    private Intersection firstIntersection;
    private Intersection secondIntersection;

    public Street(String name, int lenght) {
        this.name = name;
        if (lenght <= 0) {
            System.out.println("Eroare, lungime negativa");
        } else {
            this.length = lenght;
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
    public int compareTo(Street o) {
        return this.length- o.length;
    }
}
