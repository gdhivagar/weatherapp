package com.wearedapps.android.weatherapp.rest;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class ApiInterceptor implements Interceptor {

    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_ACCEPT = "Accept";
    private static final String APPLICATION_TYPE = "application/json";

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request chainRequest = chain.request();
        Builder builder = chainRequest.newBuilder();
        builder.header(HEADER_CONTENT_TYPE, APPLICATION_TYPE);
        builder.header(HEADER_ACCEPT, APPLICATION_TYPE);
        Request request = builder.build();
        return chain.proceed(request);
    }
}
