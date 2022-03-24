import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    private String name;
    private final List<Intersection> intersections;
    private final List<Street> streets;
    private final Map<Intersection, List<Street>> cityMap = new HashMap<>();

    City(List<Intersection> intersections, List<Street> streets, String name) {
        this.intersections = intersections;
        this.streets = streets;
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void createMap() {
        for (Intersection intersection : intersections)
            cityMap.put(intersection, intersection.getStreets());
    }

    void printMap() {
        for (Map.Entry<Intersection, List<Street>> m : cityMap.entrySet()) {
            System.out.println(m.getKey() + ": " + m.getValue());

        }
    }

    void createQuery(int size) {
        streets.stream()
                .filter(v -> v.getLength() > size)
                .filter(v -> (v.getFirstIntersection().getNumberOfStreets() + v.getSecondIntersection().getNumberOfStreets() - 2) >= 3)
                .forEach(System.out::println);
    }

    void fakeNameForStreets() {
        //nume pentru strazi
        for (Street street : streets) {
            String faker = new Faker().address().streetName();
            street.setName(faker);
        }
    }

    void fakeNameForIntersections() {
        //nume pentru intersectii
        for (Intersection intersection : intersections) {
            String faker = new Faker().address().streetName();
            intersection.setName(faker);
        }
    }

    void solve() {
        Graph<Intersection, Street> graph = new SimpleWeightedGraph<>(Street.class);
        for (Intersection intersection : intersections) {
            graph.addVertex(intersection);
        }

        for (Street street : streets) {
            graph.addEdge(street.getFirstIntersection(), street.getSecondIntersection(), street);
            graph.setEdgeWeight(street, (double) street.getLength());
        }
        //System.out.println(graph);
        KruskalMinimumSpanningTree<Intersection, Street> kruskalMinimumSpanningTree = new KruskalMinimumSpanningTree<>(graph);
        System.out.println(kruskalMinimumSpanningTree.getSpanningTree());
    }
}
