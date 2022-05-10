package com.demo.repositories;

import java.util.List;

public interface AbstractRepository <T, ID> {
    //private EntityManager em;
    public abstract <S extends T> void save(S entity);
    public abstract List<T> findById(ID id);
    public abstract List<T> findByName(String name);
}
