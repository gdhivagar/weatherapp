package com.wearedapps.android.weatherapp.rest;

import io.reactivex.disposables.CompositeDisposable;

public interface ResponseInterface {

    void onSuccess(String response, String apiName, CompositeDisposable disposable);

    void onError(String error);

}
