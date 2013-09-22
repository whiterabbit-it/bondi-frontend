package com.whiterabbit.bondi.client.services;

public interface BusesClientService {

    void list(final String message, final BusListCallback callback);

}
