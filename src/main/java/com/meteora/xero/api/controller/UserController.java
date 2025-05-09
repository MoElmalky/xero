package com.meteora.xero.api.controller;

import com.meteora.xero.api.model.Address;
import com.meteora.xero.api.model.CartItem;
import com.meteora.xero.api.model.User;
import com.meteora.xero.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return  userServices.getUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/signup")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try {
            User savedUser = userServices.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving user: " + e.getMessage());
        }
    }
    @PostMapping("/addAddress")
    public ResponseEntity<?> addAddress(@RequestBody Address address){
        try {
            Address savedAddress = userServices.addAddress(address);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving address: " + e.getMessage());
        }
    }
    @GetMapping("/{id}/addresses")
    public ResponseEntity<?> getAddresses(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userServices.getAddresses(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error getting user addresses: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/placeOrder")
    public ResponseEntity<?> placeOrder(@PathVariable Long id,@RequestParam Long addressId)
    {
        try {
            return ResponseEntity.ok(userServices.placeOrder(id,addressId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error placing order: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/orderHistory")
    public ResponseEntity<?> getOrderHistory(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userServices.getOrderHistory(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error getting order history: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/cart")
    public ResponseEntity<?> getCart(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userServices.getUserCart(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error getting user cart: " + e.getMessage());
        }
    }

    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCart(@RequestBody CartItem item){
        try {
            CartItem savedItem = userServices.addToCart(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding item: " + e.getMessage());
        }
    }
}
