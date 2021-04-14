package com.service;

import com.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private static String SELECT_FROM_ORDER_DETAIL_VIEW = "SELECT * FROM vw_orderdetail WHERE account =?";
    private static String INSERT_ORDER_DETAIL_VIEW = "INSERT INTO vw_orderdetail (account,productId,typename,color,memory,quanity,prices)  values (?,?,?,?,?,?,?) ";
    Connection connection = DataBaseConnection.getConnection();

    public List<Order> getListOrderDetailFromDataBase(String account) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_DETAIL_VIEW);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

        }
        return orderList;
    }
}
