import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

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

        streets.add(new Street("s0", 2, intersections[0], intersections[8]));
        streets.add(new Street("s1", 2, intersections[0], intersections[7]));
        streets.add(new Street("s2", 2, intersections[0], intersections[1]));
        streets.add(new Street("s3", 2, intersections[1], intersections[7]));
        streets.add(new Street("s4", 3, intersections[1], intersections[2]));
        streets.add(new Street("s5", 1, intersections[2], intersections[6]));
        streets.add(new Street("s6", 2, intersections[2], intersections[4]));
        streets.add(new Street("s7", 1, intersections[2], intersections[3]));
        streets.add(new Street("s8", 1, intersections[3], intersections[5]));
        streets.add(new Street("s9", 1, intersections[3], intersections[4]));
        streets.add(new Street("s10", 1, intersections[4], intersections[5]));
        streets.add(new Street("s11", 2, intersections[5], intersections[7]));
        streets.add(new Street("s12", 3, intersections[4], intersections[6]));
        streets.add(new Street("s13", 2, intersections[7], intersections[6]));
        streets.add(new Street("s14", 3, intersections[6], intersections[8]));
        streets.add(new Street("s15", 1, intersections[7], intersections[8]));

        System.out.print("Lista strazilor: ");
        System.out.println(streets);

        //Pentru fiecare intersectie se adauga strazile pe care le conecteaza
        for (Street street : streets) {
            street.getFirstIntersection().setStreet(street);
            street.getSecondIntersection().setStreet(street);
        }
        for (int i = 0; i < 9; i++) {
            System.out.println("Intersectia " + intersectionList.get(i) + " se intersecteaza cu strazile: ");
            System.out.println(intersectionList.get(i).getStreets());
        }

        System.out.print("Strazile sortate dupa lungime: ");
        streets.sort((Street s1, Street s2) -> s1.getLength() - s2.getLength());
        System.out.println(streets);


        Set<Intersection> intersectionSet = new HashSet<>();
        Collections.addAll(intersectionSet, intersections);

        if (checkDuplicates(intersectionSet, intersections))
            System.out.println("Exista duplicate");
        else
            System.out.println("Nu exista duplicate");

        City city = new City(intersectionList, streets, "My City");

        city.createMap();
        System.out.println(city.getName() + ":");
        city.printMap();

        int size = Integer.parseInt(args[0]);
        System.out.println("Strazile mai lungi decat " + size + " si care se intersecteaza cu cel putin alte 3 strazi sunt:");
        city.createQuery(size);

        city.fakeNameForStreets();
        city.fakeNameForIntersections();

        city.solve();

    }

}
