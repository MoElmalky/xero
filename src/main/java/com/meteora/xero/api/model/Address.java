package com.meteora.xero.api.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private String country;
    private String governorate;
    private String city;
    private String district;
    private String street;
    private String building;

    public Address(){}

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getBuilding() {
        return building;
    }

    public String getDistrict() {
        return district;
    }

    public String getGovernorate() {
        return governorate;
    }
}
