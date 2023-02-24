package com.riderx.ecom.validators;

import com.riderx.ecom.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto){

        List<String> errors = new ArrayList<>();

        if(categoryDto == null || !StringUtils.hasLength(categoryDto.getName())){
            errors.add("Enter the category name");
        }
        return errors;
    }
}
