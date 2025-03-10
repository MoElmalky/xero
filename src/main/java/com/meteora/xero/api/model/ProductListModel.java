package com.meteora.xero.api.model;

public class ProductListModel {
    private int id;
    private String productName;
    private int lifespan;
    private int price;
    private String description;
    private float valueProposition;
    private String category;

    public ProductListModel(int id, String productName, int lifespan, int price, String description, float valueProposition, String category) {
        this.id = id;
        this.productName = productName;
        this.lifespan = lifespan;
        this.price = price;
        this.description = description;
        this.valueProposition = valueProposition;
        this.category = category;
    }

    public int getId() { return id; }
    public String getProductName() { return productName; }
    public int getLifespan() { return lifespan; }
    public int getPrice() { return price; }
    public String getDescription() { return description; }
    public float getValueProposition() { return valueProposition; }
    public String getCategory() { return category; }

    public void setId(int id) { this.id = id; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setLifespan(int lifespan) { this.lifespan = lifespan; }
    public void setPrice(int price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setValueProposition(float valueProposition) { this.valueProposition = valueProposition; }
    public void setCategory(String category) { this.category = category; }
}
