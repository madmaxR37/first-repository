package com.riderx.ecom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.riderx.ecom.models.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Long id;

    private String name;

    @JsonIgnore
    private List<ItemDto> itemListDto;

    private Boolean state;

    public static CategoryDto fromEntity(Category category){
        if(category == null){
            return null;
            //TODO throw exception
        }

        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .state(category.getState())
                .build();

    }

    public static Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return null;
            //TODO throw exception
        }

        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .state(categoryDto.getState())
                .build();

    }




}
