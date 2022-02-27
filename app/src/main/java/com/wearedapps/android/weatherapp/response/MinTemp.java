package com.wearedapps.android.weatherapp.response;

import com.google.gson.annotations.SerializedName;

public class MinTemp {

    @SerializedName("c")
    private int C;

    @SerializedName("f")
    private int F;

    public int getC() {
        return C;
    }

    public void setC(int C) {
        this.C = C;
    }

    public int getF() {
        return F;
    }

    public void setF(int F) {
        this.F = F;
    }
}