package com.blog.service.impl;

import com.blog.model.Blog;
import com.blog.repository.BlogRepository;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public Blog findById(Long id) {
        return null;
    }

    @Override
    public void save(Blog customer) {
        blogRepository.save(customer);
    }

    @Override
    public void remove(Long id) {

    }
}
