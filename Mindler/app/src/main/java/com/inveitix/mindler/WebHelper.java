package com.inveitix.mindler;

import android.util.Log;

import com.inveitix.mindler.interfaces.WebDataListener;


public class WebHelper {
    private static final String TAG = "WebHelper";
    public static WebHelper instance;
    public static String data;
    //static Socket socket;

    private WebHelper() {
//        Thread thread = new Thread(new SendDataThread());
//        thread.start();
    }

    public static WebHelper getInstance() {
        if (instance == null) {
            instance = new WebHelper();
        }
        Log.d("ClientActivity", "instance");
        return instance;
    }

    public void getCities(final WebDataListener listener) {
        new com.inveitix.mindler.WebDataTask(listener).execute();
    }
}
