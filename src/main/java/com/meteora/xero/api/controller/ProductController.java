package com.meteora.xero.api.controller;

import com.meteora.xero.api.model.ProductModel;
import com.meteora.xero.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/p")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices ProductServices){this.productServices = ProductServices;}

    @GetMapping
    public ProductModel getProduct(@RequestParam Integer id){
        return productServices.getProduct(id);
    }

    @GetMapping("/list")
    public ArrayList<ProductModel> getList(@RequestParam String listName){
        return productServices.getList(listName);
    }
}
