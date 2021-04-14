package com.service;


import com.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    List<Product> getAllList();

     Product findById(int id) ;

    void deleteProduct(int id) throws SQLException;
    boolean  updateProduct(Product product) throws SQLException;
    boolean createProduct(Product product) throws SQLException;
}
