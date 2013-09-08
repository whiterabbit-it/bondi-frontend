package com.whiterabbit.bondi.client.maps;

import java.util.List;

import com.whiterabbit.bondi.shared.dto.Address;

public interface AddressResolverCallback {

	void onCallback(List<Address> locations);

	void onNoResults();

	void onError();

}
