package com.riderx.ecom.services;

import com.riderx.ecom.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Long id);

    //CategoryDto findByName(String name);

    List<CategoryDto> findAll();

    void deleteByid(Long id);

}
