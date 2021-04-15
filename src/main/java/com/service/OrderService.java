package com.service;

import com.model.Order;
import com.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private static String SELECT_FROM_ORDER_DETAIL_VIEW_BY_ACCOUNT = "SELECT * FROM vw_orderdetail WHERE account =? and orderID=?";
    private static String SELECT_FROM_ORDER_HISTORY = "SELECT * FROM vw_orderdetail WHERE account =? and  status='done' ";
    private static String SELECT_FROM_ORDER_DETAIL_VIEW = "SELECT orderID, account , sum(prices) AS total , status,orderDate FROM vw_orderDetail  group by orderID;";
    private static String INSERT_ORDER_DETAIL = "INSERT INTO ordersdetail (orderId,productId,qualtityOrder)  values (?,?,?) ";
    private static String INSERT_ORDER = "INSERT INTO orders (orderId,account) values (?,?) ";
    private static String UPDATE_LIST_WHEN_BOUGHT = "UPDATE productDetail SET qualtity =? WHERE productId=? ";
    private static String UPDATE_STATUS_IN_ORDER = "UPDATE ordersdetail SET status=? WHERE orderId=?";
    Connection connection = DataBaseConnection.getConnection();

    public List<Product> getProductListInOrder(String account, int orderId) throws SQLException {
        List<Product> productList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_ORDER_DETAIL_VIEW_BY_ACCOUNT);
        preparedStatement.setString(1, account);
        preparedStatement.setInt(2, orderId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("typeName");
            int productId = resultSet.getInt("productId");
            int quantity = resultSet.getInt("quantityOrder");
            String color = resultSet.getString("color");
            int memory = resultSet.getInt("memory");
            String price = resultSet.getString("prices");
            Product product = new Product(productId, name, color, memory, quantity, price);
            productList.add(product);
        }
        return productList;
    }

    public List<Product> getOrderHistory(String account) throws SQLException {
        List<Product> productList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_ORDER_HISTORY);
        preparedStatement.setString(1, account);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("typeName");
            int productId = resultSet.getInt("orderId");
            int quantity = resultSet.getInt("quantityOrder");
            String color = resultSet.getString("color");
            int memory = resultSet.getInt("memory");
            String price = resultSet.getString("prices");
            Product product = new Product(productId, name, color, memory, quantity, price);
            productList.add(product);
        }
        return productList;
    }

    public void insertOrderDetailView(List<Product> listProduct, String account) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_DETAIL);
        PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_ORDER);
        int orderID = (int) (Math.random() * 1000) * (int) (Math.random() * 5);
        preparedStatement1.setInt(1, orderID);
        preparedStatement1.setString(2, account);
        preparedStatement1.executeUpdate();
        for (Product product : listProduct) {
            preparedStatement.setInt(1, orderID);
            preparedStatement.setInt(2, product.getProductId());
            preparedStatement.setInt(3, product.getQuantity());
//            preparedStatement.setInt(4, "wating");
            preparedStatement.executeUpdate();
        }
    }

    public List<Order> getAllListOrderDetail() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_ORDER_DETAIL_VIEW);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
//            Integer orderId = resultSet.getInt("orderId");
//            String account = resultSet.getString("account");
//            String name = resultSet.getString("typeName");
//            int productId = resultSet.getInt("productId");
//            int quantity = resultSet.getInt("quantity");
//            String color = resultSet.getString("color");
//            int memory = resultSet.getInt("memory");
//            String price = resultSet.getString("price");
//            for (Order order : orderList) {
//                if (order.getCustomer().getAccount().equals(account) && orderId.equals(order.getOrderID())) {
//                    isExist = true;
//                }
            String account = resultSet.getString("account");
            int orderId = resultSet.getInt("orderId");
            String total = resultSet.getString("total");
            String status = resultSet.getString("status");
            String orderDate = resultSet.getString("orderDate");
            Order order = new Order(orderId, account, total, status, orderDate);
            orderList.add(order);

        }
        return orderList;
    }

    public boolean isUpdatedListWhenBought(List<Product> productList, int orderId, String status) {
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        ProductService productService = new ProductService();

        try {
            preparedStatement1 = connection.prepareStatement(UPDATE_STATUS_IN_ORDER);
            preparedStatement1.setString(1, status);
            preparedStatement1.setInt(2,orderId);
            preparedStatement1.executeUpdate();
            for (Product product : productList) {

                if (status.equalsIgnoreCase("done")) {
                    Product productInDb = productService.findById(product.getProductId());
                    int oldQuantity = productInDb.getQuantity();
                    int quantityBuy = product.getQuantity();
                    int newQuantity = oldQuantity - quantityBuy;
                    preparedStatement = connection.prepareStatement(UPDATE_LIST_WHEN_BOUGHT);
                    preparedStatement.setInt(1, newQuantity);
                    preparedStatement.setInt(2, product.getProductId());
                    preparedStatement.executeUpdate();
                }
            }


            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

}




