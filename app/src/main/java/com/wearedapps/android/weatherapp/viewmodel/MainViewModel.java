package com.wearedapps.android.weatherapp.viewmodel;

import android.app.Activity;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.wearedapps.android.weatherapp.MainActivity;
import com.wearedapps.android.weatherapp.response.WeatherResponse;
import com.wearedapps.android.weatherapp.rest.CallBackAPI;
import com.wearedapps.android.weatherapp.rest.ResponseInterface;

import io.reactivex.disposables.CompositeDisposable;

public class MainViewModel extends ViewModel implements ResponseInterface {

    Activity mActivity;
    private CallBackAPI callBackAPI;
    private MutableLiveData<WeatherResponse> weatherResponseMutableLiveData =
            new MutableLiveData<WeatherResponse>();

    public LiveData<WeatherResponse> weatherResponseLiveData = weatherResponseMutableLiveData;

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void createApiObj(FragmentActivity activity) {
        callBackAPI = new CallBackAPI(activity, this);
    }

    public void requestWeather(String location) {
        callBackAPI.requestWeatherReport(MainActivity.WEATHER_API, location);
    }

    @Override
    public void onSuccess(String response, String apiName, CompositeDisposable disposable) {
        try {
            if (disposable != null && !disposable.isDisposed()) {
                disposable.dispose();
            }
            switch (apiName) {
                case "https://weatherdbi.herokuapp.com/data/weather/": {
                    WeatherResponse base = new Gson().fromJson(response, WeatherResponse.class);
                    weatherResponseMutableLiveData.setValue(base);
                }
                break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onError(String error) {
        Toast.makeText(mActivity, "Invalid query", Toast.LENGTH_SHORT).show();
    }

}