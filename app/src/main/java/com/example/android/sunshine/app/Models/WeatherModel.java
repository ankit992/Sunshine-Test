package com.example.android.sunshine.app.Models;

import rx.Observable;

/**
 * Created by ankitarora on 7/3/16.
 */
public interface WeatherModel {
    Observable<Void> WhenLocationInfoChanged();
    Observable<Void> WhenUnitInfoChanged();
    void updateLocation();
    void updateUnitPreference();
}
