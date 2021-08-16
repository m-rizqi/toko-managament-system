package com.example.tokomanagementsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private List<Id> id;
    private String name;
    private Price prices;
    private String imagePath;
    private int clickCount;

    public Product(Id id) {
        this.id = new ArrayList<>();
        this.id.add(id);
    }

    public Product(List<Id> id, String name, Price prices, String imagePath, int clickCount) {
        this.id = id;
        this.name = name;
        this.prices = prices;
        this.imagePath = imagePath;
        this.clickCount = clickCount;
    }

    public List<Id> getId() {
        return id;
    }

    public void setId(List<Id> id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrices() {
        return prices;
    }

    public void setPrices(Price prices) {
        this.prices = prices;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }
}
