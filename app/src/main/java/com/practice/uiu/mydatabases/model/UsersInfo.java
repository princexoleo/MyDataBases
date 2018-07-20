package com.practice.uiu.mydatabases.model;

import java.io.Serializable;

public class UsersInfo implements Serializable {
    private String name;
    private String password;
    private String city;
    private String country;

    private String id;

    public UsersInfo(String name, String password, String city, String country) {
        this.name = name;
        this.password = password;
        this.city = city;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UsersInfo(String name, String password, String city, String country, String id) {

        this.name = name;
        this.password = password;
        this.city = city;
        this.country = country;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
