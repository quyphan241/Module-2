package com.blog.service;

import com.blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog customer);

    void remove(Long id);
}
