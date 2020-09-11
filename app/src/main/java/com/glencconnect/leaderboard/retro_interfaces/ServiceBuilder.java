package com.glencconnect.leaderboard.retro_interfaces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private static Retrofit.Builder retrofit = new Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofitBuild = retrofit.build();

    public static <s> s buildService(Class<s> ServiceType){
        return retrofitBuild.create(ServiceType);
    }


//    public static String BASE_URL ="https://gadsapi.herokuapp.com//";
//    private static Retrofit retrofit;
//    public static Retrofit getClient(){
//        if(retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;

}
