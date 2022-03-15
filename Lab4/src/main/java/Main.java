
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Street> streets = new LinkedList<>();
        Set<Intersection> intersections;
        List<Intersection> nodeList = new ArrayList<>();
        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection(("v" + i)))
                .toArray(Intersection[]::new);

        intersections = new HashSet<>(Arrays.asList(nodes));

        streets.add(new Street("s0", 20));
        streets.add(new Street("s1", 10));
        streets.add(new Street("s2", 25));
        streets.add(new Street("s3", 6));
        streets.add(new Street("s4", 22));
        streets.add(new Street("s5", 14));
        streets.add(new Street("s6", 2));
        streets.add(new Street("s7", 8));
        streets.add(new Street("s8", 6));

        System.out.println(intersections);
        streets.sort((Street o1, Street o2) -> o1.getLength() - o2.getLength());

        System.out.println(streets);

    }

}
