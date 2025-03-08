package com.meteora.xero.api.model;

public class ProductModel {

    private int id;
    private String ProductName;
    private int Lifespan;
    private int price;
    private String description;
    private float ValueProposition;


    public ProductModel(int id, String ProductName, int Lifespan, int price, String description, float ValueProposition) {
        this.id = id;
        this.ProductName = ProductName;
        this.Lifespan = Lifespan;
        this.price = price;
        this.description = description;
        this.ValueProposition = ValueProposition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setLifespan(int Lifespan) {
        this.Lifespan = Lifespan;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public void setValueProposition(float ValueProposition) {
        this.ValueProposition = ValueProposition;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getProductName() {
        return this.ProductName;
    }

    public int getLifespan() {
        return this.Lifespan;
    }

    public int getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public float getValueProposition() {
        return this.ValueProposition;
    }
}

