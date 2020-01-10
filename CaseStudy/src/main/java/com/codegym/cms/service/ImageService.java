package com.codegym.cms.service;

import com.codegym.cms.model.Comment;
import com.codegym.cms.model.Image;
import com.codegym.cms.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ImageService {
    Image findById(Long id);

    void save(Image image);

    void remove(Long id);

    Page<Image> findAllByPost(Post post, Pageable pageable);

}
