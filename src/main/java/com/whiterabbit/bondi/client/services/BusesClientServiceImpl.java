package com.whiterabbit.bondi.client.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.inject.Inject;
import com.whiterabbit.bondi.client.constants.VertxConstants;
import com.whiterabbit.bondi.client.vertx.Handler;
import com.whiterabbit.bondi.client.vertx.Vertx;
import com.whiterabbit.bondi.client.vertx.VertxEventBus;
import com.whiterabbit.bondi.shared.dto.Location;

public class BusesClientServiceImpl implements BusesClientService {

    private final VertxConstants constants;

    private final VertxEventBus eventBus;

    @Inject
    public BusesClientServiceImpl(final VertxConstants constants) {
        this.constants = constants;
        this.eventBus = Vertx.getEventBus(constants.serverUrl());
    }

    public void list(final String bus, final BusListCallback callback) {
        JSONObject message = new JSONObject();
        message.put("bus", new JSONString(bus));

        eventBus.publish(constants.list(), message.getJavaScriptObject(),
                new Handler<JavaScriptObject>() {
                    @Override
                    public void handle(JavaScriptObject message) {
                        List<Location> locations = new ArrayList<Location>();
                        JSONArray busPositions = new JSONArray(message);

                        for (int i = 0; i < busPositions.size(); i++) {
                            JSONObject busPosition = busPositions.get(i)
                                    .isObject();
                            double latitude = busPosition.get("latitude")
                                    .isNumber().doubleValue();
                            double longitude = busPosition.get("longitude")
                                    .isNumber().doubleValue();

                            locations.add(new Location(latitude, longitude));
                        }

                        callback.onBusesList(locations);
                    }
                });
    }

}
