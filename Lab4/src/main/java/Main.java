import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static boolean checkDuplicates(Set<Intersection> intersectionSet, Intersection[] intersections) {
        int[] frequency = new int[intersections.length];
        for (int i = 0; i < intersectionSet.size(); i++) {
            if (intersectionSet.contains(intersections[i]))
                frequency[i]++;
        }
        for (int j : frequency) {
            if (j > 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var intersections = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        System.out.print("Lista intersectiilor: ");
        List<Intersection> intersectionList = new ArrayList<>(Arrays.asList(intersections));
        System.out.println(intersectionList);

        List<Street> streets = new LinkedList<>();

        streets.add(new Street("s1", 2, intersections[0], intersections[1]));
        streets.add(new Street("s2", 3, intersections[1], intersections[2]));
        streets.add(new Street("s3", 1, intersections[2], intersections[3]));
        streets.add(new Street("s4", 1, intersections[3], intersections[4]));
        streets.add(new Street("s5", 4, intersections[4], intersections[5]));
        streets.add(new Street("s6", 3, intersections[5], intersections[6]));
        streets.add(new Street("s7", 2, intersections[6], intersections[0]));
        streets.add(new Street("s8", 2, intersections[0], intersections[7]));
        streets.add(new Street("s9", 2, intersections[1], intersections[7]));
        streets.add(new Street("s10", 1, intersections[2], intersections[5]));
        streets.add(new Street("s11", 2, intersections[2], intersections[4]));
        streets.add(new Street("s12", 1, intersections[3], intersections[8]));
        streets.add(new Street("s13", 1, intersections[4], intersections[8]));
        streets.add(new Street("s14", 2, intersections[5], intersections[7]));
        streets.add(new Street("s15", 1, intersections[6], intersections[7]));
        streets.add(new Street("s16", 3, intersections[7], intersections[8]));

        System.out.print("Lista strazilor: ");
        System.out.println(streets);

        System.out.print("Strazile sortate dupa lungime: ");
        Collections.sort(streets, (Street s1, Street s2) -> s1.getLength() - s2.getLength());
        System.out.println(streets);

        Set<Intersection> intersectionSet = new HashSet<>();
        for (Intersection intersection : intersections) {
            intersectionSet.add(intersection);
        }

        if (checkDuplicates(intersectionSet, intersections))
            System.out.println("Exista duplicate");
        else
            System.out.println("Nu exista duplicate");



    }

}
