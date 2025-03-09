package com.meteora.xero.api.model;

import java.util.ArrayList;

public class UserModel {
    private int id;
    private String name;
    private int age;
    private String email;
    private ArrayList<Integer> cart;

    public UserModel(int id, String name, int age, String email){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.cart = new ArrayList<>();
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public void addToCard(int productId){
        this.cart.add(productId);
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getEmail(){
        return this.email;
    }

    public ArrayList<Integer> getCart(){return this.cart;}
}
