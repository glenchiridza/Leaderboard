package com.glencconnect.leaderboard.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    public Post(){}

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("last_name")
    @Expose
    private String last_nmae;

    @SerializedName("projectLink")
    @Expose
    private String projectLink;

    public Post(String email, String name, String last_nmae, String projectLink) {
        this.email = email;
        this.name = name;
        this.last_nmae = last_nmae;
        this.projectLink = projectLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_nmae() {
        return last_nmae;
    }

    public void setLast_nmae(String last_nmae) {
        this.last_nmae = last_nmae;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
}
