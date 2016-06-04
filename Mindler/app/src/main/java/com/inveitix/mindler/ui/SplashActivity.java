package com.inveitix.mindler.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.inveitix.mindler.R;
import com.inveitix.mindler.WebHelper;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d("TAG", "DSDSDS");
        String name = WebHelper.getInstance().getCities().get(0).getName();

    }
}
