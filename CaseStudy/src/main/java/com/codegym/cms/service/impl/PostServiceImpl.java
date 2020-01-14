package com.codegym.cms.service.impl;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Post;
import com.codegym.cms.repository.PostRepository;
import com.codegym.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Page<Post> findAllByCategory(Category category, Pageable pageable) {
        return postRepository.findAllByCategoryOrderByIdDesc(category, pageable);
    }

    @Override
    public Page<Post> findAllByTitleContaining(String search, Pageable pageable) {
        return postRepository.findAllByTitleContaining(search,pageable);
    }

    @Override
    public Page<Post> findTop4LatestPost(Pageable pageable) {
        return postRepository.findTop4ByOrderByIdDesc(pageable);
    }

    @Override
    public Iterable<Post> findTop3ByCategory(Category category) {
        return postRepository.findTop3ByCategoryOrderByIdDesc(category);
    }

    @Override
    public Iterable<Post> findTop2ByCategory(Category category) {
        return postRepository.findTop2ByCategoryOrderByIdDesc(category);
    }
}
