package com.demo.repositories;

import com.demo.entities.CitiesEntity;
import com.demo.entities.ContinentsEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class ContinentsRepository {
    private EntityManager manager;

    public ContinentsRepository( EntityManager manager1){
        manager=manager1;
    }

    public List<ContinentsEntity> findAll(){
        return manager.createNamedQuery("Continent.findAll")
                .getResultList();
    }

    public List<ContinentsEntity> findById(Integer id){
        return manager.createNamedQuery("Continent.findById")
                .setParameter("id",id)
                .getResultList();
    }

    public List<ContinentsEntity> findByName(String name){
        return manager.createNamedQuery("Continent.findByName ")
                .setParameter("name",name)
                .getResultList();
    }
}
