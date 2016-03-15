package com.example.android.sunshine.app.Views;
import android.support.v4.content.Loader;
import android.database.Cursor;

import rx.Observable;

/**
 * Created by ankitarora on 7/3/16.
 */
public interface WeatherView {
    Observable<Void> whenSyncRequired();

    Observable<Void> whenCursorLoaderRequired();
    void setCursorLoaderData(Loader<Cursor> cursorLoader);
}
