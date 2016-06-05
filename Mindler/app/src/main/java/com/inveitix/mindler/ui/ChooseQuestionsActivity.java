package com.inveitix.mindler.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.inveitix.mindler.R;
import com.inveitix.mindler.adapters.QuestionAdapter;
import com.inveitix.mindler.cmn.Question;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChooseQuestionsActivity extends AppCompatActivity {

    @Bind(R.id.my_recycler_view_question)
    RecyclerView recViewQuestions;
    @Bind(R.id.btn_start_test)
    Button btnStartTest;
    QuestionAdapter questionAdapter;
    List<Question> question = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_questions);
        ButterKnife.bind(this);

        Question exampleQuestion = new Question();
        exampleQuestion.setQuestion("Кога е създаена България");
        exampleQuestion.setAnswerA("681");
        exampleQuestion.setAnswerB("345");
        exampleQuestion.setAnswerC("1234");
        exampleQuestion.setAnswerD("234");
        Question exampleQuestion1 = new Question();
        exampleQuestion1.setQuestion("Кога се е осовбодила България от Турско робство");
        exampleQuestion1.setAnswerA("1876");
        exampleQuestion1.setAnswerB("1923");
        exampleQuestion1.setAnswerC("1879");
        exampleQuestion1.setAnswerD("1944");
        Question exampleQuestion2 = new Question();
        exampleQuestion2.setQuestion("На коя дата честваме деня на Европа");
        exampleQuestion2.setAnswerA("6 Септември");
        exampleQuestion2.setAnswerB("6 Май");
        exampleQuestion2.setAnswerC("9 Май");
        exampleQuestion2.setAnswerD("9 Септември");
        Question exampleQuestion3 = new Question();
        exampleQuestion3.setQuestion("Управлението на кой владетел е наречено - Златен Век");
        exampleQuestion3.setAnswerA("хан Крум");
        exampleQuestion3.setAnswerB("хан Омуртаг");
        exampleQuestion3.setAnswerC("цар Цимеон");
        exampleQuestion3.setAnswerD("хан Аспарух");
        Question exampleQuestion4 = new Question();
        exampleQuestion4.setQuestion("Пъривте Български Закони са създадени при управлението на:");
        exampleQuestion4.setAnswerA("хан Аспарух");
        exampleQuestion4.setAnswerB("хан Крум");
        exampleQuestion4.setAnswerC("княз Борис 1");
        exampleQuestion4.setAnswerD("цар Симеон");
        Question exampleQuestion5 = new Question();
        exampleQuestion5.setQuestion("Кой е покръстил България");
        exampleQuestion5.setAnswerA("хан Аспарух");
        exampleQuestion5.setAnswerB("хан Крум");
        exampleQuestion5.setAnswerC("княз Борис 1");
        exampleQuestion5.setAnswerD("цар Симеон");

        question.add(exampleQuestion);
        question.add(exampleQuestion1);
        question.add(exampleQuestion2);
        question.add(exampleQuestion3);
        question.add(exampleQuestion4);
        question.add(exampleQuestion5);

        questionAdapter = new QuestionAdapter(this,question);
        recViewQuestions.setLayoutManager(new LinearLayoutManager(this));
        recViewQuestions.setAdapter(questionAdapter);
    }
}
