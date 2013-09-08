package com.whiterabbit.bondi.client.widget;

import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.whiterabbit.bondi.shared.dto.Address;

public class AddressSuggestion implements Suggestion {

	private final Address address;

	public AddressSuggestion(final Address address) {
		this.address = address;
	}

	@Override
	public String getDisplayString() {
		return address.getAddress();
	}

	@Override
	public String getReplacementString() {
		return address.getAddress();
	}

	public Address getAddress() {
		return address;
	}

}
