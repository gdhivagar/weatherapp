package com.wearedapps.android.weatherapp.response;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    @SerializedName("contact_author")
    private ContactAuthor contactAuthor;

    @SerializedName("currentConditions")
    private CurrentConditions currentConditions;

    @SerializedName("next_days")
    private ArrayList<NextDaysItem> nextDays;

    @SerializedName("region")
    private String region;

    @SerializedName("data_source")
    private String dataSource;

    public ContactAuthor getContactAuthor() {
        return contactAuthor;
    }

    public void setContactAuthor(ContactAuthor contactAuthor) {
        this.contactAuthor = contactAuthor;
    }

    public CurrentConditions getCurrentConditions() {
        return currentConditions;
    }

    public void setCurrentConditions(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public ArrayList<NextDaysItem> getNextDays() {
        return nextDays;
    }

    public void setNextDays(ArrayList<NextDaysItem> nextDays) {
        this.nextDays = nextDays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}