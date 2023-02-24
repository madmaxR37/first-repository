package com.riderx.ecom.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.riderx.ecom.models.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Address address;

    private String emailAddress;

    private String phoneNumber;

    private Boolean state;

    private String password;

    private String kyc;

    private String profile;

    @JsonIgnore
    private List<Order> orders;

    @JsonIgnore
    private List<Item> items;

    @JsonIgnore
    private List<Roles> roles;

    public static UserDto fromEntity(User user){
        if(user == null){
            return null;
            //TODO throw exception
        }

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .state(user.getState())
                .address(user.getAddress())
                .emailAddress(user.getEmailAddress())
                .phoneNumber(user.getPhoneNumber())
                .password(user.getPassword())
                .kyc(user.getKyc())
                .profile(user.getProfile())
                .build();
    }

    public static User toEntity(UserDto userDto){
        if(userDto == null){
            return null;
            //TODO throw exception
        }

        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .address(userDto.getAddress())
                .state(userDto.getState())
                .emailAddress(userDto.getEmailAddress())
                .phoneNumber(userDto.getPhoneNumber())
                .password(userDto.getPassword())
                .kyc(userDto.getKyc())
                .profile(userDto.getProfile())
                .build();
    }


}
