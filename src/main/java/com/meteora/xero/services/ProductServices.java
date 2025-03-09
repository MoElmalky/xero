package com.meteora.xero.services;


import com.meteora.xero.api.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServices {

    private final List<ProductModel> products;

    public ProductServices(){
        products = new ArrayList<>();

        ProductModel Product1 = new ProductModel(1,"Tesla",2,20000,"Tesla, Inc. is a pioneering American company specializing in electric vehicles (EVs)",12, "AI");
        ProductModel Product2 = new ProductModel(2,"Phone",4,3000,"The iPhone, developed by Apple Inc",13,"Gaming");
        ProductModel Product3 = new ProductModel(3,"Tv",3,200,"Smart tv",15, "Gaming");
        ProductModel Product4 = new ProductModel(4,"Refrigerator",6,400,"A refrigerator is a household and commercial appliance designed to preserve food and beverages by maintaining a low temperature, slowing bacterial growth, and preventing spoilage. Modern refrigerators come in various designs, sizes, and technologies to suit different needs",12, "AI");
        ProductModel Product5 = new ProductModel(5,"Samsung 75",4,3000,"A smart TV with 8K QLED technology, AI-powered image enhancement, and an advanced audio system for a cinematic experience",13, "Gaming");
        ProductModel Product6 = new ProductModel(6,"PlayStation 5",4,600,"ony’s next-gen gaming console with an AMD Ryzen processor, 4K support, and a DualSense controller with advanced haptic feedback",12, "Gaming");
        ProductModel Product7 = new ProductModel(7,"Dell XPS 15 ",2,500,"A premium Windows laptop with an OLED 4K touchscreen, Intel Core i9 processor, NVIDIA RTX 4070 graphics, and a sleek aluminum design",18, "working");
        ProductModel Product8 = new ProductModel(8,"Mirrorless Camera",1,2800,"A professional mirrorless camera with a 33MP full-frame sensor, 4K 60fps video recording, and real-time autofocus tracking, ideal for photography and filmmaking",12, "PG");
        ProductModel Product9 = new ProductModel(9,"Apple Watch",200,500,"A rugged smartwatch designed for adventurers and athletes, featuring a Titanium case, 100m water resistance, dual-frequency GPS, and up to 72 hours of battery life in low-power mode",16, "AI");
        ProductModel Product10 = new ProductModel(10,"Ahmed",2,400,"A rugged smartwatch designed for adventurers and athletes, featuring a Titanium case, 100m water resistance, dual-frequency GPS, and up to 72 hours of battery life in low-power mode",12, "AI");

        products.addAll(Arrays.asList(Product1,Product2,Product3,Product4,Product5,Product6,Product7,Product8,Product9,Product10));
    }


    public ProductModel getProduct(Integer id) {
        for(ProductModel product : products){
            if(id == product.getId()){
                return product;
            }
        }
        return null;
    }

    public ArrayList<ProductModel> getList(String listName){
        ArrayList<ProductModel> list = new ArrayList<>();

        for(ProductModel product : products){
            if(product.getCategory().equals(listName)){
                list.add(product);
            }
        }
        return list;
    }
}
