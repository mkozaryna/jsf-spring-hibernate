/**
 * 
 */
package com.jeetemplates.common.persistence.hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jeetemplates.common.model.BusinessEntity;
import com.jeetemplates.common.persistence.BusinessDao;

/**
 * Generic DAO implementation.
 * 
 * @author jeetemplates
 */
public abstract class BusinessHibernateDao<BE extends BusinessEntity> implements BusinessDao<BE> {

	/* ************************************************************** */
	/* Technical */
	/* ************************************************************** */

	/**
	 * Class of BusinessEntity
	 */
	@SuppressWarnings("unchecked")
	private Class<BE> persistentClass = (Class<BE>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	/* ************************************************************** */
	/* Dependencies */
	/* ************************************************************** */

	@PersistenceContext
	protected EntityManager entityManager;

	/* ************************************************************** */
	/* Methods */
	/* ************************************************************** */

	@Override
	public BE create(final BE entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public BE retrieveById(final Long id) {
		return entityManager.find(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BE> retrieveAll() {
		return entityManager.createQuery("from " + persistentClass.getName()).getResultList();
	}

	@Override
	public BE update(final BE entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void delete(final BE entity) {
		entityManager.remove(entity);

	}

	@Override
	public void deleteById(final Long id) {
		entityManager.remove(retrieveById(id));
	}

}
