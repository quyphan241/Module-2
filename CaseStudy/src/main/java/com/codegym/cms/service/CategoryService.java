package com.codegym.cms.service;

import com.codegym.cms.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);

    void remove(Long id);

    void save(Category category);

//    Category findByName(String name);
}
