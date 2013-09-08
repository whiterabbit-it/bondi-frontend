package com.whiterabbit.bondi.server.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.whiterabbit.bondi.server.dao.DomainDAO;
import com.whiterabbit.bondi.server.domain.DomainEntity;

public abstract class DomainDAOImpl<T extends DomainEntity> implements
		DomainDAO<T> {

	private final Class<T> persistedClass;
	private final EntityManager entityManager;

	public DomainDAOImpl(final Class<T> persistedClass,
			final EntityManager entityManager) {
		this.persistedClass = persistedClass;
		this.entityManager = entityManager;
	}

	@Override
	public T findById(Long id) {
		return entityManager.find(persistedClass, id);
	}

	@Override
	public List<T> getAll() {
		return null;
	}

	@Override
	public T persist(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

}
