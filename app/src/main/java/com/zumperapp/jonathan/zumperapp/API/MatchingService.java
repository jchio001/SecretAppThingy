package com.zumperapp.jonathan.zumperapp.API;


import com.zumperapp.jonathan.zumperapp.API.Models.Details.DetailsBundle;
import com.zumperapp.jonathan.zumperapp.API.Models.Restaurant.RestaurantBundle;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// These represent the API urls I'm interacting with and the parameters they take in
public interface MatchingService {
    @GET("place/nearbysearch/json")
    Call<RestaurantBundle> getRestaurants(@Query("location") String location,
                                          @Query("rankby") String rankBy,
                                          @Query("keyword") String keyword,
                                          @Query("type") String type,
                                          @Query("key") String key);


    @GET("place/details/json")
    Call<DetailsBundle> getDetails(@Query("key") String key,
                                   @Query("placeid") String placeId);
}
