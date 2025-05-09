package com.meteora.xero.api.controller;

import com.meteora.xero.api.model.Product;
import com.meteora.xero.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/p")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices ProductServices){this.productServices = ProductServices;}

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        return productServices.getProduct(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<?> getByName(@RequestParam String name){
        try {
            return  ResponseEntity.ok(productServices.getByName(name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        try {
            Product savedProduct = productServices.addProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving product: " + e.getMessage());
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getByCategory(@PathVariable String category){
        try {
            return  ResponseEntity.ok(productServices.getByCategory(category));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
