package com.example.managestudent.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.managestudent.R;
import com.example.managestudent.adapter.StudentListAdapter;

public class QueryCustomActivity extends AppCompatActivity {

    StudentListActivity studentListActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_custom);

        studentListActivity = new StudentListActivity();

    }
}