package com.codegym.cms.service;

import com.codegym.cms.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAll(Pageable pageable);
    void save(User user);

    void remove(Long id);

    User findById(Long id);
}
