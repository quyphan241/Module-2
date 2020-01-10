package com.codegym.cms.repository;

import com.codegym.cms.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Iterator;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
//    Category findByName(String name);
}
