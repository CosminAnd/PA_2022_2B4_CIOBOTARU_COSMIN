package com.demo.repositories;

import com.demo.entities.CitiesEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class CitiesRepository <T, ID> implements AbstractRepository {
    private EntityManager manager;

    public CitiesRepository(EntityManager manager1) {
        manager = manager1;
    }

    public List<CitiesEntity> findByCountry(String country) {
        return manager.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
    }

    public List<CitiesEntity> findAll(){
        return manager.createNamedQuery("City.findAll")
                .getResultList();
    }

    @Override
    public List<CitiesEntity> findById(Object o) {
        return manager.createNamedQuery("City.findById")
                .setParameter("id", o)
                .getResultList();
    }

    @Override
    public List<T> findByName(String name) {
        return manager.createNamedQuery("City.findByName ")
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public void save(Object object){
        manager.persist(object);
    }


}
