package com.kardusinfo.katalogfilm.api;

import com.kardusinfo.katalogfilm.models.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {
    @GET("/shows/1/cast")
    Call<List<Movie>> getMovieList();
}
