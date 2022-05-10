package com.demo.repositories;

import com.demo.entities.CountriesEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class CountriesRepository<T, ID> implements AbstractRepository {
    private EntityManager manager;

    public CountriesRepository(EntityManager em) {
        this.manager = em;
    }

    @Override
    public List<CountriesEntity> findByName(String name) {
        return manager.createNamedQuery("Country.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<CountriesEntity> findById(Object o) {
        return manager.createNamedQuery("Country.findById")
                .setParameter("id", o)
                .getResultList();
    }

    @Override
    public void save(Object o) {
        manager.persist(o);
    }
}
