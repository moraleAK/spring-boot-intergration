package com.canno.spring.boot.integration.database.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User: Rolandz
 * Date: 5/27/16
 * Time: 3:36 PM
 */
public interface GenericDao<T, KeyType> {
    T load(KeyType id);

    void persist(T t);

    T merge(T t);

    TypedQuery<T> query(String ql);

    TypedQuery<T> query(String ql, Object... args);

    List<T> getResultList(TypedQuery<T> q, int errorCode);

    <E> TypedQuery<E> queryGeneral(final String ql, final Class<E> clazz, final Object... args);

    void remove(T t);

    EntityManager getEntityManager();
}
