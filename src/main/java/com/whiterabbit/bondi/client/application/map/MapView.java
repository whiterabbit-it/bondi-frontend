package com.whiterabbit.bondi.client.application.map;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.maps.client.overlays.MarkerOptions;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.whiterabbit.bondi.client.constants.MapsConstants;
import com.whiterabbit.bondi.shared.dto.Location;

public class MapView extends ViewImpl implements MapPresenter.MyView {

    public interface Binder extends UiBinder<Widget, MapView> {
    }

    @UiField
    HTMLPanel content;

    private final MapsConstants mapsConstants;
    private MapWidget map;
    private List<Marker> markers;

    @Inject
    public MapView(final Binder binder, final MapsConstants mapsConstants) {
        this.mapsConstants = mapsConstants;
        this.markers = new ArrayList<Marker>();
        initWidget(binder.createAndBindUi(this));
        loadMapsAPI();
    }

    @Override
    public void setUp() {
        MapOptions options = createMapOptions(mapsConstants.defaultLatitude(),
                mapsConstants.defaultLongitude(), mapsConstants.defaultZoom());
        map.setOptions(options);
    }

    @Override
    public void showLocations(List<Location> locations) {
        for (Location location : locations) {
            LatLng latlng = LatLng.newInstance(location.getLatitude(),
                    location.getLongitude());
            final MarkerOptions options = MarkerOptions.newInstance();
            options.setPosition(latlng);
            options.setMap(map);

            final Marker marker = Marker.newInstance(options);

            markers.add(marker);
        }
    }

    @Override
    public void clearLocations() {
        for (Marker marker : markers) {
            marker.clear();
        }

        markers.clear();
    }

    private MapOptions createMapOptions(double latitude, double longitude,
            int zoom) {
        LatLng mainLocation = LatLng.newInstance(latitude, longitude);
        MapOptions options = MapOptions.newInstance();
        options.setCenter(mainLocation);
        options.setZoom(zoom);
        return options;
    }

    private void loadMapsAPI() {
        ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
        loadLibraries.add(LoadLibrary.GEOMETRY);
        loadLibraries.add(LoadLibrary.VISUALIZATION);
        loadLibraries.add(LoadLibrary.DRAWING);

        Runnable onLoad = new Runnable() {
            @Override
            public void run() {
                map = createMap();
                map.setSize("100%", "450px");

                content.clear();
                content.setSize("100%", "450px");
                content.add(map);
            }
        };

        LoadApi.go(onLoad, loadLibraries, true);
    }

    private MapWidget createMap() {
        LatLng mainLocation = LatLng.newInstance(
                mapsConstants.defaultLatitude(),
                mapsConstants.defaultLongitude());
        MapOptions options = MapOptions.newInstance();
        options.setCenter(mainLocation);
        options.setZoom(mapsConstants.defaultZoom());
        return new MapWidget(options);
    }

}
