package com.zumperapp.jonathan.zumperapp.API.Callbacks;

import android.util.Log;

import com.zumperapp.jonathan.zumperapp.API.APIConstants;
import com.zumperapp.jonathan.zumperapp.API.Models.Restaurant.RestaurantBundle;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantCallback implements Callback<RestaurantBundle> {
    @Override
    public void onResponse(Call<RestaurantBundle> call, Response<RestaurantBundle> response) {
        switch (response.code()) {
            case APIConstants.HTTP_STATUS_OK:
                EventBus.getDefault().post(response.body());
                break;
        }
    }

    @Override
    public void onFailure(Call<RestaurantBundle> call, Throwable t) {
        Log.e("RestaurantCallback", "Failed to make call");
    }
}
