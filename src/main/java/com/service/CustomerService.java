package com.service;

import com.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerService {
    public Customer checkLogin(String account, String password) {
        Connection connection = DataBaseConnection.databaseConnection();
        String userInput = " SELECT * FROM customer WHERE account = ? and password = ? ";
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(userInput);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer();
                customer.setName(resultSet.getString("name"));
                customer.setAccount(account);
                customer.setPassword(password);
                customer.setAddress(resultSet.getString("address"));
                customer.setPhoneNumber(resultSet.getString("phoneNumber"));
            }
            connection.close();
        } catch (SQLException | NullPointerException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    public boolean checkAccount(String account) {
        boolean check = true;
        Connection connection = DataBaseConnection.databaseConnection();
        String userInput = " SELECT * FROM customer WHERE account = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(userInput);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                check = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
    public void addCustomer (String account , String password, String name, String address, String phoneNumber){
        Connection connection = DataBaseConnection.databaseConnection();
        String userInput = "INSERT INTO customer (account, password, name, address, phoneNumber) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(userInput);
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,address);
            preparedStatement.setString(5,phoneNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
