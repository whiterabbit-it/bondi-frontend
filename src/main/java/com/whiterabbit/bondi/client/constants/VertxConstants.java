package com.whiterabbit.bondi.client.constants;

import com.google.gwt.i18n.client.Constants;

public interface VertxConstants extends Constants {

    @DefaultStringValue("http://localhost:8181/server")
    String serverUrl();

    @DefaultStringValue("bondis.client.list")
    String list();

}
