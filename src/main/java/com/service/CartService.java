package com.service;


import com.controller.Servlet;
import com.model.Cart;
import com.model.Customer;
import com.model.Product;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    private static String SELECT_PRODUCT_BY_ID = "SELECT * FROM vw_productDetail WHERE productId=?";
    private static String INSERT_INTO_CART = "INSERT INTO cart(productId, quantity, account) values(?,?,?) ";
    private static String GET_PRODUCT_LIST_CART = "SELECT * FROM vw_cartdetail WHERE account=?";
    private static String UPDATE_CART_BY_ID = "UPDATE cart SET quantity=? ,cartPrice=? WHERE productId=?";
    private static String DELETE_PRODUCT_IN_CART = "DELETE FROM cart WHERE productId=?";
    private static String GET_BEST_SELLER = "SELECT productId,typeName,color,memory,sum(quantityOrder) AS totalSold from vw_orderDetail  group by productID order by totalSold desc limit 3;";
    private static String GET_BAD_SELLER = "SELECT productId,typeName,color,memory,sum(quantityOrder) as totalSold from vw_orderDetail  group by productID order by totalSold asc limit 3;";
    static List<Product> listProduct = new ArrayList<>();
    Connection connection = DataBaseConnection.getConnection();

    public void getListProductCart(Integer id, String account) {
        boolean isExist = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("typeName");
                String color = resultSet.getString("color");
                Integer memory = resultSet.getInt("memory");
                String price = resultSet.getString("price");
                for (Product product : listProduct) {
                    if (product.getName().equals(name) && product.getColor().equals(color) && memory.equals(product.getMemory())) {
                        isExist = false;
                        int newQuantity = product.getQuantity() + 1;
//                        product.setQuantity(newQuantity);
                        long newPrice = Long.parseLong(product.getPrice()) + Long.parseLong(price);
//                        product.setPrice(Long.toString(newPrice));
                        updateCartInDataBase(product.getProductId(), newQuantity,Long.toString(newPrice));
                    }
                }
                if (isExist) {
                    Product product = new Product(id, name, color, memory, 1, price);
                    listProduct.add(product);
                    addCartInDataBase(new Product(id, name, color, memory, 1, price), account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        return listProduct;
    }

    private void updateCartInDataBase(int productId, int newQuantity, String newPrice) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_BY_ID);
        preparedStatement.setInt(1, newQuantity);
        preparedStatement.setString(2, newPrice);
        preparedStatement.setInt(3, productId);
        preparedStatement.executeUpdate();
    }

    public void deleteProductInCart(List<Product> listProduct) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_IN_CART);
        for (Product product : listProduct) {
            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.executeUpdate();
        }
    }

    public static List<Product> getListProduct() {
        return listProduct;
    }

    public void addCartInDataBase(Product product, String account) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CART);
        preparedStatement.setInt(1, product.getProductId());
        preparedStatement.setInt(2, product.getQuantity());
        preparedStatement.setString(3, account);
        preparedStatement.executeUpdate();

    }

    public List<Product> getCartInDataBaseByAccount(String account) throws SQLException {
        List<Product> productList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_LIST_CART);
        preparedStatement.setString(1, account);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("productId");
            String name = resultSet.getString("typename");
            String color = resultSet.getString("color");
            int memory = resultSet.getInt("memory");
            int quantity = resultSet.getInt("quantity");
            String price = resultSet.getString("cartPrice");
//            String cartPrice= resultSet.getString("cartPrice");
            Product product = new Product(id, name, color, memory, quantity, price);
            productList.add(product);
        }
        return productList;
    }

    public List<Product> getBestSeller() throws SQLException {
        List<Product> list = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_BEST_SELLER);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int productId = resultSet.getInt("productId");
            String name = resultSet.getString("typeName");
            String color = resultSet.getString("color");
            int memory = resultSet.getInt("memory");
            int quantity = resultSet.getInt("totalSold");
            list.add(new Product(productId, name, color, memory, quantity));
        }
        return list;

    }
    public List<Product> getBadSeller() throws SQLException {
        List<Product> list = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_BAD_SELLER);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int productId = resultSet.getInt("productId");
            String name = resultSet.getString("typeName");
            String color = resultSet.getString("color");
            int memory = resultSet.getInt("memory");
            int quantity = resultSet.getInt("totalSold");
            list.add(new Product(productId, name, color, memory, quantity));
        }
        return list;

    }
}
