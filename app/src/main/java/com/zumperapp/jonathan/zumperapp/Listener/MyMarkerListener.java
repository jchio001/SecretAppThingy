package com.zumperapp.jonathan.zumperapp.Listener;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

// Marker listener for map markers. Unsure if this is needed, but I implemented anyways since
// there could be things I want to do here in the future.
public class MyMarkerListener implements GoogleMap.OnMarkerClickListener {
    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        return true;
    }
}
