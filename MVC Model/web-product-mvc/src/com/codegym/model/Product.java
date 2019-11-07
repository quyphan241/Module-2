package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private String manufactor;

    public Product() {
    }

    public Product(int id, String name, int price, String description, String manufactor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufactor = manufactor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }
}
