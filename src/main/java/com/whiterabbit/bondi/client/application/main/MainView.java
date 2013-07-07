package com.whiterabbit.bondi.client.application.main;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.whiterabbit.bondi.client.i18n.MainMessages;
import com.whiterabbit.bondi.client.ui.Slider;

public class MainView extends ViewImpl implements MainPresenter.MyView {

    public interface Binder extends UiBinder<Widget, MainView> {
    }

    @UiField
    SimplePanel map;
    @UiField
    Slider distance;
    @UiField
    InlineHTML distanceDetail;
    // @UiField
    // InlineHTML frequencyDetail;

    private final MainMessages mainMessages;

    @Inject
    public MainView(final Binder binder, final MainMessages mainMessages) {
        this.mainMessages = mainMessages;
        initWidget(binder.createAndBindUi(this));
    }

    @UiHandler("distance")
    public void onDistanceChange(ValueChangeEvent<Integer> event) {
        distanceDetail.setText(mainMessages.distanceDetail(event.getValue()));
    }

    @Override
    public void setUp() {
        distanceDetail.setText(mainMessages.distanceDetail(distance.getValue()));
        // frequencyDetail.setText(mainMessages.frequencyDetail(5));
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == MainPresenter.SLOT_MAP) {
            map.setWidget(content);
        } else {
            super.setInSlot(slot, content);
        }
    }

}
