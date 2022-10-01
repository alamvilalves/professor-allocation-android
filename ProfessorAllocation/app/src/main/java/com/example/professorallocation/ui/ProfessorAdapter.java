package com.example.professorallocation.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professorallocation.R;
import com.example.professorallocation.model.ProfessorRes;

import java.util.List;

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorItemHolder> {

    private List<ProfessorRes> professors;

    public ProfessorAdapter(List<ProfessorRes> professors) {
        this.professors = professors;
    }
    public void configureProfessors(List<ProfessorRes> professors){
        this.professors = professors;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProfessorItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_professor_item_layout,
                            parent,
                            false);
        return new ProfessorItemHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessorItemHolder holder, int position) {
        ProfessorRes professor= professors.get(position);
        holder.getTvProfessor().setText(professor.getName());
    }

    @Override
    public int getItemCount() {
        return professors.size();
    }
}
