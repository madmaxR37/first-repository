package com.riderx.ecom.validators;

import com.riderx.ecom.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public  class UserValidator {

    public static List<String> validate(UserDto userDto){

        List<String> errors = new ArrayList<>();

        if(userDto == null ){

            errors.add(" 'First Name' field compulsory !");
            errors.add(" 'Last Name' field compulsory !");
            errors.add(" 'password' field compulsory !");
            errors.add(" 'email' field compulsory !");
            errors.add(" 'phone number' field compulsory !");
            errors.add(" 'address' field compulsory !");

        }

        if(!StringUtils.hasLength(userDto.getFirstName()))
        {
            errors.add(" 'First Name' field compulsory !");
        }
        if(!StringUtils.hasLength(userDto.getLastName()))
        {
            errors.add("Name field compulsory !");
        }
        if(!StringUtils.hasLength(userDto.getEmailAddress()))
        {
            errors.add("Email field compulsory !");
        }
        if(!StringUtils.hasLength(userDto.getPassword()))
        {
            errors.add("password field compulsory !");
        }
        if(!StringUtils.hasLength(userDto.getPhoneNumber()))
        {
            errors.add("phone number field compulsory !");
        }
        if(userDto.getAddress() == null)
        {
            errors.add("Fill the 'Address' ");
        }else{

            if(!StringUtils.hasLength(userDto.getAddress().getAddress1()))
            {
                errors.add("The field 'Address 1' must have a value ");
            }

            if(!StringUtils.hasLength(userDto.getAddress().getCity()))
            {
                errors.add("The field 'City' must have a value ");
            }
            if(!StringUtils.hasLength(userDto.getAddress().getCountry()))
            {
                errors.add("The field 'Country' must have a value ");
            }
            if(!StringUtils.hasLength(userDto.getAddress().getPostalCode()))
            {
                errors.add("The field 'Postal code' must have a value ");
            }
        }
        return errors;
    }
}
