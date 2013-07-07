package com.whiterabbit.bondi.client.application.footer;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class Footer extends Composite {

	interface FooterUiBinder extends UiBinder<Widget, Footer> {
	}

	@Inject
	public Footer(FooterUiBinder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
