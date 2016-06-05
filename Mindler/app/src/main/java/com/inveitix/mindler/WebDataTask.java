package com.inveitix.mindler;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inveitix.mindler.cmn.City;
import com.inveitix.mindler.constants.QuerryTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class WebDataTask extends AsyncTask<Void, WebDataListener, ArrayList<City>> {
    private static final String TAG = "AsyncTask";
    WebDataListener listener;
    public WebDataTask(WebDataListener listener) {
        this.listener = listener;
    }

    @Override
    protected ArrayList<City> doInBackground(Void... params) {
        ArrayList<City> cities = null;
        try {
            Socket socket = new Socket(Constants.SERVER_IP_ADDRESS, Constants.SERVER_PORT);
            OutputStream os = socket.getOutputStream();

            Log.e(TAG, "Sending:");
            DataTransferObject dataTransferObject = new DataTransferObject();
            dataTransferObject.setData("-1");
            dataTransferObject.setQueryType(QuerryTypes.GET_CITY);
            Gson gson = new Gson();
            os.write(gson.toJson(dataTransferObject).getBytes());

            Log.e(TAG, "Receiving");
            InputStream is = socket.getInputStream();
            String result = convertStreamToString(is);
            Log.e(TAG, "Service result:" + result);
            DataTransferObject dataTransferObject1 = gson.fromJson(result, DataTransferObject.class);

            if (dataTransferObject1 != null) {
                cities = jsonToArray(dataTransferObject1.getData());
            } else {
                Log.e(TAG, "Result null");
            }
            is.close();
            socket.close();

        } catch (Exception e) {
            Log.e(TAG, "Ops", e);
        }
        return cities;
    }

    @Override
    protected void onPostExecute(ArrayList<City> cities) {
        super.onPostExecute(cities);
        listener.cityListReceived(cities);
    }

    static <T> ArrayList<T> jsonToArray(String jsonArray) {
        Type listType = new TypeToken<ArrayList<T>>() {
        }.getType();
        return new Gson().fromJson(jsonArray, listType);
    }

    static String convertStreamToString(java.io.InputStream is) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String read;

        try {
            Thread.sleep(500);
            while (br.ready()) {
                read = br.readLine();
                sb.append(read);
            }
            br.close();
        } catch (IOException e) {
            Log.e(TAG, "NOOOOOOOOOOO", e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return String.valueOf(sb);
    }
}
