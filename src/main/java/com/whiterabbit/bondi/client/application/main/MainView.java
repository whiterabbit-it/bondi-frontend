package com.whiterabbit.bondi.client.application.main;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.whiterabbit.bondi.client.i18n.MainMessages;
import com.whiterabbit.bondi.client.ui.Slider;
import com.whiterabbit.bondi.client.widget.AddressSuggestBox;
import com.whiterabbit.bondi.client.widget.AddressSuggestion;

public class MainView extends ViewWithUiHandlers<MainUiHandler> implements
        MainPresenter.MyView {

    public interface Binder extends UiBinder<Widget, MainView> {
    }

    @UiField
    SimplePanel map;
    @UiField
    Slider distance;
    @UiField
    InlineHTML distanceDetail;
    @UiField
    AddressSuggestBox address;
    @UiField
    TextBox bus;
    @UiField
    Button list;

    private final MainMessages mainMessages;

    @Inject
    public MainView(final Binder binder, final MainMessages mainMessages) {
        this.mainMessages = mainMessages;
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void setUp() {
        distanceDetail
                .setText(mainMessages.distanceDetail(distance.getValue()));
    }

    @UiHandler("distance")
    public void onDistanceChange(ValueChangeEvent<Integer> event) {
        distanceDetail.setText(mainMessages.distanceDetail(event.getValue()));
    }

    @UiHandler("address")
    public void onSelectionAddress(SelectionEvent<Suggestion> event) {
        AddressSuggestion address = (AddressSuggestion) event.getSelectedItem();
        Window.alert(address.getAddress().getAddress());
    }

    @UiHandler("list")
    public void onList() {
        getUiHandlers().list(bus.getText());
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
