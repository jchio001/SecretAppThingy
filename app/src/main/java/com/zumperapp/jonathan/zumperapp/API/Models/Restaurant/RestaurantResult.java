package com.zumperapp.jonathan.zumperapp.API.Models.Restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RestaurantResult implements Serializable {
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("photos")
    @Expose
    private List<Photo> photos;

    @SerializedName("rating")
    @Expose
    private double rating;

    @SerializedName("place_id")
    @Expose
    private String placeId;

    public Geometry getGeometry() {
        return geometry;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public double getRating() {
        return rating;
    }

    public String getPlaceId() {
        return placeId;
    }
}
