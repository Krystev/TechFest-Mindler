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
        exampleQuestion1.setQuestion("Кога се е осовбодила България от Турско робство");
        exampleQuestion1.setAnswerA("1876");
        exampleQuestion1.setAnswerB("1923");
        exampleQuestion1.setAnswerC("1879");
        exampleQuestion1.setAnswerD("1944");
        Questions exampleQuestion2 = new Questions();
        exampleQuestion2.setQuestion("На коя дата честваме деня на Европа");
        exampleQuestion2.setAnswerA("6 Септември");
        exampleQuestion2.setAnswerB("6 Май");
        exampleQuestion2.setAnswerC("9 Май");
        exampleQuestion2.setAnswerD("9 Септември");
        Questions exampleQuestion3 = new Questions();
        exampleQuestion3.setQuestion("Управлението на кой владетел е наречено - Златен Век");
        exampleQuestion3.setAnswerA("хан Крум");
        exampleQuestion3.setAnswerB("хан Омуртаг");
        exampleQuestion3.setAnswerC("цар Цимеон");
        exampleQuestion3.setAnswerD("хан Аспарух");
        Questions exampleQuestion4 = new Questions();
        exampleQuestion4.setQuestion("Пъривте Български Закони са създадени при управлението на:");
        exampleQuestion4.setAnswerA("хан Аспарух");
        exampleQuestion4.setAnswerB("хан Крум");
        exampleQuestion4.setAnswerC("княз Борис 1");
        exampleQuestion4.setAnswerD("цар Симеон");
        Questions exampleQuestion5 = new Questions();
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
