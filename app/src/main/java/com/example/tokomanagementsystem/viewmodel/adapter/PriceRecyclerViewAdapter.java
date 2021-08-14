package com.example.tokomanagementsystem.viewmodel.adapter;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tokomanagementsystem.R;
import com.example.tokomanagementsystem.model.Price;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class PriceRecyclerViewAdapter extends RecyclerView.Adapter {

    //vars
    private ArrayList<Price> priceArrayList = new ArrayList<>();
    private ArrayList<PriceViewHolder> priceViewHolders = new ArrayList<>();

    public PriceRecyclerViewAdapter(Price price){
        priceArrayList.add(price);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        PriceViewHolder priceViewHolder = new PriceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerview_price_itemlist, null));
        priceViewHolders.add(priceViewHolder);
        return priceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return priceArrayList.size();
    }

    class PriceViewHolder extends RecyclerView.ViewHolder{

        //widgets
        View view;
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

            //extract widgets
            view = itemView;
            addPreviousButton = itemView.findViewById(R.id.price_imagebutton_addboxabove);
            addNextButton = itemView.findViewById(R.id.price_imagebutton_addboxbelow);
            deletePriceButton = itemView.findViewById(R.id.price_imagebutton_deletebox);
            addMerchantNoteButton = itemView.findViewById(R.id.price_imagebutton_pedagangaddnote);
            addConsumentNoteButton = itemView.findViewById(R.id.price_imagebutton_konsumenaddnote);
            linkPriceLinearLayout = itemView.findViewById(R.id.price_linearlayout_1);
            quantityLinkPriceInputLayout = itemView.findViewById(R.id.price_inputlayout_1);
            merchantPriceInputLayout = itemView.findViewById(R.id.price_inputlayout_pedagangprice);
            consumentPriceInputLayout = itemView.findViewById(R.id.price_inputlayout_konsumenprice);
            quantityLinkPriceEditText = itemView.findViewById(R.id.price_edittext_1);
            merchantPriceEditText = itemView.findViewById(R.id.price_edittext_pedagangprice);
            consumentPriceEditText = itemView.findViewById(R.id.price_edittext_konsumenprice);
            descriptionLinkPriceTextView = itemView.findViewById(R.id.price_textview_1);
            addUnitButton = itemView.findViewById(R.id.price_materialbutton_tambahsatuan);
            unitChipGroup = itemView.findViewById(R.id.price_chipgroup_satuan);
            visibilityMerchantCheckBox = itemView.findViewById(R.id.price_checkbox_pedagangvisibility);
            visibilityConsumentCheckbox = itemView.findViewById(R.id.price_checkbox_konsumenvisibility);
            merchantNoteRecyclerView = itemView.findViewById(R.id.price_recylerview_pedagangnote);
            consumentNoteRecyclerView = itemView.findViewById(R.id.price_recylerview_konsumennote);

            //widgets configuration
            addUnitChip("Bungkus");

        }

        @SuppressLint("ResourceAsColor")
        public void addUnitChip(String name){
            Chip chip = new Chip(new ContextThemeWrapper(view.getContext(), R.style.Widget_MaterialComponents_Chip_Choice));
            chip.setText(name);
            chip.setTextColor(R.color.price_chip_text_selector);
            chip.setTypeface(ResourcesCompat.getFont(view.getContext(), R.font.poppins_w400_regular));
            chip.setTextSize(10);
            chip.setBackgroundColor(R.color.price_chip_background_selector);
            int colorInt = itemView.getResources().getColor(R.color.price_chip_stroke_selector);
            ColorStateList colorStateList = ColorStateList.valueOf(colorInt);
            chip.setChipStrokeColor(colorStateList);
            chip.setChipStrokeWidth(1);
            chip.setCheckable(true);
            chip.setClickable(true);
            chip.setFocusable(true);

            unitChipGroup.addView(chip);
        }

    }

}
