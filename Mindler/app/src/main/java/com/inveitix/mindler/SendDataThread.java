package com.inveitix.mindler;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Tito on 4.6.2016 г..
 */
public class SendDataThread implements Runnable {
    static Socket socket;
    @Override
    public void run() {
        InetAddress serverAddr = null;

        try {
            serverAddr = InetAddress.getByName(Constants.SERVER_IP_ADDRESS);
            socket = new Socket(serverAddr, Constants.SERVER_PORT);
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                    .getOutputStream())), true);
            if (WebHelper.data != null){
                out.println(WebHelper.data);
            } else {
                Log.e("TAG", "Data is null");
            }
        } catch (IOException e) {
            Log.e("TAG", "Error", e);
        }
    }
}
