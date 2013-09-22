package com.whiterabbit.bondi.client.vertx;

import com.google.gwt.core.client.JavaScriptObject;

public class VertxEventBus extends JavaScriptObject {

	protected VertxEventBus() {
	}

	public final native void onOpen(OpenHandler callback) /*-{
		this.onopen = function() {
			callback.@com.whiterabbit.bondi.client.vertx.OpenHandler::onOpen()();
		};
	}-*/;
	
	public final native void onClose(CloseHandler callback) /*-{
		this.onclose = function() {
			callback.@com.whiterabbit.bondi.client.vertx.CloseHandler::onClose()();
		};
	}-*/;
	
	public final native void send(String address, JavaScriptObject message) /*-{
		this.send(address, message);
	}-*/;
	
	public final native void publish(String address, JavaScriptObject message) /*-{
		this.publish(address, message);
	}-*/;
	
	public final native <T extends JavaScriptObject> void registerHandler(String address, Handler<T> handler) /*-{
		this.registerHandler(address, handler);
	}-*/;

}
