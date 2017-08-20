package com.zumperapp.jonathan.zumperapp.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.zumperapp.jonathan.zumperapp.API.Models.Restaurant.RestaurantBundle;
import com.zumperapp.jonathan.zumperapp.API.Models.Restaurant.RestaurantResult;
import com.zumperapp.jonathan.zumperapp.API.RetrofitClient;
import com.zumperapp.jonathan.zumperapp.Adapters.MyInfoWindowAdapter;
import com.zumperapp.jonathan.zumperapp.Listener.MyInfoWindowLongClickListener;
import com.zumperapp.jonathan.zumperapp.Listener.MyMarkerListener;
import com.zumperapp.jonathan.zumperapp.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.map) MapView mapView;

    GoogleMap map;
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        MapsInitializer.initialize(this);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                setUpMap(googleMap);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        mapView.onDestroy();
    }

    @Subscribe
    public void onRestaurantResponse(RestaurantBundle resp) {
        // Need to tag each marker with its respective RestaurantResult so I have a clear way
        // to get the information associated with each tag
        for (RestaurantResult r : resp.getRestaurantResults()) {
            map.addMarker(
                    new MarkerOptions()
                            .position(r.getGeometry().getLocation().toLatLng())
                            .title(r.getName()))
                    .setTag(r);
        }
    }

    public void setUpMap(GoogleMap googleMap) {
        mapView.onResume();
        map = googleMap;
        map.setInfoWindowAdapter(new MyInfoWindowAdapter(context));
        map.setOnInfoWindowLongClickListener(new MyInfoWindowLongClickListener(context));
        map.setOnMarkerClickListener(new MyMarkerListener());
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.getUiSettings().setZoomControlsEnabled(true);

        // Coordinates for SF that I google'd up
        LatLng sf = new LatLng(37.7749, -122.4194);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(sf, 15));

        // I make API calls by interacting with my Retrofit Singleton.
        RetrofitClient.getRestaurants(sf);
    }
}
