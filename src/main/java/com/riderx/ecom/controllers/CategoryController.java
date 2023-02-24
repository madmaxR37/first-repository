package com.riderx.ecom.controllers;

import com.riderx.ecom.controllers.api_s.CategoryApi;
import com.riderx.ecom.dto.CategoryDto;
import com.riderx.ecom.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findByID(Long id) {
        return categoryService.findById(id);
    }

//    @Override
//    public CategoryDto findByName(String name) {
//        return categoryService.findByName(name);
//    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Long id) {
        categoryService.deleteByid(id);

    }
}
