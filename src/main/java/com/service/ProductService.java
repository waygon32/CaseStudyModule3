package com.service;


import com.model.Product;

import java.io.StringReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProduct {
    public static final String GET_ALL_PRODUCT = "SELECT * FROM productdetail";
    public static final String ADD_PRODUCT = "INSERT INTO productdetail(typeID,color,memory,price,quantity,describeProduct,img) VALUES(?,?,?,?,?,?,?)";
    public static final String GET_PRODUCT_BY_ID = "SELECT * from productdetail WHERE productId = ?";
    public static final String DELETE_PRODUCT = "DELETE FROM productdetail WHERE productId=?";
    public static final String UPDATE_PRODUCT = "UPDATE productdetail SET typeID=? ,color=?,memory=?,price=?,quantity=?,describeProduct=?,img=? WHERE productID=?";
    public static final String LIST_PRODUCT_FOR_CUSTOMER = "select  typeName, color,memory,describeProduct , price,productID from producttype  inner join productdetail on productdetail.typeId=  producttype.typeId order by  typename asc";

    //   Connection connection = DataBaseConnection.databaseConnection();
    Connection connection = DatabaseConnection.getConnection();

    @Override
    public List<Product> getAllList() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productID = resultSet.getInt("productId");
                String typeID = resultSet.getString("typeID");
                String color = resultSet.getString("color");
                int memory = resultSet.getInt("memory");
                String price = resultSet.getString("price");
                int quantity = resultSet.getInt("quantity");
                String describeProduct = resultSet.getString("describeProduct");
//                String img = resultSet.getString("img");
                productList.add(new Product(productID, typeID, color, memory, price, quantity, describeProduct));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String typeID = resultSet.getString("typeID");
                String color = resultSet.getString("color");
                int memory = resultSet.getInt("memory");
                String price = resultSet.getString("price");
                int quantity = resultSet.getInt("quantity");
                String describeProduct = resultSet.getString("describeProduct");
                String img = resultSet.getString("img");
                product = new Product(id, typeID, color, memory, price, quantity, describeProduct, img);
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override

    public boolean updateProduct(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
        preparedStatement.setString(1, product.getTypeId());
        preparedStatement.setString(2, product.getColor());
        preparedStatement.setInt(3, product.getMemory());
        preparedStatement.setString(4, product.getPrice());
        preparedStatement.setInt(5, product.getQuantity());
        preparedStatement.setString(6, product.getDescribeProduct());
        preparedStatement.setString(7, product.getImg());
        preparedStatement.setInt(8, product.getProductId());
        preparedStatement.executeUpdate();
        return false;
    }

    @Override
    public boolean createProduct(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT);
        preparedStatement.setString(1, product.getTypeId());
        preparedStatement.setString(2, product.getColor());
        preparedStatement.setInt(3, product.getMemory());
        preparedStatement.setString(4, product.getPrice());
        preparedStatement.setInt(5, product.getQuantity());
        preparedStatement.setString(6, product.getDescribeProduct());
        preparedStatement.setString(7, product.getImg());
        preparedStatement.executeUpdate();
        return true;
    }

    public List<Product> getListProductForCustomer() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LIST_PRODUCT_FOR_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("typeName");
                String color = resultSet.getString("color");
                int memory = resultSet.getInt("memory");
                String describe = resultSet.getString("describeProduct");
                String price = resultSet.getString("price");
                int id = resultSet.getInt("productId");
                productList.add(new Product(id, productName, color, memory, describe, price));
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public Product isProductExist(String typeID, String color, int memory) {
        List<Product> productList = getAllList();
        Product product= null;
        for (Product p : productList) {
            if (p.getTypeId().equals(typeID) && p.getColor().equals(color) && p.getMemory() == memory) {
                product=p;
            }
        }
        return product;
    }

}