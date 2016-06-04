package com.inveitix.mindler.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.inveitix.mindler.R;

import java.util.Timer;
import java.util.TimerTask;

public class AnswerQuestionActivity extends AppCompatActivity {

    ProgressBar prgTime;
    TextView txtCurrentPosition;
    TextView txtQuestion;
    Button btnAnswer1;
    Button btnAnswer2;
    Button btnAnswer3;
    Button btnAnswer4;

    int value = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_answer_question );

        prgTime = (ProgressBar) findViewById( R.id.prg_time );
        Timer t = new Timer();
        t.schedule( new TimerTask() {
            @Override
            public void run() {
                prgTime.setProgress(--value);
                if(value == 0){
                    runOnUiThread( new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText( AnswerQuestionActivity.this, "Your time is up", Toast.LENGTH_SHORT ).show();
                        }
                    } );
                }
            }
        }, 10, 10 );

        btnAnswer2 = (Button) findViewById( R.id.btn_answer_2 );
        btnAnswer2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 1001;
            }
        } );
    }
}
