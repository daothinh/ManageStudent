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

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseViewHolder>{
    private Context context;
    private ArrayList idCourse, name, desc, term, creditUnit;

    public CourseListAdapter(Context context, ArrayList idCourse, ArrayList name, ArrayList desc,
                             ArrayList term, ArrayList creditUnit) {
        this.context = context;
        this.idCourse = idCourse;
        this.name = name;
        this.desc = desc;
        this.term = term;
        this.creditUnit = creditUnit;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_entry, parent, false);
        return new CourseViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.idCourse.setText(String.valueOf(idCourse.get(position)));
        holder.name.setText(String.valueOf(name.get(position)));
//        holder.desc.setText(String.valueOf(desc.get(position)));
        holder.term.setText(String.valueOf(term.get(position)));
        holder.creditUnit.setText(String.valueOf(creditUnit.get(position)));
    }

    @Override
    public int getItemCount() {
        return idCourse.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView idCourse, name, desc, term, creditUnit;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            idCourse = itemView.findViewById(R.id.txtIdCourse);
            name = itemView.findViewById(R.id.txtNameCourse);
            term = itemView.findViewById(R.id.txtTermCourse);
            creditUnit = itemView.findViewById(R.id.txtCourseUnit);
        }
    }
}
