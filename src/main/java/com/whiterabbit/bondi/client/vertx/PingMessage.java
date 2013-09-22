package com.whiterabbit.bondi.client.vertx;

import com.google.gwt.core.client.JavaScriptObject;

public class PingMessage extends JavaScriptObject {

	protected PingMessage() {
	}
	
	public static final native PingMessage create(String message) /*-{
		return {
			message: message
		};
	}-*/;
	
}
