package com.example.gridgallery.network;

import com.example.gridgallery.model.Nasa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("bins/obhso")
    Call<List<Nasa>> getNasa();


}
