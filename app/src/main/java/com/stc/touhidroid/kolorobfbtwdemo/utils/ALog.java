package com.stc.touhidroid.kolorobfbtwdemo.utils;

import android.util.Log;

/**
 * Created by Touhid on 1/14/2015.
 * @author Touhid
 */
public final class ALog {

    private static final boolean IS_APP_DEBUGGABLE = true;

    public static void d(String TAG, String message) {
        if (IS_APP_DEBUGGABLE)
            Log.d(TAG, message);
    }

    public static void i(String TAG, String message) {
        if (IS_APP_DEBUGGABLE)
            Log.i(TAG, message);
    }
    public static void w(String TAG, String message) {
        if (IS_APP_DEBUGGABLE)
            Log.w(TAG, message);
    }

    public static void e(String TAG, String message) {
        if (IS_APP_DEBUGGABLE)
            Log.e(TAG, message);
    }

    public static void e(String TAG, String message, Throwable exception) {
        if (IS_APP_DEBUGGABLE)
            Log.e(TAG, message, exception);
    }
}
