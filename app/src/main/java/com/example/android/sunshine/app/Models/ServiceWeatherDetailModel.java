package com.example.android.sunshine.app.Models;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;

import com.example.android.sunshine.app.Models.data.WeatherContract;
import com.example.android.sunshine.app.Models.sync.SunshineSyncAdapter;

/**
 * Created by ankitarora on 15/3/16.
 */
public class ServiceWeatherDetailModel implements WeatherDetailModel {
    FragmentActivity context;
    public ServiceWeatherDetailModel(FragmentActivity Activity) {
        context=Activity;
    }

    private static final String[] DETAIL_COLUMNS = {
            WeatherContract.WeatherEntry.TABLE_NAME + "." + WeatherContract.WeatherEntry._ID,
            WeatherContract.WeatherEntry.COLUMN_DATE,
            WeatherContract.WeatherEntry.COLUMN_SHORT_DESC,
            WeatherContract.WeatherEntry.COLUMN_MAX_TEMP,
            WeatherContract.WeatherEntry.COLUMN_MIN_TEMP,
            WeatherContract.WeatherEntry.COLUMN_HUMIDITY,
            WeatherContract.WeatherEntry.COLUMN_PRESSURE,
            WeatherContract.WeatherEntry.COLUMN_WIND_SPEED,
            WeatherContract.WeatherEntry.COLUMN_DEGREES,
            WeatherContract.WeatherEntry.COLUMN_WEATHER_ID,
            // This works because the WeatherProvider returns location data joined with
            // weather data, even though they're stored in two different tables.
            WeatherContract.LocationEntry.COLUMN_LOCATION_SETTING
    };
    @Override
    public void updateWeatherData() {
        Log.d("testingSunshineSync", "RunningRunning");
        SunshineSyncAdapter.initializeSyncAdapter(context);
        SunshineSyncAdapter.syncImmediately(context);
    }

    @Override
    public Loader<Cursor> returnCurserLoader(Uri mUri) {
        if ( null != mUri ) {
            // Now create and return a CursorLoader that will take care of
            // creating a Cursor for the data being displayed.
            return new CursorLoader(
                    context,
                    mUri,
                    DETAIL_COLUMNS,
                    null,
                    null,
                    null
            );
        }
        return null;
    }
}
