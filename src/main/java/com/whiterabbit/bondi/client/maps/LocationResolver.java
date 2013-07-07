package com.whiterabbit.bondi.client.maps;

public interface LocationResolver {

	void resolveLocation(String address, PositionResolverCallback callback);

}
