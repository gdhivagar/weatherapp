package com.wearedapps.android.weatherapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.wearedapps.android.weatherapp.R;

public class DetailWeatherActivity extends AppCompatActivity {

    private EditText etComments;
    private EditText etDays;
    private EditText etMinTempC;
    private EditText etMinTempF;
    private EditText etMaxTempC;
    private EditText etMaxTempF;
    private String getCity, getComments, getDays, getMinTempC, getMinTempF, getMaxTempC, getMaxTempF = "";

    public static Intent newInstance(Context context,
                                     String city,
                                     String comment,
                                     String day,
                                     String minTempC,
                                     String minTempF,
                                     String maxTempC,
                                     String maxTempF) {
        Intent intent = new Intent(context, DetailWeatherActivity.class);
        intent.putExtra("city", city);
        intent.putExtra("comment", comment);
        intent.putExtra("day", day);
        intent.putExtra("minTempC", minTempC);
        intent.putExtra("minTempF", minTempF);
        intent.putExtra("maxTempC", maxTempC);
        intent.putExtra("maxTempF", maxTempF);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_weather);

        initBundle();
        initView();

    }

    private void initBundle() {
        if (getIntent() != null) {
            getCity = getIntent().getStringExtra("city");
            getComments = getIntent().getStringExtra("comment");
            getDays = getIntent().getStringExtra("day");
            getMinTempC = getIntent().getStringExtra("minTempC");
            getMinTempF = getIntent().getStringExtra("minTempF");
            getMaxTempC = getIntent().getStringExtra("maxTempC");
            getMaxTempF = getIntent().getStringExtra("maxTempF");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getCity);
    }

    private void initView() {
        etComments = findViewById(R.id.etComments);
        etDays = findViewById(R.id.etDays);
        etMinTempC = findViewById(R.id.etMinTempC);
        etMinTempF = findViewById(R.id.etMinTempF);
        etMaxTempC = findViewById(R.id.etMaxTempC);
        etMaxTempF = findViewById(R.id.etMaxTempF);

        etComments.setText(getComments);
        etDays.setText(getDays);
        etMinTempC.setText(getMinTempC);
        etMinTempF.setText(getMinTempF);
        etMaxTempC.setText(getMaxTempC);
        etMaxTempF.setText(getMaxTempF);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}