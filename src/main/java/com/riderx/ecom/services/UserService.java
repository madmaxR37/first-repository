package com.riderx.ecom.services;

import com.riderx.ecom.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto findById(Long id);

   UserDto findByEmailAddress(String email);

    List<UserDto> findAll();

    void delete(Long id);
}
