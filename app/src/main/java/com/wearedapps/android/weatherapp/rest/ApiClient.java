package com.wearedapps.android.weatherapp.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    public static ApiInterface getApiInterface() {
        return getRetrofit().create(ApiInterface.class);
    }

    private static Retrofit getRetrofit() {

        return new Retrofit.Builder()
                .baseUrl("https://weatherdbi.herokuapp.com/data/weather/")
//                .baseUrl("pro.openweathermap.org/data/2.5/forecast/hourly")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient(getHttpLoggingInterceptor()))
                .build();

    }

    private static OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new ApiInterceptor())
                .build();
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
