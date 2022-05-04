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

    public List<CitiesEntity> findById(Integer id){
        return manager.createNamedQuery("City.findById")
                .setParameter("id",id)
                .getResultList();
    }

    public List<CitiesEntity> findByName(String name){
        return manager.createNamedQuery("City.findByName ")
                .setParameter("name",name)
                .getResultList();
    }



}
