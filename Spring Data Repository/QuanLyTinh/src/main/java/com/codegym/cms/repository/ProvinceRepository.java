package com.codegym.cms.repository;

import com.codegym.cms.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
    Province findOne(Long id);

    void delete(Long id);
}