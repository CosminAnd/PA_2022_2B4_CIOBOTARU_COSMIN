package com.demo.repositories;

import com.demo.entities.ContinentsEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class ContinentsRepository <T, ID> implements AbstractRepository {
    private EntityManager manager;

    public ContinentsRepository( EntityManager manager1){
        manager=manager1;
    }

    public List<ContinentsEntity> findAll(){
        return manager.createNamedQuery("Continent.findAll")
                .getResultList();
    }

    @Override
    public List<ContinentsEntity> findById(Object o){
        return manager.createNamedQuery("Continent.findById")
                .setParameter("id",o)
                .getResultList();
    }
    @Override
    public List<ContinentsEntity> findByName(String name){
        return manager.createNamedQuery("Continent.findByName ")
                .setParameter("name",name)
                .getResultList();
    }

    @Override
    public void save(Object o){
        manager.persist(o);
    }
}
