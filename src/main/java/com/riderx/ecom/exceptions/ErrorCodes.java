package com.riderx.ecom.exceptions;

public enum ErrorCodes {

    ITEM_NOT_FOUND(1000),
    ITEM_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),
    USER_NOT_FOUND(3000),
    USER_NOT_VALID(3001),
    CART_NOT_FOUND(4000),
    CART_NOT_VALID(4001),
    ROLE_NOT_VALID(5001),
    Wishlist_NOT_FOUND(6000),
    ORDER_NOT_VALID(7000),
    ORDER_NOT_FOUND(7001),
    UPDATE_IMAGE_EXCEPTION(8000),
    UNKNOWN_CONTEXT(8001),
    ;


    private int codes;

    ErrorCodes(int codes){
        this.codes = codes;
    }

    public int getCodes(){

        return codes;
    }

}
