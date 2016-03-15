package com.example.android.sunshine.app.Models;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.Loader;

/**
 * Created by ankitarora on 15/3/16.
 */
public interface WeatherDetailModel {
    void updateWeatherData();

    Loader<Cursor> returnCurserLoader(Uri mUri);
}
