package com.whiterabbit.bondi.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Location implements IsSerializable {

    private double latitude;

    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
