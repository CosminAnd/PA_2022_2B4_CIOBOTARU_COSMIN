/**
 * Aceasta aplicatie rezolva problema minimizarii numarului de sali folosite pentru organizarea mai multor evenimente
 * In acest program avem urmatoarele clase: Main, LectureHall.Event, Room, ComputerLab, LectureHall, Problem, Solution.
 *
 * @author Ciobotaru Cosmin
 * @version 1.0
 * @since 07.03.2022
 */

import java.time.LocalTime;


public class Main {
    public static void main(String[] args) {
        Event event1 = new Event("C1", 100, LocalTime.of(8, 0, 0), LocalTime.of(10, 0, 0));
        Event event2 = new Event("C2", 100, LocalTime.of(10, 0, 0), LocalTime.of(12, 0, 0));
        Event event3 = new Event("L1", 30, LocalTime.of(8, 0, 0), LocalTime.of(10, 0, 0));
        Event event4 = new Event("L2", 30, LocalTime.of(8, 0, 0), LocalTime.of(10, 0, 0));
        Event event5 = new Event("L3", 30, LocalTime.of(10, 0, 0), LocalTime.of(12, 0, 0));

        Room room1 = new ComputerLab("401", 30, "Linux");
        Room room2 = new ComputerLab("403", 30, "Windows");
        Room room3 = new ComputerLab("405", 30, "Ubuntu");
        Room room4 = new LectureHall("309", 100, false);

        Problem problem = new Problem();
        //adaugare evenimente
        problem.addEvent(event1);
        problem.addEvent(event2);
        problem.addEvent(event3);
        problem.addEvent(event4);
        problem.addEvent(event5);
        //adaugare camere
        problem.addRoom(room1);
        problem.addRoom(room2);
        problem.addRoom(room3);
        problem.addRoom(room4);

        Solution solution = new Solution(problem);

        solution.solve();
        solution.print();

    }
}
