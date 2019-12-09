package com.blog.repository.impl;

import com.blog.model.Blog;
import com.blog.repository.BlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepositoryImpl
        implements BlogRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public Blog findById(Long id) {
        return null;
    }

    @Override
    public void save(Blog model) {
        if(model.getId() != null){
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {

    }
}
