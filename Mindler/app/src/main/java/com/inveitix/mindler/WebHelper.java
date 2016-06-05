package com.inveitix.mindler;

import android.util.Log;


public class WebHelper {
    private static final String TAG = "WebHelper";
    public static WebHelper instance;
    public static String data;

    private WebHelper() {
    }

    public static WebHelper getInstance() {
        if (instance == null) {
            instance = new WebHelper();
        }
        Log.d("ClientActivity", "instance");
        return instance;
    }

    public void getCities(final WebDataListener listener) {
        new WebDataTask(listener).execute();
    }
}
