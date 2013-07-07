package com.whiterabbit.bondi.server.guice;

import com.google.inject.AbstractModule;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ServiceModule());
		install(new DAOModule());
	}

}
