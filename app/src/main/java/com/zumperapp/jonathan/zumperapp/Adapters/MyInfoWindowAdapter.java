package com.zumperapp.jonathan.zumperapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.zumperapp.jonathan.zumperapp.API.Models.Restaurant.RestaurantResult;
import com.zumperapp.jonathan.zumperapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

// Custom adapter to display my custom InfoWindows for each marker
public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    @Bind(R.id.name) TextView name;
    @Bind(R.id.rating) TextView rating;

    private final Context context;

    public MyInfoWindowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View v = LayoutInflater.from(context).inflate(R.layout.info_window, null);
        ButterKnife.bind(this, v);

        name.setText(((RestaurantResult) marker.getTag()).getName());
        rating.setText(
                String.format(
                        "Rating: %.1f",
                        ((RestaurantResult) marker.getTag()).getRating()
                )
        );

        return v;
    }
}
