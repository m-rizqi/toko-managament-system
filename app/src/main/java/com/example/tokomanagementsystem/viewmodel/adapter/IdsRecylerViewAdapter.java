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
import java.util.zip.Inflater;

public class IdsRecylerViewAdapter extends RecyclerView.Adapter<IdsRecylerViewAdapter.IdsViewHoder> {

    //vars
    private ArrayList<Id> idsProduct = new ArrayList<>();
    private ArrayList<IdsViewHoder> idsViewHoders = new ArrayList<>();

    public IdsRecylerViewAdapter(Id id) {
        idsProduct.add(id);
    }

    @Override
    public IdsViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        IdsViewHoder idViewHoder = new IdsViewHoder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_ids_itemlist, null));
        idsViewHoders.add(idViewHoder);
        return idViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull IdsRecylerViewAdapter.IdsViewHoder holder, int position) {
        Id id = idsProduct.get(position);
        holder.idEditText.setText(String.valueOf(id.getId()));
    }

    @Override
    public int getItemCount() {
        return idsProduct.size();
    }

    class IdsViewHoder extends RecyclerView.ViewHolder {

        //widgets
        TextInputLayout idInputLayout, priorityInputLayout;
        TextInputEditText idEditText;
        AutoCompleteTextView priorityAutoComplete;
        RelativeLayout addDeleteIdRelativeLayout;
        ImageButton addIdButton, deleteIdButton;
        TextView tambahIdTextView;

        public IdsViewHoder(@NonNull View itemView) {
            super(itemView);

            //extract widgets
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
    }

}
