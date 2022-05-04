package com.demo.repositories;

import com.demo.entities.ContinentsEntity;
import com.demo.entities.CountriesEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class CountriesRepository {
    private EntityManager manager;

    public CountriesRepository(EntityManager em) {
        this.manager = em;
    }

    public List<CountriesEntity> findByName(String name){
        return manager.createNamedQuery("Country.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    public List<CountriesEntity> findById(Integer id){
        return manager.createNamedQuery("Country.findById")
                .setParameter("id",id)
                .getResultList();
    }
}
