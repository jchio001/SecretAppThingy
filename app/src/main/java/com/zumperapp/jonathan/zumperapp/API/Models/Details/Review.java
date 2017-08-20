package com.zumperapp.jonathan.zumperapp.API.Models.Details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Review implements Serializable {
    @SerializedName("author_name")
    @Expose
    private String authorName;

    @SerializedName("relative_time_description")
    @Expose
    private String relativeTimeDescription;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("rating")
    @Expose
    private int rating;

    public String getAuthorName() {
        return authorName;
    }

    public String getRelativeTimeDescription() {
        return relativeTimeDescription;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }
}
