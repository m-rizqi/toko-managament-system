package com.example.tokomanagementsystem.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.tokomanagementsystem.R;
import com.example.tokomanagementsystem.model.Id;
import com.example.tokomanagementsystem.model.Price;
import com.example.tokomanagementsystem.viewmodel.adapter.IdsRecyclerViewAdapter;
import com.example.tokomanagementsystem.viewmodel.adapter.NewProductViewModel;
import com.example.tokomanagementsystem.viewmodel.adapter.PriceRecyclerViewAdapter;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class NewProductActivity extends AppCompatActivity {

    //widgets
    ImageButton backButton, cameraButton;
    ImageView productImage;
    RecyclerView idsRecyclerview, pricesRecylerview;
    TextInputLayout productNameInputLayout;
    TextInputEditText productNameEditText;
    CheckBox notifrememberCheckBox;
    MaterialButton simpanButton;

    //vars
    IdsRecyclerViewAdapter idsAdapter;
    PriceRecyclerViewAdapter pricesAdapter;
    NewProductViewModel newProductViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        //extract widgets
        backButton = findViewById(R.id.newproduct_imagebutton_back);
        cameraButton = findViewById(R.id.newproduct_imagebutton_camera);
        productImage = findViewById(R.id.newproduct_imageview_imageproduct);
        idsRecyclerview = findViewById(R.id.newproduct_recyclerview_ids);
        pricesRecylerview = findViewById(R.id.newproduct_recyclerview_pricelist);
        productNameInputLayout = findViewById(R.id.newproduct_inputlayout_namabarang);
        productNameEditText = findViewById(R.id.newproduct_edittext_namabarang);
        notifrememberCheckBox = findViewById(R.id.newproduct_checkbox_notification);
        simpanButton = findViewById(R.id.newproduct_materialbutton_save);

        //vars
        newProductViewModel = new NewProductViewModel(1234567890L);

        //widget configuration
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To Do
            }
        });
//        productImage
        idsAdapter = new IdsRecyclerViewAdapter(newProductViewModel.getProduct().getId().get(0), newProductViewModel.getRoleAutoCompleteTextview());
        idsRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        idsRecyclerview.setAdapter(idsAdapter);

        pricesAdapter = new PriceRecyclerViewAdapter(newProductViewModel.getPrice());
        pricesRecylerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        pricesRecylerview.setAdapter(pricesAdapter);

    }
}