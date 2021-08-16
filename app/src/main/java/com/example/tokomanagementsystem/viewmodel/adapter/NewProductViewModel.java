package com.example.tokomanagementsystem.viewmodel.adapter;

import android.annotation.SuppressLint;

import com.example.tokomanagementsystem.model.Id;
import com.example.tokomanagementsystem.model.Price;
import com.example.tokomanagementsystem.model.Product;

import java.util.ArrayList;
import java.util.List;

public class NewProductViewModel {

    private Product product;
    private Price price;
    private ArrayList<String> roleAutoCompleteTextview;

    @SuppressLint("NewApi")
    public NewProductViewModel(Long firstId){
        Id id = new Id(firstId,"Default", null);
        product = new Product(id);
        price = new Price();
        product.setPrices(price);
        roleAutoCompleteTextview = new ArrayList<>(
                List.of("Default","Bungkus", "Pack")
        );
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ArrayList<String> getRoleAutoCompleteTextview() {
        return roleAutoCompleteTextview;
    }

    public void setRoleAutoCompleteTextview(ArrayList<String> roleAutoCompleteTextview) {
        this.roleAutoCompleteTextview = roleAutoCompleteTextview;
    }
}
