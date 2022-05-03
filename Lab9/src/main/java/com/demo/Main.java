package com.demo;

import com.demo.repositories.CitiesRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){

        EMF emf = EMF.getEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        CitiesRepository citiesRepository = new CitiesRepository(em);
        System.out.println(citiesRepository.findByCountry("Spain"));
    }
}
