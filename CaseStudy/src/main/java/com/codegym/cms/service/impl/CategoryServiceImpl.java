package com.codegym.cms.service.impl;

import com.codegym.cms.model.Category;
import com.codegym.cms.repository.CategoryRepository;
import com.codegym.cms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

//    @Override
//    public Category findByName(String name) {
//        return categoryRepository.findByName(name);
//    }
}
