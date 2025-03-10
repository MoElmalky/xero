package com.meteora.xero.api.controller;

import com.meteora.xero.api.model.ProductModel;
import com.meteora.xero.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductServices ProductServices;

    @Autowired
    public ProductController(ProductServices ProductServices){this.ProductServices = ProductServices;}

    @GetMapping ("/Products")
    public ProductModel getproduct(@RequestParam Integer id){
        return ProductServices.getproduct(id);
    }
}
