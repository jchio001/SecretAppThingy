package com.zumperapp.jonathan.zumperapp.API;


import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zumperapp.jonathan.zumperapp.API.Callbacks.DetailsCallback;
import com.zumperapp.jonathan.zumperapp.API.Callbacks.RestaurantCallback;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Retrofit is a HTTP Client that handles a lot of nastiness that goes into making & handling
// an API call for you. I like to persist my RetrofitClient in a singleton to avoid redundant
// (and long) instantiations of the client.
public class RetrofitClient {
    private static RetrofitClient instance;
    private MatchingService matchingService;

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    private RetrofitClient() {
        // Serializer that retrofit's going to use
        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // Logs stuff to monitor so I can see what's going on
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(APIConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        matchingService = retrofit.create(MatchingService.class);
    }

    public MatchingService getMatchingService() {
        return matchingService;
    }

    public static void getRestaurants(LatLng latLng) {
        getInstance()
                .getMatchingService()
                .getRestaurants(
                        String.valueOf(latLng.latitude) + "," + String.valueOf(latLng.longitude),
                        APIConstants.RANK_BY,
                        APIConstants.KEYWORD,
                        APIConstants.TYPE,
                        APIConstants.KEY)
                .enqueue(new RestaurantCallback());
    }

    public static void getDetails(String placeId) {
        getInstance()
                .getMatchingService()
                .getDetails(APIConstants.KEY, placeId)
                .enqueue(new DetailsCallback());
    }
}
