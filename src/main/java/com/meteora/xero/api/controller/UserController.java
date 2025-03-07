package com.meteora.xero.api.controller;

import com.meteora.xero.api.model.UserModel;
import com.meteora.xero.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @GetMapping("/users")
    public UserModel getUser(@RequestParam Integer id){
        return userServices.getUser(id);
    }
}
