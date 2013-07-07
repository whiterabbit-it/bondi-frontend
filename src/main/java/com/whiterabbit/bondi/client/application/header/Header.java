package com.whiterabbit.bondi.client.application.header;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class Header extends Composite {

	interface HeaderUiBinder extends UiBinder<Widget, Header> {
	}

	@Inject
	public Header(HeaderUiBinder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
