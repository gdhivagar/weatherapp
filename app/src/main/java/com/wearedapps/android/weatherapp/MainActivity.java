package com.wearedapps.android.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wearedapps.android.weatherapp.activity.DetailWeatherActivity;
import com.wearedapps.android.weatherapp.adapter.WeatherAdapter;
import com.wearedapps.android.weatherapp.databinding.ActivityMainBinding;
import com.wearedapps.android.weatherapp.response.NextDaysItem;
import com.wearedapps.android.weatherapp.response.WeatherResponse;
import com.wearedapps.android.weatherapp.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String WEATHER_API = "https://weatherdbi.herokuapp.com/data/weather/";

    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    private ViewDataBinding mViewDataBinding;

    private EditText etLocation;
    private Button btnLookUp;
    private RecyclerView recyclerLocation;
    private WeatherAdapter weatherAdapter;

    private ProgressDialog progress;
    private String region = "";
    private ArrayList<NextDaysItem> nextDaysItemArrayList = new ArrayList<>();
    WeatherAdapter.NextDaysItemClickListener nextDaysItemClickListener = item -> {
        Intent intent = DetailWeatherActivity.newInstance(MainActivity.this,
                region,
                nextDaysItemArrayList.get(item).getComment(),
                nextDaysItemArrayList.get(item).getDay(),
                String.valueOf(nextDaysItemArrayList.get(item).getMinTemp().getC()),
                String.valueOf(nextDaysItemArrayList.get(item).getMinTemp().getF()),
                String.valueOf(nextDaysItemArrayList.get(item).getMaxTemp().getC()),
                String.valueOf(nextDaysItemArrayList.get(item).getMaxTemp().getF()));
        startActivity(intent);
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding = (ActivityMainBinding) mViewDataBinding;
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.createApiObj(MainActivity.this);
        viewModel.setActivity(MainActivity.this);

        initView();
        setProgressDialog();

        viewModel.weatherResponseLiveData.observe(this, weatherResponse -> {
            if (weatherResponse != null) {
                progress.dismiss();
                etLocation.setText("");
                nextDaysItemArrayList.clear();
                showWeatherReport(weatherResponse);
            } else {
                progress.dismiss();
                Toast.makeText(this, "Invalid query", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void initView() {
        etLocation = findViewById(R.id.etLocation);
        btnLookUp = findViewById(R.id.btnLookUp);
        recyclerLocation = findViewById(R.id.recyclerLocation);

        btnLookUp.setOnClickListener(v -> {
            String location = etLocation.getText().toString();
            if (location.isEmpty()) {
                Toast.makeText(MainActivity.this, "City name is required", Toast.LENGTH_SHORT).show();
            } else {
                progress.show();
                viewModel.requestWeather(location);
            }
        });
    }

    private void setProgressDialog() {
        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Please wait....");
        progress.setCancelable(false);
        progress.setCanceledOnTouchOutside(false);
    }

    private void showWeatherReport(WeatherResponse weatherResponse) {

        if (weatherResponse.getNextDays() != null) {
            region = weatherResponse.getRegion();
            nextDaysItemArrayList.addAll(weatherResponse.getNextDays());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            weatherAdapter = new WeatherAdapter(this, nextDaysItemArrayList, nextDaysItemClickListener);
            recyclerLocation.setLayoutManager(gridLayoutManager);
            recyclerLocation.setAdapter(weatherAdapter);
        }
    }

}