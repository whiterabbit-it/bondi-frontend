package com.whiterabbit.bondi.server.domain;

import java.io.Serializable;

public abstract class DomainEntity implements Serializable {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
