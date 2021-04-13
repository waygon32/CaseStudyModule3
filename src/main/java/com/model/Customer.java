package com.model;

public class Customer {
    private String account;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;

    public Customer() {
    }
//    public Customer(String account, String password, String name, String address, String phoneNumber) {
//        this.account = account;
//        this.password = password;
//        this.name = name;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
