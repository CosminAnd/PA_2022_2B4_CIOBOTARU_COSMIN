package com.demo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
    private static EMF emf = null;
    private EntityManagerFactory entityManagerFactory = null;
    private EMF(String name) {entityManagerFactory = Persistence.createEntityManagerFactory(name);}

    public static EMF getEntityManagerFactory(String name) {
        if (emf == null) {
            emf = new EMF(name);
        }
        return emf;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
