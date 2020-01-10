package com.codegym.cms.service;

import com.codegym.cms.model.Comment;
import com.codegym.cms.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<Comment> findAllByPost(Post post, Pageable pageable);

    void save(Comment comment);

    void remove(Long id);

    Comment findById(Long id);
}
