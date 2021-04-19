package com.model;

public class Product {
    private int productId;
    private String typeId;
    private String color;
    private int memory;
    private String price;
    private int quantity;
    private String describeProduct;
    private String img;

    private String name;


    public Product() {
    }

    public Product(int productId, String typeId, String color, int memory, String price, int quantity, String describeProduct, String img) {
        this.productId = productId;
        this.typeId = typeId;
        this.color = color;
        this.memory = memory;
        this.price = price;
        this.quantity = quantity;
        this.describeProduct = describeProduct;
        this.img = img;
    }

    public Product(String typeId, String color, int memory, String price, int quantity, String describeProduct, String img) {
        this.typeId = typeId;
        this.color = color;
        this.memory = memory;
        this.price = price;
        this.quantity = quantity;
        this.describeProduct = describeProduct;
        this.img = img;
    }

    public Product(int productId, String typeId, String color, int memory, String price, int quantity, String describeProduct) {
        this.productId = productId;
        this.typeId = typeId;
        this.color = color;
        this.memory = memory;
        this.price = price;
        this.quantity = quantity;
        this.describeProduct = describeProduct;
    }

    public Product(String typeId, String color, int memory, String price, int quantity, String describeProduct) {
        this.typeId = typeId;
        this.color = color;
        this.memory = memory;
        this.price = price;
        this.quantity = quantity;
        this.describeProduct = describeProduct;
    }

    public Product(int id, String productName, String color, int memory, String describe, String price) {
        this.name = productName;
        this.color = color;
        this.memory = memory;
        this.describeProduct = describe;
        this.price = price;
        this.productId = id;

    }
    public Product(int id, String productName, String color, int memory, String describe, String price,String img) {
        this.name = productName;
        this.color = color;
        this.memory = memory;
        this.describeProduct = describe;
        this.price = price;
        this.productId = id;
        this.img= img;
    }
    public Product(String color, int memory, String price, String describeProduct, String img, String name) {
        this.color = color;
        this.memory = memory;
        this.price = price;
        this.describeProduct = describeProduct;
        this.img = img;
        this.name = name;
    }

    public Product(int id, String name, String color, int memory, int quantity, String price) {
        this.color = color;
        this.memory = memory;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.productId = id;
    }

    public Product(int id, String name, String color, int memory, int quantity) {
        this.color = color;
        this.memory = memory;
        this.quantity = quantity;
        this.name = name;
        this.productId = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getPrice() {
        return price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}