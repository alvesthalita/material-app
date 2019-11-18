package com.example.myapplication.utils;

import android.util.Log;

/**
 * Created by thalitaa on 07/05/18.
 */

public class Logger {

    public static void log(String data) {
            Log.d("AppSegurado", data);
    }

    public static void log(String title, String data) {
            Log.d(title, data);
    }

    public static void logError(String data) {
            Log.e("AppSegurado", data);
    }

    public static void logError(String title, String data) {
            Log.e(title, data);
    }

}
