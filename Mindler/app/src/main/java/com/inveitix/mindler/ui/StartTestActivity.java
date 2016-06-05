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


    @Bind(R.id.edt_teacher_username)
    EditText edtTeacherUsername;
    @Bind(R.id.edt_teacher_pass)
    EditText edtTeacherPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_login_teacher)
    public void onEnterTeacherClick() {
        if (edtTeacherUsername.length() == 0) {
            edtTeacherUsername.setError("Please enter correct Username");
        } else  if (edtTeacherPassword.length() == 0) {
            edtTeacherPassword.setError("Please enter correct Password");
        } else {
            startActivity(new Intent(this, ChooseTestActivity.class));
        }
    }

}

