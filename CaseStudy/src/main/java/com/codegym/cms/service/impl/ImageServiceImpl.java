package com.codegym.cms.service.impl;

import com.codegym.cms.model.Image;
import com.codegym.cms.model.Post;
import com.codegym.cms.repository.ImageReposisory;
import com.codegym.cms.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageReposisory imageReposisory;
    @Override
    public Image findById(Long id) {
        return imageReposisory.findById(id).get();
    }

    @Override
    public void save(Image image) {
        imageReposisory.save(image);
    }

    @Override
    public void remove(Long id) {
        imageReposisory.deleteById(id);
    }

    @Override
    public Page<Image> findAllByPost(Post post, Pageable pageable) {
        return imageReposisory.findAllByPost(post,pageable);
    }
}
