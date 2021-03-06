package com.example.android.sunshine.app.Models;

import android.database.Cursor;
import android.support.v4.content.Loader;

/**
 * Created by ankitarora on 7/3/16.
 */
public interface WeatherModel {

    void updateWeatherData();

    Loader<Cursor> returnCurserLoader();
}
