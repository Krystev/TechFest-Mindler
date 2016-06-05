package com.inveitix.mindler.ui;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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

    private ProgressBar prgTime;
    TextView txtCurrentPosition;
    TextView txtQuestion;
    private Button btnAnswer1;
    private Button btnAnswer2;
    private Button btnAnswer3;
    private Button btnAnswer4;

    private int correctAnswer = 1;
    private int questionCount = 1;
    private int correntQuetions = 0;

    private int value = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_answer_question );

        txtCurrentPosition = (TextView) findViewById(R.id.txt_current_position);
        txtQuestion = (TextView) findViewById(R.id.txt_question);
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
                    changeQuestion( ++questionCount );
                }
            }
        }, 10, 10 );

        btnAnswer1 = (Button) findViewById( R.id.btn_answer_1 );
        btnAnswer1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer == 1) {
                    startColorAnimation( btnAnswer1, true );
                    correntQuetions++;
                } else {
                    startColorAnimation( btnAnswer2, false );
                }
                changeQuestion( ++questionCount );
                value = 1001;
            }
        } );

        btnAnswer2 = (Button) findViewById( R.id.btn_answer_2 );
        btnAnswer2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer == 2){
                    startColorAnimation( btnAnswer2, true );
                    correntQuetions++;
                } else {
                    startColorAnimation( btnAnswer2, false );
                }
                changeQuestion( ++questionCount );
                value = 1001;
            }
        } );

        btnAnswer3 = (Button) findViewById( R.id.btn_answer_3 );
        btnAnswer3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer == 3){
                    startColorAnimation( btnAnswer3, true );
                    correntQuetions++;
                } else {
                    startColorAnimation( btnAnswer3, false );
                }
                changeQuestion( ++questionCount );
                value = 1001;
            }
        } );

        btnAnswer4 = (Button) findViewById( R.id.btn_answer_4 );
        btnAnswer4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer == 4){
                    startColorAnimation( btnAnswer4, true );
                    correntQuetions++;
                } else {
                    startColorAnimation( btnAnswer4, false );
                }
                changeQuestion( ++questionCount );
                value = 1001;
            }
        } );
    }

    private void startColorAnimation(View v, boolean correct){
        int colorStart = v.getSolidColor();
        int colorEndRed = 0xFFFF0000;
        int colorEndGreen = 0xff00ff00;

        ValueAnimator colorAnimator = new ValueAnimator();
        if(correct){
            colorAnimator = ObjectAnimator.ofInt(v, "backgroundColor", colorStart, colorEndGreen);
        } else {
            colorAnimator = ObjectAnimator.ofInt(v, "backgroundColor", colorStart, colorEndRed);
        }
        colorAnimator.setDuration(1000);
        colorAnimator.setEvaluator( new ArgbEvaluator() );
        colorAnimator.setRepeatCount( 1 );
        colorAnimator.setRepeatMode( ValueAnimator.REVERSE );
        colorAnimator.start();
    }

    private void changeQuestion(int questionNumber){
        if (questionCount < 3) {
            if (questionNumber == 2) {
                txtQuestion.setText( getString( R.string.question_2 ) );
                btnAnswer1.setText( getString( R.string.question_2_answer_1 ) );
                btnAnswer2.setText( getString( R.string.question_2_answer_2 ) );
                btnAnswer3.setText( getString( R.string.question_2_answer_3 ) );
                btnAnswer4.setText( getString( R.string.question_2_answer_4 ) );
                correctAnswer = 3;
            }

            if (questionNumber == 3) {
                txtQuestion.setText( getString( R.string.question_3 ) );
                btnAnswer1.setText( getString( R.string.question_3_answer_1 ) );
                btnAnswer2.setText( getString( R.string.question_3_answer_2 ) );
                btnAnswer3.setText( getString( R.string.question_3_answer_3 ) );
                btnAnswer4.setText( getString( R.string.question_3_answer_4 ) );
                correctAnswer = 2;
            }
        } else {
            showResult();
        }
    }

    private void showResult(){
        txtQuestion.setText("Your result : " + correntQuetions + " / 3");
        btnAnswer1.setText("");
        btnAnswer2.setText("");
        btnAnswer3.setText("");
        btnAnswer4.setText("");
    }
}
