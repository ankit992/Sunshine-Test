package com.example.android.sunshine.app.Presenters;

import com.example.android.sunshine.app.Models.WeatherModel;
import com.example.android.sunshine.app.Views.WeatherListView;

/**
 * Created by ankitarora on 7/3/16.
 */
public class WeatherListPresenter {
    WeatherListPresenter(WeatherModel model,WeatherListView view){
        model.WhenLocationInfoChanged().subscribe(ignored -> view.setWeatherListData());
    }
}
