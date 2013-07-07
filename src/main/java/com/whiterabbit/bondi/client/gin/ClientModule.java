package com.whiterabbit.bondi.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.whiterabbit.bondi.client.constants.MapsConstants;
import com.whiterabbit.bondi.client.maps.GoogleMapsLocationResolver;
import com.whiterabbit.bondi.client.maps.LocationResolver;
import com.whiterabbit.bondi.client.place.ClientPlaceManager;
import com.whiterabbit.bondi.client.place.NameTokens;

public class ClientModule extends AbstractGinModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));
		install(new DispatchAsyncModule.Builder().build());
		install(new MessageModule());
		install(new ApplicationModule());

		bind(LocationResolver.class).to(GoogleMapsLocationResolver.class).in(
				Singleton.class);

		bindApplicationConstants();
	}

	private void bindApplicationConstants() {
		bind(MapsConstants.class).in(Singleton.class);
		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.main);
	}

}
