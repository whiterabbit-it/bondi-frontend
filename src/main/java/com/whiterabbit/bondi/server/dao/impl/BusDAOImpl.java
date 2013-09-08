package com.whiterabbit.bondi.server.dao.impl;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.whiterabbit.bondi.server.dao.BusDAO;
import com.whiterabbit.bondi.server.domain.Bus;

public class BusDAOImpl extends DomainDAOImpl<Bus> implements BusDAO {

	@Inject
	public BusDAOImpl(final EntityManager entityManager) {
		super(Bus.class, entityManager);
	}

}
