package com.wearedapps.android.weatherapp.rest;

import androidx.fragment.app.FragmentActivity;

import java.io.IOException;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallBackAPI {

    private final ResponseInterface res;
    private final CompositeDisposable disposable;
    FragmentActivity activity;
    private ApiInterface apiInterface;

    public CallBackAPI(FragmentActivity activity, ResponseInterface res) {
        this.activity = activity;
        this.res = res;
        apiInterface = ApiClient.getApiInterface();
        disposable = new CompositeDisposable();
    }

    public void requestWeatherReport(String api, String location) {
        try {
            Call<ResponseBody> stringCall = apiInterface.getWeatherReport(location);
            weatherResponse(api, stringCall);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void weatherResponse(String api, Call<ResponseBody> stringCall) {
        stringCall.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        res.onSuccess(response.body().string(), api, disposable);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    res.onError("Invalid query");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                res.onError("error");
            }

        });
    }

}
