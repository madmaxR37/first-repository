package com.riderx.ecom.services;

import com.riderx.ecom.dto.WishListDto;

import java.util.List;

public interface WishListService {

    WishListDto save(WishListDto wishListDto);

    WishListDto findByID(Long id);

    List<WishListDto> findAll();

    void delete(Long id);
}
