package com.codegym.cms.repository;

import com.codegym.cms.model.Image;
import com.codegym.cms.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImageReposisory extends PagingAndSortingRepository<Image, Long> {
    Page<Image> findAllByPost(Post post, Pageable pageable);
}
