package com.inveitix.mindler.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.inveitix.mindler.R;

public class FinalResultActivity extends AppCompatActivity {

    TextView txtFinalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);

        txtFinalResult = (TextView) findViewById( R.id.txt_final_result );
        txtFinalResult.setText(getIntent().getStringExtra( "result" ));
    }
}
