package com.example.tokomanagementsystem.model;

public class Id {

    private Long id;
    private String role;
    private Long mainId;

    public Id() {
    }

    public Id(Long id, String role, Long mainId) {
        this.id = id;
        this.role = role;
        this.mainId = mainId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }
}
