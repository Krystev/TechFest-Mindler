package com.inveitix.mindler.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.inveitix.mindler.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartTestActivity extends AppCompatActivity {


    @Bind(R.id.edt_teacher_name)
    EditText edtTeacherName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_enter_teacher)
    public void onEnterTeacherClick() {
        if (edtTeacherName.length() == 0) {
            edtTeacherName.setError("Please enter Teacher's name");
        } else {
            startActivity(new Intent(this, ChooseTestActivity.class));
        }
    }

}

