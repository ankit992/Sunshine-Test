package com.example.android.sunshine.app.Models;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by ankitarora on 7/3/16.
 */
public class ServiceWeatherModel implements WeatherModel {
    PublishSubject<Void> LocationInfoChanged = PublishSubject.create();
    PublishSubject<Void> UnitInfoChanged=PublishSubject.create();
    @Override
    public Observable<Void> WhenLocationInfoChanged() { return LocationInfoChanged.asObservable(); }
    @Override
    public Observable<Void> WhenUnitInfoChanged() { return UnitInfoChanged.asObservable(); }

    @Override
    public void updateLocation() {
        LocationInfoChanged.onNext(null);
    }

    @Override
    public void updateUnitPreference() {
UnitInfoChanged.onNext(null);
    }
}
