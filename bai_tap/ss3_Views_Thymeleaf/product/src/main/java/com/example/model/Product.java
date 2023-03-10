package com.example.model;

public class Product {
    private int id;
    private String productName;
    private double price;
    private String status;
    private String produce;

    public Product() {
    }

    public Product(int id, String productName, double price, String status, String produce) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.produce = produce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }
}
