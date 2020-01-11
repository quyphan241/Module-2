package com.codegym.cms.service.impl;

import com.codegym.cms.model.Comment;
import com.codegym.cms.model.Post;
import com.codegym.cms.repository.CommentRepository;
import com.codegym.cms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.PreparedStatement;

public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Page<Comment> findAllByPost(Post post, Pageable pageable) {
        return commentRepository.findAllByPostOrderByIdDesc(post, pageable);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }
}
