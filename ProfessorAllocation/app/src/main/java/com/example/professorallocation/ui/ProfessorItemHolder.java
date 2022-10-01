package com.example.professorallocation.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professorallocation.R;

public class ProfessorItemHolder extends RecyclerView.ViewHolder {
    private final TextView tvProfessor;

    public ProfessorItemHolder(@NonNull View itemView) {
        super(itemView);
        tvProfessor = itemView.findViewById(R.id.tvProfessorName);
    }

    public TextView getTvProfessor() {
        return tvProfessor;
    }
}