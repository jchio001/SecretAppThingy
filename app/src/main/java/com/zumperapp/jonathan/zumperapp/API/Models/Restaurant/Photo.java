package com.zumperapp.jonathan.zumperapp.API.Models.Restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zumperapp.jonathan.zumperapp.API.APIConstants;

import java.io.Serializable;

public class Photo implements Serializable {
    @SerializedName("photo_reference")
    @Expose
    private String photoReference;

    public String getPhotoReference() {
        return photoReference;
    }

    public String generatePhotoUrl() {
        return "https://maps.googleapis.com/maps/api/place/photo?maxwidth=800&" +
                "photoreference=" + photoReference + "&key=" + APIConstants.KEY;
    }
}
