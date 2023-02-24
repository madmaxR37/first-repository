package com.riderx.ecom.validators;

import com.riderx.ecom.dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {

    public static List<String> validate(RolesDto rolesDto){

         List<String> errors = new ArrayList<>();

         if(rolesDto == null){

             errors.add("Role name compulsory ");

             errors.add("No user affected to role");
         }

         if(!StringUtils.hasLength(rolesDto.getName())){
             errors.add("Role name compulsory");
         }
         if(rolesDto.getUsers().isEmpty()){
             errors.add("No user affected to role");
         }
         return errors;
    }
}
