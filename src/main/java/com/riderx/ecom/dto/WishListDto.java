package com.riderx.ecom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.riderx.ecom.models.WishList;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class WishListDto {

    private Long id;
    @JsonIgnore
    private List<ItemDto> itemListDto;

    public static WishListDto fromEntity(WishList wishList){
        if(wishList == null){
            return null;
            //TODO throw exception
        }
        return WishListDto.builder()
                .id(wishList.getId())
                .build();

    }
    public static WishList toEntity(WishListDto wishListDto){
        if(wishListDto == null){
            return null;
            //TODO throw exception
        }
        return WishList.builder()
                .id(wishListDto.getId())
                .build();

    }
}
