package com.inveitix.mindler;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Tito on 4.6.2016 г..
 */
public class ClientThread implements Runnable {

    Socket socket;

    public void run() {

        InetAddress serverAddr = null;

        try {
            serverAddr = InetAddress.getByName(Constants.SERVER_IP_ADDRESS);
            socket = new Socket(serverAddr, Constants.SERVER_PORT);
            Log.d("ClientActivity", "C: Connecting...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendData(String data) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                .getOutputStream())), true);
        out.println(data);
    }

    public String readData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return reader.readLine();
    }
}
