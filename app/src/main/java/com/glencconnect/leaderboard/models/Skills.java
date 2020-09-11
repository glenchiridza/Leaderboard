package com.glencconnect.leaderboard.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Skills {

    @SerializedName("score")
    private String skilliq;

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("badgeUrl")
    private String image;

    public Skills(){}

    public Skills(String skilliq, String name, String country, String image) {
        this.skilliq = skilliq;
        this.name = name;
        this.country = country;
        this.image = image;
    }

    public String getSkilliq() {
        return skilliq;
    }

    public void setSkilliq(String skilliq) {
        this.skilliq = skilliq;
    }

    @NonNull
    @Override
    public String toString() {
        return skilliq + "  " + name + " " + country;
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
