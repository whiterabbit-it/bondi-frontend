package com.whiterabbit.bondi.client.i18n;

import com.google.gwt.i18n.client.LocalizableResource;
import com.google.gwt.i18n.client.Messages;

@LocalizableResource.DefaultLocale("es")
public interface MainMessages extends Messages {

	@DefaultMessage("Tu dirección")
	String yourAddress();

	@DefaultMessage("Colectivo")
	String bus();

	@DefaultMessage("Distancia al colectivo")
	String distance();

	@DefaultMessage("{0}mts")
	String distanceDetail(Integer value);
	
	@DefaultMessage("Frecuencia estimada")
	String estimatedFrequency();
	
	@DefaultMessage("Cada {0} minutos")
	String frequencyDetail(int minutes);

}
