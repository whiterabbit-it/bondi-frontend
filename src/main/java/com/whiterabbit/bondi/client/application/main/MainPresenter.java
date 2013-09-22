package com.whiterabbit.bondi.client.application.main;

import java.util.List;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.whiterabbit.bondi.client.application.ApplicationPresenter;
import com.whiterabbit.bondi.client.application.map.MapPresenter;
import com.whiterabbit.bondi.client.place.NameTokens;
import com.whiterabbit.bondi.client.services.BusListCallback;
import com.whiterabbit.bondi.client.services.BusesClientService;
import com.whiterabbit.bondi.client.vertx.OpenHandler;
import com.whiterabbit.bondi.client.vertx.PingMessage;
import com.whiterabbit.bondi.client.vertx.Vertx;
import com.whiterabbit.bondi.client.vertx.VertxEventBus;
import com.whiterabbit.bondi.shared.dto.Location;

public class MainPresenter extends
        Presenter<MainPresenter.MyView, MainPresenter.MyProxy> implements
        MainUiHandler {

    public interface MyView extends View, HasUiHandlers<MainUiHandler> {

        void setUp();

    }

    @ProxyCodeSplit
    @NameToken(NameTokens.main)
    public interface MyProxy extends ProxyPlace<MainPresenter> {
    }

    public static final Object SLOT_MAP = new Object();

    private final VertxEventBus vertxEventBus;
    private final MapPresenter mapPresenter;
    private final BusesClientService busesClientService;

    @Inject
    public MainPresenter(final EventBus eventBus, final MyView view,
            final MyProxy proxy, final MapPresenter mapPresenter,
            final BusesClientService busesClientService) {
        super(eventBus, view, proxy);
        this.vertxEventBus = Vertx.getEventBus("http://localhost:8181/server");
        this.vertxEventBus.onOpen(new OpenHandler() {
            @Override
            public void onOpen() {
                PingMessage message = PingMessage.create("Hello world!");
                vertxEventBus.send("bondis.client.ping", message);
            }
        });
        this.mapPresenter = mapPresenter;
        this.busesClientService = busesClientService;
        getView().setUiHandlers(this);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, ApplicationPresenter.SLOT_MAIN, this);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        setInSlot(SLOT_MAP, mapPresenter);
        getView().setUp();
    }

    @Override
    public void list(String bus) {
        busesClientService.list(bus, new BusListCallback() {
            @Override
            public void onBusesList(List<Location> locations) {
                mapPresenter.showLocations(locations);
            }
        });
    }
}
