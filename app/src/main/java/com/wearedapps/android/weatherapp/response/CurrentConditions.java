package com.wearedapps.android.weatherapp.response;

import com.google.gson.annotations.SerializedName;

public class CurrentConditions {

    @SerializedName("temp")
    private Temp temp;

    @SerializedName("precip")
    private String precip;

    @SerializedName("humidity")
    private String humidity;

    @SerializedName("comment")
    private String comment;

    @SerializedName("iconURL")
    private String iconURL;

    @SerializedName("dayhour")
    private String dayhour;

    @SerializedName("wind")
    private Wind wind;

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public String getPrecip() {
        return precip;
    }

    public void setPrecip(String precip) {
        this.precip = precip;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getDayhour() {
        return dayhour;
    }

    public void setDayhour(String dayhour) {
        this.dayhour = dayhour;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}