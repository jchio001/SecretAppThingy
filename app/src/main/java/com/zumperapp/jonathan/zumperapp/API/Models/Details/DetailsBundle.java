package com.zumperapp.jonathan.zumperapp.API.Models.Details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class DetailsBundle implements Serializable {
    @SerializedName("result")
    @Expose
    private DetailsResults detailsResults;

    public DetailsResults getDetailsResults() {
        return detailsResults;
    }
}
