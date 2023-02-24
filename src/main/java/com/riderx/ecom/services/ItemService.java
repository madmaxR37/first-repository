package com.riderx.ecom.services;

import com.riderx.ecom.dto.ItemDto;

import java.util.List;

public interface ItemService {

    ItemDto save(ItemDto itemDto);

    ItemDto findByID(Long id);

    List<ItemDto> findByItemNameStartingWith(String name);

    List<ItemDto> findAll();

    void delete(Long id);
}
