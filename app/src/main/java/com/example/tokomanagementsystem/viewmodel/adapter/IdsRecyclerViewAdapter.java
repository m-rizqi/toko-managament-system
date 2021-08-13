package com.example.tokomanagementsystem.viewmodel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokomanagementsystem.R;
import com.example.tokomanagementsystem.model.Id;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class IdsRecyclerViewAdapter extends RecyclerView.Adapter<IdsRecyclerViewAdapter.IdsViewHoder> {

    //vars
    private ArrayList<Id> idsProduct = new ArrayList<>();
    private ArrayList<IdsViewHoder> idsViewHoders = new ArrayList<>();

    public IdsRecyclerViewAdapter(Id id) {
        idsProduct.add(id);
    }

    @Override
    public IdsViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        IdsViewHoder idViewHoder = new IdsViewHoder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_ids_itemlist, null));
        idsViewHoders.add(idViewHoder);
        return idViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull IdsRecyclerViewAdapter.IdsViewHoder holder, int position) {
        Id id = idsProduct.get(position);
        holder.idEditText.setText(String.valueOf(id.getId()));
        holder.idInputLayout.setEnabled(false);
        if (idsProduct.size() == 1){
            holder.setIdSizeOne();
        }else {
            if (position == idsProduct.size() - 1){
                holder.setIdLast();
            }else{
                holder.setIdNotLast();
            }
        }
        holder.addIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addId(new Id(999999L, "", 3L));
            }
        });
        holder.deleteIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteId();
            }
        });
    }

    @Override
    public int getItemCount() {
        return idsProduct.size();
    }

    public void addId(Id id){
        this.idsProduct.add(id);
        notifyDataSetChanged();
    }

    public void deleteId(){
        this.idsProduct.remove(this.idsProduct.size() -1);
        notifyDataSetChanged();
    }

    class IdsViewHoder extends RecyclerView.ViewHolder {

        //widgets
        View view;
        TextInputLayout idInputLayout, priorityInputLayout;
        TextInputEditText idEditText;
        AutoCompleteTextView priorityAutoComplete;
        RelativeLayout addDeleteIdRelativeLayout;
        ImageButton addIdButton, deleteIdButton;
        TextView tambahIdTextView;

        public IdsViewHoder(@NonNull View itemView) {
            super(itemView);

            //extract widgets
            view = itemView;
            idInputLayout = itemView.findViewById(R.id.ids_inputlayout_1);
            idEditText = itemView.findViewById(R.id.ids_edittext_id);
            priorityInputLayout = itemView.findViewById(R.id.ids_inputlayout_2);
            priorityAutoComplete = itemView.findViewById(R.id.ids_autocompletetextview_priority);
            addDeleteIdRelativeLayout = itemView.findViewById(R.id.ids_relativelayout_2);
            addIdButton = itemView.findViewById(R.id.ids_imagebutton_tambahid);
            deleteIdButton = itemView.findViewById(R.id.ids_imagebutton_kurangid);
            tambahIdTextView = itemView.findViewById(R.id.ids_textview_tambahid);

            //widgets configuration

        }

        public void setIdSizeOne(){
            addDeleteIdRelativeLayout.setVisibility(View.VISIBLE);
            tambahIdTextView.setVisibility(View.VISIBLE);
            deleteIdButton.setVisibility(View.GONE);
            addIdButton.setVisibility(View.VISIBLE);
        }

        public void setIdNotLast(){
            addDeleteIdRelativeLayout.setVisibility(View.GONE);
        }

        public void setIdLast(){
            addDeleteIdRelativeLayout.setVisibility(View.VISIBLE);
            tambahIdTextView.setVisibility(View.GONE);
            deleteIdButton.setVisibility(View.VISIBLE);
            addIdButton.setVisibility(View.VISIBLE);
        }

    }

}
