package com.codegym.service;

import com.codegym.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

        List<Product> findAll() throws SQLException, ClassNotFoundException;
        void save(Product product) throws SQLException, ClassNotFoundException;

        Product findById(int id) throws SQLException, ClassNotFoundException;

        void update(int id, Product product) throws SQLException, ClassNotFoundException;

        void remove(int id) throws SQLException, ClassNotFoundException;
        Product findByName(String name);

}
