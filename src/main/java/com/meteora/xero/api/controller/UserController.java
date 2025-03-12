package com.meteora.xero.api.controller;

import com.meteora.xero.api.model.ProductModel;
import com.meteora.xero.api.model.UserModel;
import com.meteora.xero.services.ProductServices;
import com.meteora.xero.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServices userServices;
    private final ProductServices productServices;

    @Autowired
    public UserController(UserServices userServices,ProductServices productServices){
        this.userServices = userServices;
        this.productServices = productServices;
    }

    @GetMapping
    public UserModel getUser(@RequestParam Integer id){
        return userServices.getUser(id);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> addUser(@RequestBody UserServices.UserDTO user){
        userServices.addUser(user);
        return ResponseEntity.ok("User add successfully");
    }

    @GetMapping("/cart")
    public ArrayList<ProductModel> getCart(@RequestParam Integer id){
        ArrayList<ProductModel> cart = new ArrayList<>();
        for(Integer product : userServices.getUserCart(id)){
            cart.add(productServices.getProduct(product));
        }
        return cart;
    }

    @PostMapping("/cart")
    public String addToCart(@RequestParam Integer userId,@RequestParam Integer productId){
        if(userServices.addToCart(userId,productId)){
            return "Product added successfully!";
        } else {
            return "User not found!";
        }
    }
}
