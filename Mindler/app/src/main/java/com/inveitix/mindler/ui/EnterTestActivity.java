package com.inveitix.mindler.ui;


import android.content.Context;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.inveitix.mindler.adapters.CustomSpinnerAdapter;
import com.inveitix.mindler.R;

public class EnterTestActivity extends AppCompatActivity {

    private EditText edtStudentName;
    private Spinner spnCity;
    private Spinner spnSchool;
    private Spinner spnSubject;
    private Spinner spnTeacher;
    private Button btnEnterCompetition;

    private String[] cityArray = {"Враца", "София", "Варна", "Бургас", "Плевен", "Велико Търново"};
    private String[] schoolArray = {"Училище 1", "Училище 2", "Училище 3", "Училище 4"};
    private String[] subjectArray = {"Математика", "История", "Информатика", "Биология"};
    private String[] teacherArray = {"Учител 1", "Учител 2", "Учител 3", "Учител 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_enter_test);

        edtStudentName = (EditText) findViewById(R.id.edt_student_name);
        btnEnterCompetition = (Button) findViewById( R.id.btn_enter_competition );

        initSpinners();
        btnEnterCompetition.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtStudentName.getText().toString().equals( "" )){
                    edtStudentName.setError( getString( R.string.error_no_username ) );
                } else {
                    Intent i = new Intent(EnterTestActivity.this, AnswerQuestionActivity.class);
                    startActivity( i );
                }
            }
        } );

    }

    private void initSpinners(){
        spnCity = (Spinner) findViewById(R.id.spn_city);
        CustomSpinnerAdapter cityAdapter =
                new CustomSpinnerAdapter(this, R.layout.spinner_dropdown, cityArray, getString(R.string.choose_city));
        spnCity.setAdapter(cityAdapter);

        spnSchool = (Spinner) findViewById(R.id.spn_school);
        CustomSpinnerAdapter schoolAdapter =
                new CustomSpinnerAdapter(this, R.layout.spinner_dropdown, schoolArray, getString(R.string.choose_school));
        spnSchool.setAdapter(schoolAdapter);

        spnSubject = (Spinner) findViewById(R.id.spn_subject);
        CustomSpinnerAdapter subjectAdapter =
                new CustomSpinnerAdapter(this, R.layout.spinner_dropdown, subjectArray, getString(R.string.choose_subject));
        spnSubject.setAdapter(subjectAdapter);

        spnTeacher = (Spinner) findViewById(R.id.spn_teacher);
        CustomSpinnerAdapter teacherAdapter =
                new CustomSpinnerAdapter(this, R.layout.spinner_dropdown, teacherArray, getString(R.string.choose_teacher));
        spnTeacher.setAdapter(teacherAdapter);
    }


}
