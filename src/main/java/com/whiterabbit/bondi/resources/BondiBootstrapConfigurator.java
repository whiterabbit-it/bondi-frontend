package com.whiterabbit.bondi.resources;

import com.github.gwtbootstrap.client.ui.config.Configurator;
import com.github.gwtbootstrap.client.ui.resources.Resources;
import com.google.gwt.core.shared.GWT;

public class BondiBootstrapConfigurator implements Configurator {

    @Override
    public Resources getResources() {
        return GWT.create(BondiBootstrapResource.class);
    }

    @Override
    public boolean hasResponsiveDesign() {
        return false;
    }

}
