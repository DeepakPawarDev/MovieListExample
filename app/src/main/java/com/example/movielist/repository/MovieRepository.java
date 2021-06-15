package com.example.movielist.repository;


import com.example.movielist.model.SearchResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MovieRepository {

    @Headers("Content-Type: application/json")
    @GET("/")
    Call<SearchResponse> getMovies(@Query("page") int pageNumber, @Query("s") String strSearchMovie, @Query("apikey") String strAPIKey);




}
