package com.whiterabbit.bondi.client.widget;

import com.google.gwt.user.client.ui.SuggestBox;
import com.google.inject.Inject;

public class AddressSuggestBox extends SuggestBox {

	@Inject
	public AddressSuggestBox(final AddressOracle addressOracle) {
		super(addressOracle);
	}

}
