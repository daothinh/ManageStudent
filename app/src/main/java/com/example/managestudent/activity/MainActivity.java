package com.example.managestudent.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.managestudent.R;
import com.example.managestudent.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listStudent = findViewById(R.id.listStudent);
        Button listCourse = findViewById(R.id.listCourse);
        Button listStudentClass = findViewById(R.id.listStudentClass);
        Button query1 = findViewById(R.id.query1);
        Button query2 = findViewById(R.id.query2);

        listStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StudentListActivity.class));
            }
        });

        listCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CourseListActivity.class));
            }
        });

    }




}