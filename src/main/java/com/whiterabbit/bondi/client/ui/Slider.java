package com.whiterabbit.bondi.client.ui;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.xedge.jquery.client.JQEvent;
import com.xedge.jquery.client.JQuery;
import com.xedge.jquery.ui.client.JQueryUI;
import com.xedge.jquery.ui.client.handlers.SliderUIEventWithResultHandler;
import com.xedge.jquery.ui.client.model.SliderOptions;
import com.xedge.jquery.ui.client.model.SliderUIEventValues;

public class Slider extends Composite implements HasValue<Integer> {

	interface SliderUiBinder extends UiBinder<Widget, Slider> {
	}

	@UiField
	HTMLPanel slider;

	private int min;
	private int max;
	private int step;

	@Inject
	public Slider(final SliderUiBinder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<Integer> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@Override
	public Integer getValue() {
		JQuery jquery = JQuery.select(slider.getElement());
		JQueryUI jqueryUI = JQueryUI.getJQueryUI(jquery);
		return jqueryUI.sliderGetValue();
	}

	@Override
	public void setValue(Integer value) {
		setValue(value, false);
	}

	@Override
	public void setValue(Integer value, boolean fireEvents) {
		JQuery jquery = JQuery.select(slider.getElement());
		JQueryUI jqueryUI = JQueryUI.getJQueryUI(jquery);
		jqueryUI.sliderSetValue(value);

		if (fireEvents) {
			ValueChangeEvent.fire(this, value);
		}
	}

	@Override
	protected void onLoad() {
		super.onLoad();

		JQuery jquery = JQuery.select(slider.getElement());
		JQueryUI jqueryUI = JQueryUI.getJQueryUI(jquery);

		SliderOptions options = SliderOptions.create();
		options.setMin(min);
		options.setMax(max);
		options.setStep(step);
		options.setSlideHandler(new SliderUIEventWithResultHandler() {
			@Override
			public boolean eventComplete(JQEvent event, JQueryUI currentJQuery,
					SliderUIEventValues uiEventValues) {
				setValue(uiEventValues.getValue(), true);
				return true;
			}
		});
		jqueryUI.slider(options);
	}

}
