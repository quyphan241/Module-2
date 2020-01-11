package com.codegym.cms.repository;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Post;
import javafx.geometry.Pos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Page<Post> findAll();
    Page<Post> findAllByCategory(Category category, Pageable pageable);
    Page<Post> findAllByTitleContaining(String search, Pageable pageable);
//    Iterable<Post> findTop3();

    Page<Post> findTop4ByOrderByIdDesc(Pageable pageable);
    Iterable<Post> findTop3ByCategoryOrderByIdDesc(Category category);
 }