package com.example.professorallocation.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professorallocation.R;

public class AllocationItemHolder extends RecyclerView.ViewHolder {
    private final TextView tvAllocationDay;
    private final TextView tvAllocationStartEnd;
    private final TextView tvAllocationProfessor;
    private final TextView tvAllocationCourse;

    public AllocationItemHolder(@NonNull View itemView) {
        super(itemView);
        tvAllocationDay = itemView.findViewById(R.id.tvAllocationDay);
        tvAllocationStartEnd = itemView.findViewById(R.id.tvAllocationStartEnd);
        tvAllocationProfessor = itemView.findViewById(R.id.tvAllocationProfessor);
        tvAllocationCourse = itemView.findViewById(R.id.tvAllocationCourse);
    }

    public TextView getTvAllocationDay() { return tvAllocationDay; }
    public TextView getTvAllocationStartEnd() {
        return tvAllocationStartEnd;
    }
    public TextView getTvAllocationProfessor() {
        return tvAllocationProfessor;
    }
    public TextView getTvAllocationCourse() {
        return tvAllocationCourse;
    }
}