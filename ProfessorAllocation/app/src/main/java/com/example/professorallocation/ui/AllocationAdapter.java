package com.example.professorallocation.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professorallocation.R;
import com.example.professorallocation.model.AllocationRes;

import java.util.List;

public class AllocationAdapter extends RecyclerView.Adapter<AllocationItemHolder> {

    private List<AllocationRes> allocations;

    public AllocationAdapter(List<AllocationRes> allocations) {
        this.allocations = allocations;
    }
    public void configureAllocations(List<AllocationRes> allocations){
        this.allocations = allocations;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AllocationItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_allocation_item_layout,
                            parent,
                            false);
        return new AllocationItemHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull AllocationItemHolder holder, int position) {
        AllocationRes allocation = allocations.get(position);
        holder.getTvAllocationDay().setText(allocation.getDayOfWeek());
        holder.getTvAllocationStartEnd().setText(allocation.getStartHour().substring(0,Math.min(5, 10)) + " - " + allocation.getEndHour().substring(0,Math.min(5, 10)));
        holder.getTvAllocationProfessor().setText(allocation.getProfessor().getName());
        holder.getTvAllocationCourse().setText(allocation.getCourse().getName());
    }

    @Override
    public int getItemCount() {
        return allocations.size();
    }
}
