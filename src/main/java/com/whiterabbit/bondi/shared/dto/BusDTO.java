package com.whiterabbit.bondi.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class BusDTO implements IsSerializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
