package com.example.vedaversa;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("fetchData.php")
    Call<fetchPoetryModel>  fetchPoetry();
}
