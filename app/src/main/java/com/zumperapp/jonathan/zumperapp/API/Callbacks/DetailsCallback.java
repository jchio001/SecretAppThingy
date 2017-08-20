package com.zumperapp.jonathan.zumperapp.API.Callbacks;

import android.util.Log;

import com.zumperapp.jonathan.zumperapp.API.APIConstants;
import com.zumperapp.jonathan.zumperapp.API.Models.Details.DetailsBundle;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailsCallback implements Callback<DetailsBundle> {
    @Override
    public void onResponse(Call<DetailsBundle> call, Response<DetailsBundle> response) {
        switch (response.code()) {
            case APIConstants.HTTP_STATUS_OK:
                EventBus.getDefault().post(response.body());
                break;
        }
    }

    @Override
    public void onFailure(Call<DetailsBundle> call, Throwable t) {
        Log.e("DetailsCallback", "Failed to make call");
    }
}
