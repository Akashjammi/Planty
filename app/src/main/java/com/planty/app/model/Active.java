package com.planty.app.model;

public class Active {
    String title;
    String productname;
    String stock;
    String cost;

    public Active(String title, String productname, String stock, String cost) {
        this.title = title;
        this.productname = productname;
        this.stock = stock;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
