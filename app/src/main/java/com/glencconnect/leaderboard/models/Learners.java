package com.glencconnect.leaderboard.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Learners {

    @SerializedName("hours")
    private String hours;

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("badgeUrl")
    private String image;

    public Learners(){}

    public Learners(String hours, String name, String country, String image) {
        this.hours = hours;
        this.name = name;
        this.country = country;
        this.image = image;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    @NonNull
    @Override
    public String toString() {
        return hours + "  " + name + " " + country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
