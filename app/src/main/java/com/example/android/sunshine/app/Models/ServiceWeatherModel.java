package com.example.android.sunshine.app.Models;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;

import com.example.android.sunshine.app.Models.data.WeatherContract;
import com.example.android.sunshine.app.Models.sync.SunshineSyncAdapter;
import com.example.android.sunshine.app.Utility;

import rx.subjects.PublishSubject;

/**
 * Created by ankitarora on 7/3/16.
 */
public class ServiceWeatherModel implements WeatherModel {
    PublishSubject<Void> LocationInfoChanged = PublishSubject.create();
    PublishSubject<Void> UnitInfoChanged=PublishSubject.create();
    FragmentActivity context;
    private static final String[] FORECAST_COLUMNS = {
            // In this case the id needs to be fully qualified with a table name, since
            // the content provider joins the location & weather tables in the background
            // (both have an _id column)
            // On the one hand, that's annoying.  On the other, you can search the weather table
            // using the location set by the user, which is only in the Location table.
            // So the convenience is worth it.
            WeatherContract.WeatherEntry.TABLE_NAME + "." + WeatherContract.WeatherEntry._ID,
            WeatherContract.WeatherEntry.COLUMN_DATE,
            WeatherContract.WeatherEntry.COLUMN_SHORT_DESC,
            WeatherContract.WeatherEntry.COLUMN_MAX_TEMP,
            WeatherContract.WeatherEntry.COLUMN_MIN_TEMP,
            WeatherContract.LocationEntry.COLUMN_LOCATION_SETTING,
            WeatherContract.WeatherEntry.COLUMN_WEATHER_ID,
            WeatherContract.LocationEntry.COLUMN_COORD_LAT,
            WeatherContract.LocationEntry.COLUMN_COORD_LONG
    };

    // These indices are tied to FORECAST_COLUMNS.  If FORECAST_COLUMNS changes, these
    // must change.

    public ServiceWeatherModel(FragmentActivity Activity) {
        context=Activity;
        SunshineSyncAdapter.initializeSyncAdapter(context);
    }

    @Override
    public void updateWeatherData() {
        Log.d("testingSunshineSync","RunningRunning");
        SunshineSyncAdapter.initializeSyncAdapter(context);
        SunshineSyncAdapter.syncImmediately(context);
    }

    @Override
    public Loader<Cursor> returnCurserLoader() {
        String sortOrder = WeatherContract.WeatherEntry.COLUMN_DATE + " ASC";

        String locationSetting = Utility.getPreferredLocation(context);
        Uri weatherForLocationUri = WeatherContract.WeatherEntry.buildWeatherLocationWithStartDate(
                locationSetting, System.currentTimeMillis());

        return new CursorLoader(context,
                weatherForLocationUri,
                FORECAST_COLUMNS,
                null,
                null,
                sortOrder);
    }
}
