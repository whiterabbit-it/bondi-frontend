package com.whiterabbit.bondi.client.vertx;

import com.google.gwt.core.client.JavaScriptObject;

public interface Handler<T extends JavaScriptObject> {

	void handle(T message);
	
}
