package com.demo;

import com.demo.entities.ContinentsEntity;
import com.demo.repositories.CitiesRepository;
import com.demo.repositories.ContinentsRepository;
import com.demo.repositories.CountriesRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args){

        EMF emf = EMF.getEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        CitiesRepository citiesRepository = new CitiesRepository(em);
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

        System.out.println("-----Test pentru continente-----");
        ContinentsRepository continentsRepository = new ContinentsRepository(em);
        List<ContinentsEntity> continentsList = continentsRepository.findAll();
        System.out.println("Continentele sunt:");
        for(ContinentsEntity continent : continentsList)
            System.out.println(continent.toString());
        System.out.println();
        System.out.println("Cautare dupa id:");
        System.out.println(continentsRepository.findById(125).toString());
        System.out.println("Cautare dupa nume:");
        System.out.println(continentsRepository.findByName("America").toString());
        System.out.println();

        System.out.println("-----Test pentru tari-----");
        CountriesRepository countriesRepository = new CountriesRepository(em);
        System.out.println("Cautare dupa id: ");
        System.out.println(countriesRepository.findById(1).toString());
        System.out.println("Cautare dupa nume: ");
        System.out.println(countriesRepository.findByName("Germany").toString());

    }
}
