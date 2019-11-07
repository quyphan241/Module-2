package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 11", 1000, "Midnight Green","Apple"));
        products.put(2, new Product(2,"Mate 20 Pro",850,"Gradient","Huawei" ));
        products.put(3,new Product(3,"Galaxy Note 10",850,"Red","Samsung"));
        products.put(4,new Product(4, "Pixel 5",800,"Black","Google"));
        products.put(5, new Product(5, "Xperia XZ", 500, "White", "Sony"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        for(Product product: products.values()) {
            if(name.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }
}
