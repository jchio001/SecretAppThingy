package com.zumperapp.jonathan.zumperapp.Listener;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.zumperapp.jonathan.zumperapp.API.APIConstants;
import com.zumperapp.jonathan.zumperapp.API.Models.Restaurant.RestaurantResult;
import com.zumperapp.jonathan.zumperapp.Activities.InfoActivity;

// Listens for a InfoWindow being held down, which indicates the user wants more information
// about a given restaurant
public class MyInfoWindowLongClickListener implements GoogleMap.OnInfoWindowLongClickListener {
    Context context;

    public MyInfoWindowLongClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onInfoWindowLongClick(Marker marker) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(
                APIConstants.PLACE_ID,
                ((RestaurantResult) marker.getTag()).getPlaceId()
        );
        context.startActivity(intent);
    }
}
