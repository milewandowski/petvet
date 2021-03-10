package com.lewandowski.repository.impl;

import com.lewandowski.repository.EntityRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public abstract class EntityRepositoryImpl<E> implements EntityRepository<E> {

    @Autowired
    private SessionFactory sessionFactory;
    private final Class<E> entityClass;

    public EntityRepositoryImpl() {
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<E> findAll() {
        CriteriaQuery<E> cq = getSession().getCriteriaBuilder().createQuery(this.entityClass);
        Root<E> root = cq.from(this.entityClass);
        cq.select(root);

        return getSession().createQuery(cq).getResultList();
    }

    @Override
    public E findById(Serializable id) {
        return getSession().get(this.entityClass, id);
    }

    @Override
    public void saveOrUpdate(E entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(E entity) {
        getSession().delete(entity);
    }

}
