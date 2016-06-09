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

        Question exampleQuestion = new Question("Кога е създаена България", "681", "345", "1234", "234", 1);
        Question exampleQuestion1 = new Question("Кога се е осовбодила България от Турско робство", "1876", "1923", "1879",
                "1878", 4);
        Question exampleQuestion2 = new Question("На коя дата честваме деня на Европа", "6 Септември", "6 Май",
                "9 Май", "9 Септември", 3);
        Question exampleQuestion3 = new Question("Управлението на кой владетел е наречено - Златен Век", "хан Крум",
                "хан Омуртаг", "цар Симеон", "хан Аспарух", 3);
        Question exampleQuestion4 = new Question("Първите Български Закони са създадени при управлението на:",
                "хан Аспарух", "хан Крум", "княз Борис 1","цар Симеон", 2);
        Question exampleQuestion5 = new Question("Кой е покръстил България", "хан Аспарух", "хан Крум", "цар Симеон",
                "княз Борис 1", 4);

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
