package com.glencconnect.leaderboard.retro_interfaces;

import com.glencconnect.leaderboard.models.Learners;
import com.glencconnect.leaderboard.models.Skills;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrieveLeaders {
//    Base URL - https://gadsapi.herokuapp.com

//    @GET("/api/{hours}")
//    Call<String> hoursList(@Path("hours") String full_name);
//
//    @GET("/api/{skilliq}")
//    Call<List<Learners>> skillsList(@Path("skilliq") String full_name);

    @GET("api/hours")
    Call<List<Learners>> getHoursBoard();

    @GET("api/skilliq")
    Call<List<Skills>> getIQBoard();
 }
