package com.example.tokomanagementsystem.viewmodel.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class IdsRecyclerViewAdapter extends RecyclerView.Adapter<IdsRecyclerViewAdapter.IdsViewHolder> {

    //vars
    private ArrayList<Id> idsProduct = new ArrayList<>();
    private ArrayList<String> roleAutoCompleteList;
    private ArrayList<IdsViewHolder> idsViewHolders = new ArrayList<>();

    public IdsRecyclerViewAdapter(Id id, ArrayList<String> roleAutoCompleteList) {
        idsProduct.add(id);
        this.roleAutoCompleteList = roleAutoCompleteList;
    }

    @Override
    public IdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        IdsViewHolder idViewHoder = new IdsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_ids_itemlist, null));
        idsViewHolders.add(idViewHoder);
        return idViewHoder;
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull IdsViewHolder holder, int position) {
        Id id = idsProduct.get(position);
        holder.idEditText.setText(String.valueOf(id.getId()));
        //configuration
        if (position == 0){
            holder.setPriorityFirst();
            holder.saveRolePriority("Main", position);
        }else {
            holder.setPriorityNotFirst();
            holder.priorityAutoComplete.setText(id.getRole().equalsIgnoreCase("Default") ? "Default" : id.getRole(), false);
        }
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
                //TO DO : SCAN BARCODE
                addId(new Id(999999L, "Default", idsProduct.get(0).getId()));
            }
        });
        holder.deleteIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteId();
            }
        });
        holder.priorityAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                holder.saveRolePriority(roleAutoCompleteList.get(pos), position);
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

    public void saveHolders(){
        for (int i = 0; i < idsProduct.size(); i++) {
            Id id = idsProduct.get(i);
            IdsViewHolder viewHolder = idsViewHolders.get(i);
            id.setRole(String.valueOf(viewHolder.priorityAutoComplete.getOnItemSelectedListener()));
        }
    }

    public ArrayList<Id> getIdsProduct() {
        saveHolders();
        return idsProduct;
    }

    class IdsViewHolder extends RecyclerView.ViewHolder {

        //widgets
        View view;
        TextInputLayout idInputLayout, priorityInputLayout, priorityDisabledInputLayout;
        TextInputEditText idEditText, priorityDisabledEditText;
        AutoCompleteTextView priorityAutoComplete;
        RelativeLayout addDeleteIdRelativeLayout;
        ImageButton addIdButton, deleteIdButton;
        TextView tambahIdTextView;

        //vars
        ArrayAdapter<String> roleAutoCompeteAdapter;

        public IdsViewHolder(@NonNull View itemView) {
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
            priorityDisabledInputLayout = itemView.findViewById(R.id.ids_inputlayout_3);
            priorityDisabledEditText = itemView.findViewById(R.id.ids_edittext_priority);

            //vars config
            roleAutoCompeteAdapter = new ArrayAdapter<>(itemView.getContext(),R.layout.drop_down_list_item,roleAutoCompleteList);
            priorityAutoComplete.setAdapter(roleAutoCompeteAdapter);
            priorityAutoComplete.setDropDownBackgroundResource(R.color.white);

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

        public void setPriorityFirst(){
            priorityInputLayout.setVisibility(View.GONE);
            priorityDisabledInputLayout.setVisibility(View.VISIBLE);
        }

        public void setPriorityNotFirst(){
            priorityInputLayout.setVisibility(View.VISIBLE);
            priorityDisabledInputLayout.setVisibility(View.GONE);
        }

        public void saveRolePriority(String role, int position){
           Id id = idsProduct.get(position);
           id.setRole(role);
        }

    }

}
