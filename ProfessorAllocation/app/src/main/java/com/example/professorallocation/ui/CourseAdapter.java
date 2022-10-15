package com.example.professorallocation.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professorallocation.R;
import com.example.professorallocation.model.CourseRes;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseItemHolder> {

    private List<CourseRes> courses;

    public CourseAdapter(List<CourseRes> courses) {
        this.courses = courses;
    }
    public void configureCourses(List<CourseRes> courses){
        this.courses = courses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CourseItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_course_item_layout,
                            parent,
                            false);
        return new CourseItemHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseItemHolder holder, int position) {
        CourseRes course = courses.get(position);
        holder.getTvCourse().setText(course.getName());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
