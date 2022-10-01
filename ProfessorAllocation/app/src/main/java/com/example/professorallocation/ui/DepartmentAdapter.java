package com.example.professorallocation.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professorallocation.R;
import com.example.professorallocation.model.DepartmentRes;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentItemHolder> {

    private List<DepartmentRes> departments;

    public DepartmentAdapter(List<DepartmentRes> departments) {
        this.departments = departments;
    }
    public void configureDepartments(List<DepartmentRes> departments){
        this.departments = departments;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DepartmentItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_department_item_layout,
                            parent,
                            false);
        return new DepartmentItemHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentItemHolder holder, int position) {
        DepartmentRes department= departments.get(position);
        holder.getTvDepartment().setText(department.getName());
    }

    @Override
    public int getItemCount() {
        return departments.size();
    }
}
