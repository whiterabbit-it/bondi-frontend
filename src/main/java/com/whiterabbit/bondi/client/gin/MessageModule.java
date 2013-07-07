package com.whiterabbit.bondi.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.whiterabbit.bondi.client.i18n.MainMessages;

public class MessageModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(MainMessages.class).in(Singleton.class);
	}

}
