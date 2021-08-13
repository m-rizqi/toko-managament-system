package com.example.tokomanagementsystem.viewmodel.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class PriceRecyclerViewAdapter {


    class PriceViewHolder extends RecyclerView.ViewHolder{

        //widgets
        ImageButton addPreviousButton, addNextButton, deletePriceButton, addMerchantNoteButton, addConsumentNoteButton;
        LinearLayout linkPriceLinearLayout;
        TextInputLayout quantityLinkPriceInputLayout, merchantPriceInputLayout, consumentPriceInputLayout;
        TextInputEditText quantityLinkPriceEditText, merchantPriceEditText, consumentPriceEditText;
        TextView descriptionLinkPriceTextView;
        MaterialButton addUnitButton;
        ChipGroup unitChipGroup;
        CheckBox visibilityMerchantCheckBox, visibilityConsumentCheckbox;
        RecyclerView merchantNoteRecyclerView, consumentNoteRecyclerView;

        public PriceViewHolder(@NonNull View itemView) {
            super(itemView);



        }
    }

}
