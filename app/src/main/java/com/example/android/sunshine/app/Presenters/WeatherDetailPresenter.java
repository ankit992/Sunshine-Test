package com.example.android.sunshine.app.Presenters;

import com.example.android.sunshine.app.Models.WeatherModel;
import com.example.android.sunshine.app.Views.WeatherDetailView;


public class WeatherDetailPresenter {
    WeatherDetailPresenter(WeatherModel model, WeatherDetailView view){
        model.WhenLocationInfoChanged().subscribe(ignored -> view.setWeatherListData());
        model.WhenLocationInfoChanged().subscribe();
    }
}
