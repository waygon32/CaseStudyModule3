package com.model;

public class Order {
    private int orderID;
    private String totalPrices;
    private Customer customer;
    private Cart cart;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(String totalPrices) {
        this.totalPrices = totalPrices;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
