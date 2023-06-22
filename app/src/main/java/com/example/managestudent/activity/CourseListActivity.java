package com.example.managestudent.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.managestudent.R;
import com.example.managestudent.adapter.CourseListAdapter;
import com.example.managestudent.database.DatabaseHelper;
import com.example.managestudent.model.Course;

import java.util.ArrayList;

public class CourseListActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    RecyclerView recyclerView;
    ArrayList<String> id, name, desc, term, creditUnit;
    CourseListAdapter courseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        EditText nameCourse = findViewById(R.id.nameCourse);
        EditText termCourse = findViewById(R.id.term);
        EditText creditUnitCourse = findViewById(R.id.courseUnit);
        EditText descCourse = findViewById(R.id.desCourse);

        Button addCourse = findViewById(R.id.addCourse);
        Button viewCourse = findViewById(R.id.viewCourse);

        recyclerView = findViewById(R.id.recyclerCourse);

        addCourse.setOnClickListener(v -> {

            if (TextUtils.isEmpty(nameCourse.getText().toString()) || TextUtils.isEmpty(termCourse.getText().toString()) || TextUtils.isEmpty(creditUnitCourse.getText().toString())) {
                Toast.makeText(CourseListActivity.this, "Please fill value", Toast.LENGTH_SHORT).show();
            } else {
                Course course = new Course(1,
                        nameCourse.getText().toString(),
                        descCourse.getText().toString(),
                        Integer.parseInt(termCourse.getText().toString()),
                        Integer.parseInt(creditUnitCourse.getText().toString()));


                Boolean checkAddCourse = databaseHelper.addCourse(course);
                if (checkAddCourse == true) {
                    Toast.makeText(CourseListActivity.this, "Add Course Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CourseListActivity.this, "Add Course Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //View Course
        viewCourse.setOnClickListener(v -> {
            id = new ArrayList<>();
            name = new ArrayList<>();
            desc = new ArrayList<>();
            term = new ArrayList<>();
            creditUnit = new ArrayList<>();

            courseListAdapter = new CourseListAdapter(CourseListActivity.this, id, name, desc, term, creditUnit);
            recyclerView.setAdapter(courseListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(CourseListActivity.this));
            displayData();
        });
    }

    private void displayData() {
        Cursor cursor = databaseHelper.getCourse();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
//                desc.add(cursor.getString(2));
                term.add(cursor.getString(2));
                creditUnit.add(cursor.getString(3));
            }
        }
    }
}