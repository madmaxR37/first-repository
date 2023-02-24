package com.riderx.ecom.controllers;

import com.riderx.ecom.controllers.api_s.ItemApi;
import com.riderx.ecom.dto.ItemDto;
import com.riderx.ecom.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemContoller implements ItemApi {

    private ItemService itemService;

    @Autowired
    public ItemContoller( ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public ItemDto save(ItemDto itemDto) {
        return itemService.save(itemDto);
    }

    @Override
    public ItemDto findByID(Long id) {
        return itemService.findByID(id);
    }

    @Override
    public List<ItemDto> findByItemNameStartingWith(String name) {
        return itemService.findByItemNameStartingWith(name);
    }

    @Override
    public List<ItemDto> findAll() {
        return itemService.findAll();
    }

    @Override
    public void delete(Long id) {
        itemService.delete(id);

    }
}
