package com.whiterabbit.bondi.server.dao;

import java.util.List;

import com.whiterabbit.bondi.server.domain.DomainEntity;

public interface DomainDAO<T extends DomainEntity> {

	T findById(Long id);

	List<T> getAll();

	T persist(T entity);

	T update(T entity);

}
