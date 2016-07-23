/**
 * 
 */
package com.slober.integration.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Kunal
 *
 */
@Repository
public class HibernateUtil {
	@Autowired
	private SessionFactory sessionFactory;

	public <T> Serializable create(final T entity) {
		return sessionFactory.getCurrentSession().save(entity);
	}

	public <T> T update(final T entity) {
		sessionFactory.getCurrentSession().update(entity);
		return entity;
	}

	public <T> void delete(final T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public <T> void delete(Serializable id, Class<T> entityClass) {
		T entity = fetchById(id, entityClass);
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> fetchAll(Class<T> entityClass) {
		return sessionFactory.getCurrentSession().createQuery(" FROM " + entityClass.getName()).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public <T> List fetchAll(String query, Class<T> entityClass) {
		return sessionFactory.getCurrentSession().createQuery(query).getResultList();
	}

	@SuppressWarnings("unchecked")
	public <T> T fetch(String query, Class<T> entityClass) {
		List<T> list = sessionFactory.getCurrentSession().createQuery(query).getResultList();
		return (list.isEmpty() ? null : list.get(0));
	}

	public <T> T fetchById(Serializable id, Class<T> entityClass) {
		return (T) sessionFactory.getCurrentSession().get(entityClass, id);
	}
}
