package com.demo;


import com.demo.entities.CitiesEntity;
import com.demo.entities.ContinentsEntity;
import com.demo.entities.CountriesEntity;
import com.demo.repositories.CitiesRepository;
import com.demo.repositories.ContinentsRepository;
import com.demo.repositories.CountriesRepository;
import org.eclipse.persistence.sessions.SessionProfiler;
import org.eclipse.persistence.tools.profiler.PerformanceMonitor;


import javax.persistence.EntityManager;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        EMF emf = EMF.getEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        CitiesRepository citiesRepository = new CitiesRepository(em);
        CountriesRepository countriesRepository = new CountriesRepository(em);
        ContinentsRepository continentsRepository = new ContinentsRepository(em);

        //teste pentru orase
        /*CitiesEntity citiesEntity = new CitiesEntity(BigInteger.valueOf(99999), "Germany", "Dortmund", BigInteger.valueOf(0),
                51.514244, 7.468429, 1000);
        citiesRepository.save(citiesEntity);
         */

        System.out.println("-----Test pentru orase-----");
        System.out.println("Cautare dupa tara:");
        System.out.println(citiesRepository.findByCountry("Spain").toString());
        System.out.println();
        System.out.println("Cautare dupa id:");
        System.out.println(citiesRepository.findById(202).toString());
        System.out.println();
        System.out.println("Cautare dupa nume:");
        System.out.println(citiesRepository.findByName("Bucharest").toString());
        System.out.println();


        //teste pentru continente
        System.out.println("-----Test pentru continente-----");
        List<ContinentsEntity> continentsList = continentsRepository.findAll();

        /*ContinentsEntity continentsEntity = new ContinentsEntity(127,"Africa");
        continentsRepository.save(continentsEntity);
        */

        System.out.println("Continentele sunt:");
        for (ContinentsEntity continent : continentsList)
            System.out.println(continent.toString());
        System.out.println();
        System.out.println("Cautare dupa id:");
        System.out.println(continentsRepository.findById(125).toString());
        System.out.println("Cautare dupa nume:");
        System.out.println(continentsRepository.findByName("America").toString());
        System.out.println();

        //teste pentru tari
        System.out.println("-----Test pentru tari-----");
        /*CountriesEntity countriesEntity = new CountriesEntity((long) 9999, "Vatican", "VT",
                "Europe");
        countriesRepository.save(countriesEntity);
         */

        System.out.println("Cautare dupa id: ");
        System.out.println(countriesRepository.findById(1).toString());
        System.out.println("Cautare dupa nume: ");
        System.out.println(countriesRepository.findByName("Germany").toString());


        /*long start = System.currentTimeMillis();
        CitiesEntity citiesEntity = new CitiesEntity(BigInteger.valueOf(12345), "Germany", "Munchen", BigInteger.valueOf(0),
                51.514244, 7.468429, 1000);
        citiesRepository.save(citiesEntity);

        CitiesEntity citiesEntity = new CitiesEntity(BigInteger.valueOf(12346), "Germany", "Leipzig", BigInteger.valueOf(0),
                51.514244, 7.468429, 1000);
        citiesRepository.save(citiesEntity);

        CitiesEntity citiesEntity = new CitiesEntity(BigInteger.valueOf(12347), "Germany", "Stuttgart", BigInteger.valueOf(0),
                51.514244, 7.468429, 1000);
        citiesRepository.save(citiesEntity);

        long end = System.currentTimeMillis();
        System.out.println("Time of adding cities is " + (end - start) + " ms");
        em.getTransaction().commit();
         */

        /*ChocoSolver chocoSolver = new ChocoSolver();
        chocoSolver.solve(citiesRepository.findById(2), citiesRepository.findAll());
         */



    }
}
