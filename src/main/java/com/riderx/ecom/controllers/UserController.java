package com.riderx.ecom.controllers;

import com.riderx.ecom.controllers.api_s.UserApi;
import com.riderx.ecom.dto.UserDto;
import com.riderx.ecom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

 private UserService userService;

 @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userService.save(userDto);
    }

    @Override
    public UserDto findById(Long id) {
        return userService.findById(id);
    }

    @Override
    public UserDto findByEmailAddress(String email) {
        return userService.findByEmailAddress(email);
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public void delete(Long id) {

     userService.delete(id);
    }
}
