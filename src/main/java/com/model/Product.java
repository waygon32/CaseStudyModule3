package com.model;

public class Product {
    private String name;
    private int memory;
    private String color;
    private float price;
    private int quantity;
    private String describeProduct;

    public Product(String name, int memory, String color, float price, int quantity, String describeProduct) {
        this.name = name;
        this.memory = memory;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.describeProduct = describeProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }
}

