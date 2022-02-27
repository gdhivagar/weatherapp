package com.wearedapps.android.weatherapp.response;

import com.google.gson.annotations.SerializedName;

public class NextDaysItem {

    @SerializedName("min_temp")
    private MinTemp minTemp;

    @SerializedName("comment")
    private String comment;

    @SerializedName("iconURL")
    private String iconURL;

    @SerializedName("max_temp")
    private MaxTemp maxTemp;

    @SerializedName("day")
    private String day;

    public MinTemp getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(MinTemp minTemp) {
        this.minTemp = minTemp;
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

    public MaxTemp getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(MaxTemp maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}