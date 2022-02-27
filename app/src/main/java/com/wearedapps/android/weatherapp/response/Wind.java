package com.wearedapps.android.weatherapp.response;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("km")
    private int km;

    @SerializedName("mile")
    private int mile;

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getMile() {
        return mile;
    }

    public void setMile(int mile) {
        this.mile = mile;
    }
}