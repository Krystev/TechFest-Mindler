package com.inveitix.mindler;


import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inveitix.mindler.cmn.City;
import com.inveitix.mindler.constants.QuerryTypes;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class WebHelper {
    public static WebHelper instance;
    private ClientThread cThread;
    private WebHelper() {
        cThread = new ClientThread();
        Thread thread = new Thread(cThread);
        thread.start();
    }

    public static WebHelper getInstance(){
        if (instance == null) {
            instance = new WebHelper();
        }
        Log.d("ClientActivity", "instance");
        return instance;
    }

    public ArrayList<City> getCities(){
        ArrayList<City> cities = new ArrayList<>();
        DataTransferObject dataTransfer = new DataTransferObject();
        dataTransfer.setQueryType(QuerryTypes.GET_CITY);
        dataTransfer.setData(String.valueOf(-1));
        Gson gson = new Gson();
        String data = gson.toJson(dataTransfer);
        String result = "";
        Type listType = new TypeToken<ArrayList<City>>() {
        }.getType();
        try {
            cThread.sendData(data);
            result = cThread.readData();
            dataTransfer = gson.fromJson(result, DataTransferObject.class);
            cities = new Gson().fromJson(dataTransfer.getData(), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public class SendDataTask extends AsyncTask<Void, String, String> {

        @Override
        protected String doInBackground(Void... params) {
            return null;
        }
    }
}
