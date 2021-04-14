package Model;

import java.util.List;

public class Customer {
    private String account;
    private String password;
    private String name;
    private String numberPhone;
    private String address;
    private Cart cart;

    public Customer(String account, String password, String name, String numberPhone, String address) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.numberPhone = numberPhone;
        this.address = address;

    }

    public Customer() {
    }

    public Cart getCart() {
        return cart;
    }

    public static void setCart(Cart cart) {
    }




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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
