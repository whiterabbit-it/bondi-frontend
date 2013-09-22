package com.whiterabbit.bondi.client.vertx;

import com.google.gwt.core.client.JavaScriptObject;

public class Vertx extends JavaScriptObject {

	protected Vertx() {
	}
	
	public static final native VertxEventBus getEventBus(String url) /*-{
		return new $wnd.vertx.EventBus(url);
	}-*/;
	
}
