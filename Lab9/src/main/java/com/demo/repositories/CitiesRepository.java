package com.demo.repositories;

import com.demo.entities.CitiesEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class CitiesRepository {
    private EntityManager manager;

    public CitiesRepository( EntityManager manager1){
        manager=manager1;
    }

    public List<CitiesEntity> findByCountry(String country) {
        return manager.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
    }



}
