package com.wearedapps.android.weatherapp.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("https://weatherdbi.herokuapp.com/data/weather/{location}")
    Call<ResponseBody> getWeatherReport(@Path("location") String location);

}
