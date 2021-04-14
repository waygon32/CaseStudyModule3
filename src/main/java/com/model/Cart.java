package com.model;

import java.util.List;

public class Cart {
    private int productId;
    private String account;
    private String totalPrice;
    private List<Product> listProductInCart;

    public List<Product> getListProductInCart() {
        return listProductInCart;
    }

    public void setListProductInCart(List<Product> listProductInCart) {
        this.listProductInCart = listProductInCart;
    }

    public void addProductInListCart(Product product) {
        listProductInCart.add(product);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart() {
    }

    public Cart(int productId, String account, int quantity) {
        this.productId = productId;
        this.account = account;
        this.quantity = quantity;
    }
}
