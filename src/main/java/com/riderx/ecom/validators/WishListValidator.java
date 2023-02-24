package com.riderx.ecom.validators;

import com.riderx.ecom.dto.WishListDto;


import java.util.ArrayList;
import java.util.List;

public class WishListValidator {

    public static List<String> validate(WishListDto wishListDto) {

        List<String> errors = new ArrayList<>();

        if (wishListDto == null) {
            errors.add("No item in wishList ");
        }
        return errors;

    }
}
