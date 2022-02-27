package com.wearedapps.android.weatherapp.response;

import com.google.gson.annotations.SerializedName;

public class ErrorWeatherResponse {

    @SerializedName("query")
    private String query;

    @SerializedName("visit")
    private String visit;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}