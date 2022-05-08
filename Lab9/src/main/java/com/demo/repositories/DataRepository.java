package com.demo.repositories;

import java.util.List;

public abstract class DataRepository<T, ID> {

    public abstract List<T> findById(ID id);

    public abstract List<T> findByName(String name);
}
