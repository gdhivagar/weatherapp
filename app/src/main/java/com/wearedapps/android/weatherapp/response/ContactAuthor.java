package com.wearedapps.android.weatherapp.response;

import com.google.gson.annotations.SerializedName;

public class ContactAuthor {

    @SerializedName("auth_note")
    private String authNote;

    @SerializedName("email")
    private String email;

    public String getAuthNote() {
        return authNote;
    }

    public void setAuthNote(String authNote) {
        this.authNote = authNote;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}