package com.riderx.ecom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.riderx.ecom.models.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ItemDto {

    private Long  itemId;

    private String itemName;

    private String image;

    private Double price;

    private String description;

    private Boolean state;


    private CategoryDto categoryDto;

    @JsonIgnore
    private WishListDto wishListDto;

    @JsonIgnore
    private OrderDto orderDto;

    private UserDto userDto;

    public static ItemDto fromEntity(Item item){
        if(item == null){
            return null;
            //TODO throw exception
        }
        return ItemDto.builder()
                .itemId(item.getItemId())
                .itemName(item.getItemName())
                .image(item.getImage())
                .price(item.getPrice())
                .state(item.getState())
                .description(item.getDescription())
                .categoryDto(CategoryDto.fromEntity(item.getCategory()))
                .wishListDto(WishListDto.fromEntity(item.getWishList()))
                .orderDto(OrderDto.fromEntity(item.getOrder()))
                .userDto(UserDto.fromEntity(item.getUser()))
                .build();
    }
    public static Item toEntity(ItemDto itemDto){
        if(itemDto == null){
            return null;
            //TODO throw exception
        }
        return Item.builder()
                .itemId(itemDto.getItemId())
                .itemName(itemDto.getItemName())
                .image(itemDto.getImage())
                .price(itemDto.getPrice())
                .state(itemDto.getState())
                .description(itemDto.getDescription())
                .category(CategoryDto.toEntity(itemDto.getCategoryDto()))
                .wishList(WishListDto.toEntity(itemDto.getWishListDto()))
                .order(OrderDto.toEntity(itemDto.getOrderDto()))
                .user(UserDto.toEntity(itemDto.getUserDto()))
                .build();
    }

}
