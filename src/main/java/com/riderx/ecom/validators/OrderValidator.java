package com.riderx.ecom.validators;

import com.riderx.ecom.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

public class OrderValidator {

    public static List<String> validate(OrderDto orderDto){

        List<String> errors = new ArrayList<>();

        if( orderDto == null){
            errors.add("No amount");

            errors.add("No quantity");
        }

        if(orderDto.getItemDto()==null){
            errors.add("No item");
        }
        if(orderDto.getUserDto()==null){
            errors.add("No user");
        }
        return errors;
    }



}
