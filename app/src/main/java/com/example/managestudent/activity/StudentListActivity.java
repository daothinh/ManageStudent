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
import android.widget.TextView;
import android.widget.Toast;

import com.example.managestudent.R;
import com.example.managestudent.adapter.StudentListAdapter;
import com.example.managestudent.database.DatabaseHelper;
import com.example.managestudent.model.Student;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {


    DatabaseHelper databaseHelper;
    RecyclerView recyclerView;
    ArrayList<String> id, name, dob, address, courseYear;
    StudentListAdapter studentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        databaseHelper = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        Button addStudent = findViewById(R.id.addStudent);
        Button updateStudent = findViewById(R.id.updateStudent);
        Button queryCustom = findViewById(R.id.queryCustom);
        Button viewStudent = findViewById(R.id.viewStudent);

        TextView idStudent = findViewById(R.id.idStudent);
        EditText nameStudent = findViewById(R.id.nameStudent);
        EditText dobStudent = findViewById(R.id.dobStudent);
        EditText addrStudent = findViewById(R.id.addrStudent);
        EditText couYearStudent = findViewById(R.id.couYearStudent);

        recyclerView = findViewById(R.id.recyclerStudent);

        //Add Student
        addStudent.setOnClickListener(v -> {

            if (TextUtils.isEmpty(nameStudent.getText().toString()) || TextUtils.isEmpty(dobStudent.getText().toString())) {
                Toast.makeText(StudentListActivity.this, "Please fill value", Toast.LENGTH_SHORT).show();
            } else {
                Student student = new Student(1, nameStudent.getText().toString(),
                        dobStudent.getText().toString(), addrStudent.getText().toString(),
                        Integer.parseInt(couYearStudent.getText().toString()));

                Boolean checkAddStudent = databaseHelper.addStudent(student);

                if (checkAddStudent == true) {
                    Toast.makeText(StudentListActivity.this, "Add student successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(StudentListActivity.this, "Add student failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Show Student
        viewStudent.setOnClickListener(v -> {
            id = new ArrayList<>();
            name = new ArrayList<>();
            dob = new ArrayList<>();
            address = new ArrayList<>();
            courseYear = new ArrayList<>();

            studentListAdapter = new StudentListAdapter(StudentListActivity.this, id, name, dob, address, courseYear);
            recyclerView.setAdapter(studentListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(StudentListActivity.this));
            displayData();
        });

        //Query Custom
        queryCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = new ArrayList<>();
                name = new ArrayList<>();
                dob = new ArrayList<>();
                address = new ArrayList<>();
                courseYear = new ArrayList<>();

                studentListAdapter = new StudentListAdapter(StudentListActivity.this, id, name, dob, address, courseYear);
                recyclerView.setAdapter(studentListAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(StudentListActivity.this));
                displayDataCustom();
            }
        });
    }

    private void displayData() {
        Cursor cursor = databaseHelper.getStudent();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
//                dob.add(cursor.getString(2));
                address.add(cursor.getString(2));
                courseYear.add(cursor.getString(3));
            }
        }
    }

    private void displayDataCustom(){
        Cursor cursor = databaseHelper.getStudentCustom("John", "2");
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                address.add(cursor.getString(2));
                courseYear.add(cursor.getString(3));
            }
        }
    }
}