package com.inveitix.mindler.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.inveitix.mindler.R;

import java.util.List;

import butterknife.Bind;

public class ChooseTestActivity extends AppCompatActivity {

    @Bind(R.id.lv)
    ListView lv;
    private String[] myList = {"Урок 1", "Урок 2", "Урок 3", "Урок 4", "Урок 5", "Урок 6", "Урок 7", "Урок 8", "Урок 9",
            "Урок 10", "Урок 11", "Урок 12", "Урок 13", "Урок 14", "Урок 15", "Урок 16", "Урок 17", "Урок 18"};
    private ArrayAdapter testsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_test);
        testsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myList);
        Toast.makeText(ChooseTestActivity.this, myList[4], Toast.LENGTH_SHORT).show();
        lv.setAdapter(testsAdapter);

    }
}
