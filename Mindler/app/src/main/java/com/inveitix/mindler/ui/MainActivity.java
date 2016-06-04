package com.inveitix.mindler.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.inveitix.mindler.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_add_questions)
    public void onQuestionsAddClicked() {
        startActivity(new Intent(this, AddQuestionsActivity.class));
    }

    @OnClick(R.id.btn_start_test)
    public void onStartTestClicked() {
        startActivity(new Intent(this, StartTestActivity.class));
    }

}