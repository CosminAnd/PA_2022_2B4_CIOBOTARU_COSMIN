package com.demo;

import com.demo.entities.CitiesEntity;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;

import java.util.ArrayList;
import java.util.List;

public class ChocoSolver {
    public void solve(List<CitiesEntity> first, List<CitiesEntity> allCities) {

        Model model = new Model("Solver");
        ArrayList<BoolVar> boolVarss = new ArrayList<>();

        for (CitiesEntity citiesEntity : allCities) {
            int sum = 0;
            sum = first.get(0).getPopulation() + citiesEntity.getPopulation();
            //variables
            IntVar x = model.intVar("x", sum);
            //Constraints
            model.arithm(x, ">=", 0).post();
            model.arithm(x,"<=",400000).post();


            int count = 1;
            model.setVar(String.valueOf(boolVarss));
            while (model.getSolver().solve()) {
                System.out.println("Solution " + count++ + ": " + first.get(0).getName() + ", ");
            }

        }

    }
}
