package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
    void edit(Product product);
}
