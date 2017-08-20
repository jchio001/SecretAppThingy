package com.zumperapp.jonathan.zumperapp.API.Models.Restaurant;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RestaurantBundle implements Serializable {
    @SerializedName("results")
    @Expose
    private List<RestaurantResult> restaurantResults;

    public List<RestaurantResult> getRestaurantResults() {
        return restaurantResults;
    }
}
