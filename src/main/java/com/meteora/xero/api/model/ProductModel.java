package com.meteora.xero.api.model;

public class ProductModel {

    private Integer id;
    private String productName;
    private Integer price;
    private String description;
    private String category;

    public ProductModel(Integer id, String productName, Integer price, String description,String category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.category = category;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Integer getId() {
        return this.id;
    }
    public String getProductName() {
        return this.productName;
    }
    public Integer getPrice() {
        return this.price;
    }
    public String getDescription() {
        return this.description;
    }
    public String getCategory() {
        return this.category;
    }
}

