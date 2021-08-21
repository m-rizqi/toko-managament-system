package com.example.tokomanagementsystem.viewmodel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokomanagementsystem.R;
import com.example.tokomanagementsystem.model.Note;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<NoteRecyclerViewAdapter.NoteViewHolder> {

    private ArrayList<Note> noteArrayList;
    private ArrayList<NoteViewHolder> holderArrayList;

    public NoteRecyclerViewAdapter() {
        noteArrayList = new ArrayList<>();
        noteArrayList.add(new Note());
        holderArrayList = new ArrayList<>();
    }

    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        NoteViewHolder noteViewHolder = new NoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerview_note_itemlist, null));
        holderArrayList.add(noteViewHolder);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  NoteRecyclerViewAdapter.NoteViewHolder holder, int position) {
        Note note = noteArrayList.get(position);
        holder.kuantitasEditText.setText(note.getQuantity() == null || note.getQuantity() == 0 ? "" : note.getQuantity().toString());
        holder.hargaEditText.setText(note.getPrice() == null || note.getPrice() == 0 ? "" : note.getPrice().toString());
        if (position == holderArrayList.size() - 1){
            holder.setLast();
        }else {
            holder.setNotLast();
        }
        holder.addMoreImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote(new Note());
            }
        });
        holder.deleteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNote();
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public void addNote(Note note){
        saveAllNote();
        this.noteArrayList.add(note);
        notifyDataSetChanged();
    }

    public void deleteNote(){
        saveAllNote();
        this.noteArrayList.remove(this.noteArrayList.size() -1);
        notifyDataSetChanged();
    }

    public ArrayList<Note> getNoteArrayList() {
        saveAllNote();
        return noteArrayList;
    }

    public void setNoteArrayList(ArrayList<Note> noteArrayList) {
        this.noteArrayList = noteArrayList;
    }

    public ArrayList<NoteViewHolder> getHolderArrayList() {
        saveAllNote();
        return holderArrayList;
    }

    public void setHolderArrayList(ArrayList<NoteViewHolder> holderArrayList) {
        this.holderArrayList = holderArrayList;
    }

    public void saveAllNote(){
        for (int i = 0; i < noteArrayList.size(); i++) {
            NoteViewHolder noteViewHolder = holderArrayList.get(i);
            noteViewHolder.saveNote(i);
        }
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        //widgets
        View view;
        TextInputLayout kuantitasInputLayout, hargaInputLayout;
        TextInputEditText kuantitasEditText, hargaEditText;
        ImageButton deleteImageButton, addMoreImageButton;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            //extract widget
            view = itemView;
            kuantitasInputLayout = itemView.findViewById(R.id.note_inputlayout_kuantitas);
            hargaInputLayout = itemView.findViewById(R.id.note_inputlayout_harga);
            kuantitasEditText = itemView.findViewById(R.id.note_edittext_kuantitas);
            hargaEditText = itemView.findViewById(R.id.note_edittext_harga);
            addMoreImageButton = itemView.findViewById(R.id.note_imagebutton_addmorenote);
            deleteImageButton = itemView.findViewById(R.id.note_imagebutton_deletenote);

            //config
        }

        public void saveNote(int position){
            Integer quantity, price;
            try {
                quantity = Integer.valueOf(kuantitasEditText.getText().toString());
            }catch (NumberFormatException e){
                quantity = 0;
            }
            try {
                price = Integer.valueOf(hargaEditText.getText().toString());
            }catch (NumberFormatException e){
                price = 0;
            }
            Note note = noteArrayList.get(position);
            note.setQuantity(quantity);
            note.setPrice(price);
        }

        public void setNotLast(){
            deleteImageButton.setVisibility(View.GONE);
            addMoreImageButton.setVisibility(View.GONE);
        }

        public void setLast(){
            deleteImageButton.setVisibility(View.VISIBLE);
            addMoreImageButton.setVisibility(View.VISIBLE);
        }

    }
    
}
