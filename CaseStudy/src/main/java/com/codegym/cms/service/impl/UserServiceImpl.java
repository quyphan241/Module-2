package com.codegym.cms.service.impl;

import com.codegym.cms.model.User;
import com.codegym.cms.repository.UserRepository;
import com.codegym.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
