package com.inveitix.mindler.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.inveitix.mindler.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

//    @OnClick(R.id.btn_create_test)
//    public void onCreateTestClicked() {
//        startActivity(new Intent(this, StartTestActivity.class));
//    }

//    @OnClick(R.id.btn_enter_test)
//    public void onEnterTestClicked() {
//        startActivity(new Intent(this, EnterTestActivity.class));
//    }

}
