package com.example.tokomanagementsystem.viewmodel.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<NoteRecyclerViewAdapter.NoteViewHolder> {

    @NonNull
    
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  NoteRecyclerViewAdapter.NoteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        //widgets
        TextInputLayout kuantitasInputLayout, hargaInputLayout;
        EditText kuantitasEditText, hargaEditText;
        ImageButton deleteImageButton, addMoreImageButton;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    
}
