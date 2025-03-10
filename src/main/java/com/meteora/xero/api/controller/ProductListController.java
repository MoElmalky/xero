package com.meteora.xero.api.controller;

import com.meteora.xero.services.ProductListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductListController {

    private final ProductListServices productListServices;

    @Autowired
    public ProductListController(ProductListServices productListServices) {
        this.productListServices = productListServices;
    }

    @GetMapping("/productsByCategory")
    public List<String> getProductsByCategory(@RequestParam String category) {
        return productListServices.getProductsByCategory(category);
    }
}
