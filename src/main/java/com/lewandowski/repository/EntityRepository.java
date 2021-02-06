package com.lewandowski.repository;

import java.io.Serializable;
import java.util.List;

public interface EntityRepository<E> {

    List<E> findAll();
    E findById(Serializable id);
    void saveOrUpdate(E entity);
    void delete(E entity);

}
