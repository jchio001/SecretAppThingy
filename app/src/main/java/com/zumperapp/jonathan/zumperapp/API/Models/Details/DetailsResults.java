package com.zumperapp.jonathan.zumperapp.API.Models.Details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zumperapp.jonathan.zumperapp.API.Models.Restaurant.Photo;

import java.io.Serializable;
import java.util.List;


public class DetailsResults implements Serializable {
    @SerializedName("formatted_address")
    @Expose
    private String formattedAddress;

    @SerializedName("formatted_phone_number")
    @Expose
    private String formattedPhoneNumber;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("photos")
    @Expose
    private List<Photo> photos;

    @SerializedName("rating")
    @Expose
    private double rating;

    @SerializedName("reviews")
    @Expose
    private List<Review> reviews;

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
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

    public List<Review> getReviews() {
        return reviews;
    }
}
