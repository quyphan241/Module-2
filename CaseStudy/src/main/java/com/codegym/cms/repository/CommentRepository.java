package com.codegym.cms.repository;

import com.codegym.cms.model.Comment;
import com.codegym.cms.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    Page<Comment> findAllByPostOrderByIdDesc(Post post, Pageable pageable);
    Long countAllByPost(Post post);

}
