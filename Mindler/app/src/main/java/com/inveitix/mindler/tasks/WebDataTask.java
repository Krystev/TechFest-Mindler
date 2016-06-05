package com.inveitix.mindler.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.inveitix.mindler.cmn.City;
import com.inveitix.mindler.cmn.DataTransferObject;
import com.inveitix.mindler.constants.Constants;
import com.inveitix.mindler.constants.QuerryTypes;
import com.inveitix.mindler.interfaces.WebDataListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class WebDataTask extends AsyncTask<Void, WebDataListener, Object> {
    private static final String TAG = "AsyncTask";
    WebDataListener listener;
    Socket socket = null;
    DataTransferObject dataTransferObject;

    public WebDataTask(WebDataListener listener, DataTransferObject dataTransferObject) {
        this.listener = listener;
        this.dataTransferObject = dataTransferObject;
    }

    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
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

    public Socket getSocket() {
        if (socket == null)
            try {
                socket = new Socket(Constants.SERVER_IP_ADDRESS, Constants.SERVER_PORT);
            } catch (IOException e) {
                e.printStackTrace();
            }

        return socket;
    }

    @Override
    protected Object doInBackground(Void... params) {
        Object result = null;
        try {
            socket = this.getSocket();
            OutputStream os = socket.getOutputStream();

            Log.e(TAG, "Sending:");
            Gson gson = new Gson();
            os.write(gson.toJson(dataTransferObject).getBytes());

            Log.e(TAG, "Receiving");
            InputStream is = socket.getInputStream();
            String resultStr = convertStreamToString(is);
            Log.e(TAG, "Service result:" + result);
            DataTransferObject dataTransferObject1 = gson.fromJson(resultStr, DataTransferObject.class);

            if (dataTransferObject1 != null) {
                result = (stringToArray(dataTransferObject1.getData(), City[].class));
            } else {
                Log.e(TAG, "Result null");
            }
            is.close();
            socket.close();

        } catch (Exception e) {
            Log.e(TAG, "Ops", e);
        }
        return result;
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        listener.listReceived(result);
    }
}
