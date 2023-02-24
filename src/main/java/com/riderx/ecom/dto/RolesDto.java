package com.riderx.ecom.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.riderx.ecom.models.Roles;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class RolesDto {

    private Long id;

    private String name;

    @JsonIgnore
    private List<UserDto> users;

    public static RolesDto fromEntity(Roles roles){

        if(roles == null){
            return null;
            //TODO throw exception
        }
        return RolesDto.builder()
                .id(roles.getId())
                .name(roles.getName())
                .build();
    }


    public static Roles toEntity(RolesDto rolesDto){

        if(rolesDto == null){
            return null;
            //TODO throw exception
        }
        return Roles.builder()
                .id(rolesDto.getId())
                .name(rolesDto.getName())
                .build();
    }
}
