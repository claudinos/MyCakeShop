package com.example.myapp.network;

import com.example.myapp.models.Cakes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpApi {
    @GET("businesses/search")
    Call<Cakes> getCakes(
            @Query("location") String location,
            @Query("term") String term
    );
}
