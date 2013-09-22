package com.whiterabbit.bondi.client.application.map;

import java.util.List;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.whiterabbit.bondi.shared.dto.Location;

public class MapPresenter extends
        Presenter<MapPresenter.MyView, MapPresenter.MyProxy> {

    public interface MyView extends View {

        void setUp();

        void showLocations(List<Location> locations);

        void clearLocations();

    }

    @ProxyCodeSplit
    public interface MyProxy extends Proxy<MapPresenter> {
    }

    @Inject
    public MapPresenter(final EventBus eventBus, final MyView view,
            final MyProxy proxy) {
        super(eventBus, view, proxy);
    }

    public void showLocations(List<Location> locations) {
        getView().clearLocations();
        getView().showLocations(locations);
    }

}
