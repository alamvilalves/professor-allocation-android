package com.example.professorallocation.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professorallocation.R;

public class CourseItemHolder extends RecyclerView.ViewHolder {
    private final TextView tvCourse;

    public CourseItemHolder(@NonNull View itemView) {
        super(itemView);
        tvCourse = itemView.findViewById(R.id.tvCourseName);
    }

    public TextView getTvCourse() {
        return tvCourse;
    }
}