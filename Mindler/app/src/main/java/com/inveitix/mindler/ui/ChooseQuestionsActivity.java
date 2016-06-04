package com.inveitix.mindler.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.inveitix.mindler.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChooseQuestionsActivity extends AppCompatActivity {

    @Bind(R.id.my_recycler_view_question)
    RecyclerView recViewQuestions;
    QuestionAdapter questionAdapter;
    List<Questions> question = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_questions);
        ButterKnife.bind(this);

        Questions exampleQuestion = new Questions();
        exampleQuestion.setQuestion("Кога е създаена България");
        exampleQuestion.setAnswerA("681");
        exampleQuestion.setAnswerB("345");
        exampleQuestion.setAnswerC("1234");
        exampleQuestion.setAnswerD("234");
        Questions exampleQuestion1 = new Questions();
        exampleQuestion1.setQuestion("Кога е осовбодена България от Турско робство");
        exampleQuestion1.setAnswerA("1876");
        exampleQuestion1.setAnswerB("1923");
        exampleQuestion1.setAnswerC("1879");
        exampleQuestion1.setAnswerD("1944");

        question.add(exampleQuestion);
        question.add(exampleQuestion1);

        questionAdapter = new QuestionAdapter(this,question);
        recViewQuestions.setLayoutManager(new LinearLayoutManager(this));
        recViewQuestions.setAdapter(questionAdapter);
    }
}
