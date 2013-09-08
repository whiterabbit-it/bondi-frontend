package com.whiterabbit.bondi.client.widget;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.inject.Inject;
import com.whiterabbit.bondi.client.constants.ApplicationConstants;
import com.whiterabbit.bondi.client.maps.AddressResolver;
import com.whiterabbit.bondi.client.maps.AddressResolverCallback;
import com.whiterabbit.bondi.shared.dto.Address;

public class AddressOracle extends SuggestOracle {

	private final ApplicationConstants applicationConstants;

	private final AddressResolver locationResolver;

	@Inject
	public AddressOracle(final ApplicationConstants applicationConstants,
			final AddressResolver locationResolver) {
		this.applicationConstants = applicationConstants;
		this.locationResolver = locationResolver;
	}

	@Override
	public void requestSuggestions(final Request request,
			final Callback callback) {
		String address = request.getQuery();

		if (address.length() > applicationConstants.minAddressLength()) {
			locationResolver.resolveAddress(address,
					new AddressResolverCallback() {
						@Override
						public void onNoResults() {
							GWT.log("No results found");
						}

						@Override
						public void onError() {
							GWT.log("Error on address resolution");
						}

						@Override
						public void onCallback(List<Address> locations) {
							Collection<Suggestion> result = new ArrayList<SuggestOracle.Suggestion>();
							for (Address address : locations) {
								result.add(new AddressSuggestion(address));
							}
							Response response = new Response(result);

							callback.onSuggestionsReady(request, response);
						}
					});
		} else {
			Response response = new Response(Collections.<Suggestion> emptyList());
			callback.onSuggestionsReady(request, response);
		}
	}

}
