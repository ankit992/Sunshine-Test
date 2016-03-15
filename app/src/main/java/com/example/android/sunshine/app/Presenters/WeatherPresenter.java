package com.example.android.sunshine.app.Presenters;

import android.util.Log;

import com.example.android.sunshine.app.Models.WeatherModel;
import com.example.android.sunshine.app.Views.WeatherView;


public class WeatherPresenter {
    public WeatherPresenter(WeatherModel model, WeatherView view){
        view.whenSyncRequired().subscribe(ignored ->model.updateWeatherData(), error -> Log.d("testingSunshineSyncError",error.toString()));
        view.whenCursorLoaderRequired().subscribe(ignored->view.setCursorLoaderData(model.returnCurserLoader()),error -> Log.d("testingSunshineSyncError",error.toString()));
    }
}
