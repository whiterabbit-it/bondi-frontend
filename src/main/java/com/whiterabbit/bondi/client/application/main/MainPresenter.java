package com.whiterabbit.bondi.client.application.main;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.whiterabbit.bondi.client.application.ApplicationPresenter;
import com.whiterabbit.bondi.client.application.map.MapPresenter;
import com.whiterabbit.bondi.client.place.NameTokens;

public class MainPresenter extends Presenter<MainPresenter.MyView, MainPresenter.MyProxy> {

    public interface MyView extends View {

        void setUp();

    }

    @ProxyCodeSplit
    @NameToken(NameTokens.main)
    public interface MyProxy extends ProxyPlace<MainPresenter> {
    }

    public static final Object SLOT_MAP = new Object();

    private final MapPresenter mapPresenter;

    @Inject
    public MainPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy,
            final MapPresenter mapPresenter) {
        super(eventBus, view, proxy);
        this.mapPresenter = mapPresenter;
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
}
