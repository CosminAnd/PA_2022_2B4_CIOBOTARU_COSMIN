/**
 * Clasa Solution contine rezolvarea problemei.
 */

import java.util.ArrayList;

public class Solution {
    private final Problem problem;
    ArrayList<ArrayList<Event>> solution = new ArrayList<>(); //matrice pentru evenimente

    public Solution(Problem newProblem) {
        problem = newProblem;
    }

    //ordonare camere dupa marime
    public void sortRoomsBySize() {
        boolean ordo = false;
        Room aux;
        while (!ordo) {
            ordo = true;
            for (int i = 0; i < problem.getRoomSize() - 1; i++)
                if (problem.getRoom(i).getCap() > problem.getRoom(i + 1).getCap()) {
                    aux = problem.getRoom(i);
                    problem.setRoom(problem.getRoom(i + 1), i);
                    problem.setRoom(aux, i + 1);
                    ordo = false;
                }
        }
    }

    //ordonare evenimente dupa ora de sfarsit
    public void sortEventsByEnd() {
        boolean ordo = false;
        Event aux;
        while (!ordo) {
            ordo = true;
            for (int i = 0; i < problem.getEventSize() - 1; i++)
                if (problem.getEvent(i).getSize() > problem.getEvent(i + 1).getSize()) {
                    aux = problem.getEvent(i);
                    problem.setEvent(problem.getEvent(i + 1), i);
                    problem.setEvent(aux, i + 1);
                    ordo = false;
                }
        }
    }

    public void solve() {
        /*
          Aceasta rezolva problema astefel:
          - sorteaza crescator camerele dupa capacitate
          - sorteaza crescator evenimentele dupa ora de sfarsit
          - cauta o camera care sa aiba numarul minim de necesar pentru evenimentul curent
          Ideea algoritmului este cea de a alege evenimentele care se termina cat mai repede.
         */
        for (int i = 0; i < problem.getRoomSize(); i++)
            solution.add(new ArrayList<>());

        sortRoomsBySize();
        sortEventsByEnd();

        for (int i = 0; i < problem.getEventSize(); i++) {
            boolean used = false;
            for (int j = 0; j < problem.getRoomSize() && !used; j++) {
                if (problem.getEvent(i).getSize() <= problem.getRoom(j).getCap()) {
                    if (solution.get(j).isEmpty() || solution.get(j).get(solution.get(j).size() - 1).getEnd().compareTo(problem.getEvent(i).getStart()) <= 0) {
                        solution.get(j).add(problem.getEvent(i));
                        used = true;
                    }
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < problem.getRoomSize(); i++) {
            System.out.println(problem.getRoom(i) + " ->");
            for (Event j : solution.get(i))
                System.out.println(j);

            System.out.println("\n");
        }
    }

    @Override
    public String toString() {
        return problem.toString();
    }

}
