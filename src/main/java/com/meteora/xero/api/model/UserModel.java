package com.meteora.xero.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class UserModel {
    private Integer id;
    private FullName fullName;
    private BirthDate birthDate;
    private String email;
    private Address address;
    private final ArrayList<Integer> cart;

    public UserModel(Integer id, FullName fullName, BirthDate birthDate,Address address, String email){
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.email = email;
        this.cart = new ArrayList<>();
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setFullName(FullName fullName){
        this.fullName = fullName;
    }
    public void setBirthData(BirthDate birthDate){
        this.birthDate = birthDate;
    }
    public void setAddress(Address address) {this.address = address;}
    public void setEmail(String email){
        this.email = email;
    }
    public void addToCard(Integer productId){
        this.cart.add(productId);
    }
    public Integer getId(){
        return this.id;
    }
    public FullName getFullName(){
        return this.fullName;
    }
    public BirthDate getBirthData(){
        return this.birthDate;
    }
    public String getEmail(){return this.email;}
    public Address getAddress() {return address;}
    @JsonIgnore
    public ArrayList<Integer> getUserCart(){return this.cart;}
    public static class Address{
        private String country;
        private String state;
        private String city;
        private String street;
        private Integer postalCode;
        public Address(String country,String state, String city,String street, Integer postalCode){
            this.country = country;
            this.state = state;
            this.city = city;
            this.street = street;
            this.postalCode = postalCode;
        }
        public void setCountry(String country) {this.country = country;}
        public void setState(String state) {this.state = state;}
        public void setCity(String city) {this.city = city;}
        public void setStreet(String street) {this.street = street;}
        public void setPostalCode(Integer postalCode) {this.postalCode = postalCode;}
        public String getCountry() {return country;}
        public String getState() {return state;}
        public String getCity() {return city;}
        public String getStreet() {return street;}
        public Integer getPostalCode() {return postalCode;}
    }

    public static class BirthDate{
        private Integer year;
        private Integer month;
        private Integer day;

        public BirthDate(Integer year,Integer month, Integer day){
            this.year = year;
            this.month = month;
            this.day = day;
        }
        public void setYear(Integer year) {this.year = year;}
        public void setMonth(Integer month) {this.month = month;}
        public void setDay(Integer day) {this.day = day;}
        public Integer getYear() {return year;}
        public Integer getMonth() {return month;}
        public Integer getDay() {return day;}
    }

    public static class FullName{
        private String firstName;
        private String middleName;
        private String lastName;

        public FullName(String firstName, String middleName, String lastName){
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }

        public void setFirstName(String firstName) {this.firstName = firstName;}
        public void setMiddleName(String middleName) {this.middleName = middleName;}
        public void setLastName(String lastName) {this.lastName = lastName;}
        public String getFirstName() {return firstName;}
        public String getMiddleName() {return middleName;}
        public String getLastName() {return lastName;}
    }
}
