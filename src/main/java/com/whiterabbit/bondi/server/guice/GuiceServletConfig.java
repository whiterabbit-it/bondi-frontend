package com.whiterabbit.bondi.server.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class GuiceServletConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		final Injector injector = Guice.createInjector(new ServerModule(),
				new DispatchServletModule(), new ApplicationModule());
		return injector;
	}

}
