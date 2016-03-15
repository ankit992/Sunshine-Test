package com.example.android.sunshine.app.Presenters;

import android.util.Log;

import com.example.android.sunshine.app.Models.WeatherDetailModel;
import com.example.android.sunshine.app.Views.DetailFragment;
import com.example.android.sunshine.app.Views.WeatherView;

/**
 * Created by ankitarora on 15/3/16.
 */
public class WeatherDetailPresenter {
    public WeatherDetailPresenter(WeatherDetailModel model, WeatherView view){
        view.whenSyncRequired().subscribe(ignored ->model.updateWeatherData(), error -> Log.d("testingSunshineSyncError", error.toString()));
        view.whenCursorLoaderRequired().subscribe(ignored->view.setCursorLoaderData(model.returnCurserLoader(DetailFragment.mUri)),error -> Log.d("testingSunshineSyncError",error.toString()));
    }
}
