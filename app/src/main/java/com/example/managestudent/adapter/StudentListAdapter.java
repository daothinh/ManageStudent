package com.example.managestudent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managestudent.R;

import java.util.ArrayList;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {

    private Context context;
    private ArrayList idStudent, name, dob, address, courseYear;

    public StudentListAdapter(Context context, ArrayList idStudent, ArrayList name, ArrayList dob,
                              ArrayList address, ArrayList courseYear) {
        this.context = context;
        this.idStudent = idStudent;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.courseYear = courseYear;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_entry, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.idStudent.setText(String.valueOf(idStudent.get(position)));
        holder.name.setText(String.valueOf(name.get(position)));
        holder.address.setText(String.valueOf(address.get(position)));
        holder.courseYear.setText(String.valueOf(courseYear.get(position)));
    }

    @Override
    public int getItemCount() {
        return idStudent.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView idStudent, name, dob, address, courseYear;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            idStudent = itemView.findViewById(R.id.txtIdStudent);
            name = itemView.findViewById(R.id.txtNameStudent);
            address = itemView.findViewById(R.id.txtAddressStudent);
            courseYear = itemView.findViewById(R.id.txtCourseYearStudent);
        }
    }
}
