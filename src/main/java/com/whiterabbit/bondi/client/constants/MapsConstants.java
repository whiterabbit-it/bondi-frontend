package com.whiterabbit.bondi.client.constants;

import com.google.gwt.i18n.client.Constants;

public interface MapsConstants extends Constants {

	@DefaultStringValue("CABA")
	String cityName();

	@DefaultStringValue("Argentina")
	String countryName();
	
	@DefaultDoubleValue(-34.615852)
	double defaultLatitude();
	
	@DefaultDoubleValue(-58.4333)
	double defaultLongitude();
	
	@DefaultIntValue(12)
	int defaultZoom();
	
	@DefaultIntValue(15)
    int defaultLocationZoom();

}
