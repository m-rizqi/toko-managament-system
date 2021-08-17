package com.example.tokomanagementsystem.model;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String fullname;
    private String email;
    private String password;
    private List<String> unitList;
    private Long income;

    @SuppressLint("NewApi")
    public User() {
        this.unitList = new ArrayList<>(
                List.of("Bungkus", "Pack", "Sachet", "Renteng", "Kg")
        );
    }

    @SuppressLint("NewApi")
    public User(Long id, String fullname, String email, String password, List<String> unitList, Long income) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.unitList = new ArrayList<>(
                List.of("Bungkus", "Pack", "Sachet", "Renteng", "Kg")
        );
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<String> unitList) {
        this.unitList = unitList;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }
}
