package com.riderx.ecom.validators;

import com.riderx.ecom.dto.ItemDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ItemValidator {

    public static List<String> validate(ItemDto itemDto){

        List<String> errors = new ArrayList<>();


        if(itemDto == null){
            errors.add("item cannot be empty");
        }
        if(!StringUtils.hasLength(itemDto.getItemName())){

            errors.add("Item most have a name");
        }
        if(!StringUtils.hasLength(itemDto.getImage())){

            errors.add("Item most have an image");
        }
        if(itemDto.getPrice() <= 0 ){

            errors.add("Item price should be greater than 0 ");
        }
        if(itemDto.getCategoryDto() == null){

            errors.add("Select a category");
        }
        if(itemDto.getUserDto().getId() == null){

            errors.add("No user");
        }

        return errors;
    }
}
