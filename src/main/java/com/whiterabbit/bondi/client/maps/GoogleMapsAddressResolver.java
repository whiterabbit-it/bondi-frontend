package com.whiterabbit.bondi.client.maps;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.services.Geocoder;
import com.google.gwt.maps.client.services.GeocoderRequest;
import com.google.gwt.maps.client.services.GeocoderRequestHandler;
import com.google.gwt.maps.client.services.GeocoderResult;
import com.google.gwt.maps.client.services.GeocoderStatus;
import com.google.inject.Inject;
import com.whiterabbit.bondi.client.constants.MapsConstants;
import com.whiterabbit.bondi.shared.dto.Address;

public class GoogleMapsAddressResolver implements AddressResolver {

	private final MapsConstants mapsConstants;

	@Inject
	public GoogleMapsAddressResolver(final MapsConstants mapsConstants) {
		this.mapsConstants = mapsConstants;
	}

	@Override
	public void resolveAddress(final String address,
			final AddressResolverCallback callback) {

		GeocoderRequest request = GeocoderRequest.newInstance();

		request.setAddress(address + ", " + mapsConstants.cityName() + ", "
				+ mapsConstants.countryName());
		request.setLocation(LatLng.newInstance(mapsConstants.defaultLatitude(),
				mapsConstants.defaultLongitude()));
		Geocoder geocoder = Geocoder.newInstance();
		geocoder.geocode(request, new GeocoderRequestHandler() {
			@Override
			public void onCallback(JsArray<GeocoderResult> results,
					GeocoderStatus status) {
				if (status.equals(GeocoderStatus.OK)) {
					List<Address> locations = new ArrayList<Address>();

					for (int i = 0; i < results.length(); i++) {
						GeocoderResult result = results.get(i);

						locations.add(new Address(result.getGeometry()
								.getLocation().getLatitude(), result
								.getGeometry().getLocation().getLongitude(),
								result.getFormatted_Address()));
					}

					callback.onCallback(locations);
				} else if (status.equals(GeocoderStatus.ZERO_RESULTS)) {
					callback.onNoResults();
				} else {
					callback.onError();
				}
			}
		});
	}
}
