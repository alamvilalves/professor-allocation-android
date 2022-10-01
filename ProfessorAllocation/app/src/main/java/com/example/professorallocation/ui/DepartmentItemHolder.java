package com.example.professorallocation.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professorallocation.R;

public class DepartmentItemHolder extends RecyclerView.ViewHolder {
    private final TextView tvDepartment;

    public DepartmentItemHolder(@NonNull View itemView) {
        super(itemView);
        tvDepartment = itemView.findViewById(R.id.tvDepartmentName);
    }

    public TextView getTvDepartment() {
        return tvDepartment;
    }
}