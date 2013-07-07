package com.whiterabbit.bondi.client.gin;

import com.google.gwt.inject.client.Ginjector;
import com.whiterabbit.bondi.client.application.footer.Footer;
import com.whiterabbit.bondi.client.application.header.Header;
import com.whiterabbit.bondi.client.ui.Slider;

public interface BondiClientGinjector extends Ginjector {

    Header getHeader();

    Footer getFooter();

    Slider getSlider();

}
