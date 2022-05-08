package com.demo.repositories;

import com.demo.entities.CitiesEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class CitiesRepository extends DataRepository<CitiesEntity, Integer> {
    private EntityManager manager;

    public CitiesRepository(EntityManager manager1) {
        manager = manager1;
    }

    public List<CitiesEntity> findByCountry(String country) {
        return manager.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
    }

    @Override
    public List<CitiesEntity> findById(Integer id) {
        return manager.createNamedQuery("City.findById")
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<CitiesEntity> findByName(String name) {
        return manager.createNamedQuery("City.findByName ")
                .setParameter("name", name)
                .getResultList();
    }


}
