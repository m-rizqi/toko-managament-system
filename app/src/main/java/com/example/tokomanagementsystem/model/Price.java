package com.example.tokomanagementsystem.model;

public class Price {

    private Long id;
    private String unit;
    private Long merchantPrice;
    private Long consumentPrice;
    private Price nextLinkPrice;
    private int quantityLink;

    public Price() {
    }

    public Price(Long id, String unit) {
        this.id = id;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getMerchantPrice() {
        return merchantPrice;
    }

    public void setMerchantPrice(Long merchantPrice) {
        this.merchantPrice = merchantPrice;
    }

    public Long getConsumentPrice() {
        return consumentPrice;
    }

    public void setConsumentPrice(Long consumentPrice) {
        this.consumentPrice = consumentPrice;
    }

    public Price getNextLinkPrice() {
        return nextLinkPrice;
    }

    public void setNextLinkPrice(Price nextLinkPrice) {
        this.nextLinkPrice = nextLinkPrice;
    }

    public int getQuantityLink() {
        return quantityLink;
    }

    public void setQuantityLink(int quantityLink) {
        this.quantityLink = quantityLink;
    }
}
