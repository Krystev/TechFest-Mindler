package com.inveitix.mindler.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.inveitix.mindler.R;
import com.inveitix.mindler.WebHelper;
import com.inveitix.mindler.cmn.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.RunnableFuture;

public class AnswerQuestionActivity extends AppCompatActivity {

    ProgressBar prgTime;
    TextView txtCurrentPosition;
    TextView txtQuestion;
    Button btnAnswer1;
    Button btnAnswer2;
    Button btnAnswer3;
    Button btnAnswer4;

    private int correctAnswer = 1;
    private int currentQuestion = 0;
    private int correctQuestionsCount = 0;

    private List<Question> questions;

    private int value = 1001;
    private boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_answer_question );

        txtCurrentPosition = (TextView) findViewById(R.id.txt_current_position);
        txtQuestion = (TextView) findViewById(R.id.txt_question);
        prgTime = (ProgressBar) findViewById( R.id.prg_time );

        questions = new ArrayList<Question>();

        progressIndication();

        btnAnswer1 = (Button) findViewById( R.id.btn_answer_1 );
        btnAnswer1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true;
                if(correctAnswer == 1) {
                    startColorAnimation( btnAnswer1, true );
                    correctQuestionsCount++;
                } else {
                    startColorAnimation( btnAnswer1, false );
                }
            }
        } );

        btnAnswer2 = (Button) findViewById( R.id.btn_answer_2 );
        btnAnswer2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true;
                if(correctAnswer == 2){
                    startColorAnimation( btnAnswer2, true );
                    correctQuestionsCount++;
                } else {
                    startColorAnimation( btnAnswer2, false );
                }
            }
        } );

        btnAnswer3 = (Button) findViewById( R.id.btn_answer_3 );
        btnAnswer3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true;
                if(correctAnswer == 3){
                    startColorAnimation( btnAnswer3, true );
                    correctQuestionsCount++;
                } else {
                    startColorAnimation( btnAnswer3, false );
                }
            }
        } );

        btnAnswer4 = (Button) findViewById( R.id.btn_answer_4 );
        btnAnswer4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true;
                if(correctAnswer == 4){
                    startColorAnimation( btnAnswer4, true );
                    correctQuestionsCount++;
                } else {
                    startColorAnimation( btnAnswer4, false );
                }
            }
        } );

        //TODO remove after filling from DB
        addTestQuestions();
        changeQuestion(0);
    }

    private void progressIndication() {
        Timer t = new Timer();
        t.schedule( new TimerTask() {
            @Override
            public void run() {
                if(!clicked){
                    prgTime.setProgress(--value);
                }
                if(value == 0){
                    runOnUiThread( new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText( AnswerQuestionActivity.this, "Your time is up", Toast.LENGTH_SHORT ).show();
                            changeQuestion( ++currentQuestion);
                        }
                    } );
                }
            }
        }, 10, 10 );
    }

    private void startColorAnimation(final View v, boolean correct){
        setButtonsClickable(false);
        if (correct) {
            v.setBackgroundResource(R.drawable.button_animation_green);
        }
        final TransitionDrawable td = (TransitionDrawable) v.getBackground();
        td.startTransition(1500);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                td.reverseTransition(1000);
            }
        }, 1500);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion(++currentQuestion);
                setButtonsClickable(true);
                v.setBackgroundResource(R.drawable.button_animation_red);
            }
        }, 3000);
    }

    private void setButtonsClickable(boolean b){
        btnAnswer1.setClickable(b);
        btnAnswer2.setClickable(b);
        btnAnswer3.setClickable(b);
        btnAnswer4.setClickable(b);
    }

    private void changeQuestion(int questionNumber){
        if (questionNumber >= questions.size()){
            showResult();
        } else {
            value = 1001;
            clicked = false;
            Question q = questions.get(questionNumber);
            txtQuestion.setText(q.getQuestion());
            btnAnswer1.setText(q.getAnswerA());
            btnAnswer2.setText(q.getAnswerB());
            btnAnswer3.setText(q.getAnswerC());
            btnAnswer4.setText(q.getAnswerD());
            correctAnswer = q.getCorrectAnswer();
        }
    }

    private void showResult(){
        Intent i = new Intent(AnswerQuestionActivity.this, FinalResultActivity.class);
        String s = "Your result : " + correctQuestionsCount + " / " + questions.size();
        i.putExtra("result", s);
        startActivity(i);
    }

    private void fillQuestionsFromDB(){
        //TODO fill the array from DB
    }

    private void changeCurrentPosition(){
        //TODO change current position based on other users
    }

    private void addTestQuestions(){
        questions.add(new Question("2 + 2 = ?", "1", "2", "3", "4", 4));
        questions.add(new Question("7 + 13 = ?", "20", "19", "21", "22", 1));
    }
}
