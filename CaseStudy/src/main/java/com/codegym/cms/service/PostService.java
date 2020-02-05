package com.codegym.cms.service;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PostService {
    Page<Post> findAll(Pageable pageable);

    Post findById(Long id);

    void save(Post post);

    void remove(Long id);

    Page<Post> findAllByCategory(Category category, Pageable pageable);

    Page<Post> findAllByTitleContaining(String search, Pageable pageable);

    Page<Post> findTop4LatestPost(Pageable pageable);

    Iterable<Post> findTop3ByCategory(Category category);

    Iterable<Post> findTop2ByCategory(Category category);

    Iterable<Post> findTop3MostView();


}