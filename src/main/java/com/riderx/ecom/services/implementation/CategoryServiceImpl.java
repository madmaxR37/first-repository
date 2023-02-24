package com.riderx.ecom.services.implementation;

import com.riderx.ecom.Repositories.CategoryRepo;
import com.riderx.ecom.dto.CategoryDto;
import com.riderx.ecom.exceptions.EntityNotFoundException;
import com.riderx.ecom.exceptions.InvalideEntityException;
import com.riderx.ecom.models.Category;
import com.riderx.ecom.services.CategoryService;
import com.riderx.ecom.validators.CategoryValidator;
import com.riderx.ecom.exceptions.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {

        List<String> errors = CategoryValidator.validate(categoryDto);
        if(!errors.isEmpty()){
            log.error("The category is not valid {}", categoryDto);
            throw new InvalideEntityException("The category is not valid ", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }

        return CategoryDto.fromEntity(categoryRepo.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Long id) {

        if(id == null){

            log.error("Null ID ");
            return null;
        }

        Optional<Category> category = categoryRepo.findById(id);
        CategoryDto categoryDto = CategoryDto.fromEntity(category.get());
        return Optional.of(categoryDto).orElseThrow(()->
                      new  EntityNotFoundException("Entity with id "+id+" not found", ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

//    @Override
//    public CategoryDto findByName(String name) {
//
//        if(!StringUtils.hasLength(name)){
//            log.error("This name is null");
//            return null;
//        }
//
//        Optional<Category> category = categoryRepo.findByName(name);
//        CategoryDto categoryDto = CategoryDto.fromEntity(category.get());
//        return Optional.of(categoryDto).orElseThrow((()->
//                new EntityNotFoundException("Category with name " +name+ "not found", ErrorCodes.CATEGORY_NOT_FOUND)
//                ));
//    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepo.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByid(Long id) {
        if(id == null){

            log.error("Null ID ");
        }

        categoryRepo.deleteById(id);
    }
}
