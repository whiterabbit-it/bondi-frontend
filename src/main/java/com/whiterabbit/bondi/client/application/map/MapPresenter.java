package com.whiterabbit.bondi.client.application.map;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;

public class MapPresenter extends Presenter<MapPresenter.MyView, MapPresenter.MyProxy> {

    public interface MyView extends View {

        void setUp();

    }

    @ProxyCodeSplit
    public interface MyProxy extends Proxy<MapPresenter> {
    }

    @Inject
    public MapPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
        super(eventBus, view, proxy);
    }

}
