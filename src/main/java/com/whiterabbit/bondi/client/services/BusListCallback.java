package com.whiterabbit.bondi.client.services;

import java.util.List;

import com.whiterabbit.bondi.shared.dto.Location;

public interface BusListCallback {

    void onBusesList(List<Location> locations);

}
