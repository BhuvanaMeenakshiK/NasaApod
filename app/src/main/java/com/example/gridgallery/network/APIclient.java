package com.example.gridgallery.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIclient {

    public static String base_url="https://api.myjson.com/";


    public static Retrofit getClient(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }

    public static APIinterface apIinterface(){

        return getClient().create(APIinterface.class);
    }




}
