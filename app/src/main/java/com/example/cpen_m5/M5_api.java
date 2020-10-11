package com.example.cpen_m5;

import retrofit2.Call;
import retrofit2.http.GET;

public interface M5_api {

    @GET("/time")
    Call<ServerTime> getTime();

}
