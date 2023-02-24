package com.riderx.ecom.controllers;

import com.riderx.ecom.controllers.api_s.WishListAPI;
import com.riderx.ecom.dto.WishListDto;
import com.riderx.ecom.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishListController implements WishListAPI {

    private WishListService wishListService;

    @Autowired
    public WishListController(WishListService wishListService){this.wishListService = wishListService;}

    @Override
    public WishListDto save(WishListDto wishListDto) {
        return wishListService.save(wishListDto);
    }

    @Override
    public WishListDto findByID(Long id) {
        return wishListService.findByID(id);
    }

    @Override
    public List<WishListDto> findAll() {
        return wishListService.findAll();
    }

    @Override
    public void delete(Long id) {

        wishListService.delete(id);
    }
}
