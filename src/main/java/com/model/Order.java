package com.model;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private int orderId;
    private String totalPrices;
    private Customer customer;
    private String account;
    private Cart cart;
    private String status;
    private String orderDate;
    private String receivedTime;

    public String getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(String receivedTime) {
        this.receivedTime = receivedTime;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


//    public Order(int orderID, Customer customer, Cart cart) {
//        this.orderId = orderID;
//        this.customer = customer;
//        this.cart = cart;
//    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Order(int orderId, String account, String total, String status, String orderDate, String receivedTime) {
        this.orderId = orderId;
        this.account = account;
        this.totalPrices = total;
        this.status = status;
        this.orderDate = orderDate;
        this.receivedTime = receivedTime;

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getOrderID() {
        return orderId;
    }

    public void setOrderID(int orderID) {
        this.orderId = orderID;
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
