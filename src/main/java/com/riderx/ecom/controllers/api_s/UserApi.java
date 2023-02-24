package com.riderx.ecom.controllers.api_s;


import com.riderx.ecom.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.riderx.ecom.utils.Constant.APP_ROOT;

@Api(APP_ROOT + "/Users")
public interface UserApi {

    @PostMapping(value = APP_ROOT + "/user/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Save a user", notes = "This method saves/modifies a user", response = UserDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "user created/modified"),
            @ApiResponse(code = 400, message = "user is not valid")
    })
    UserDto save(@RequestBody UserDto userDto);

    @GetMapping(value = APP_ROOT + "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="find a user by id", notes = "This method finds a user by it's id", response = UserDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "user found"),
            @ApiResponse(code = 404, message = "user is not found")
    })
    UserDto findById(@PathVariable Long id);

    @GetMapping(value = APP_ROOT + "/user/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="find a user by email", notes = "This method finds a user by it's email", response = UserDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "user found"),
            @ApiResponse(code = 404, message = "user is not found")
    })
    UserDto findByEmailAddress(@RequestParam(value = "email") String email);

    @GetMapping(value = APP_ROOT + "/user/All", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="find all users", notes = "This method finds all users ", responseContainer = "List<UserDto>")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "users list/empty list"),
    })
    List<UserDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/user/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Deletes a user", notes = "This method Delete a user ", response = UserDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "User deleted"),
    })
    void delete(@PathVariable Long id);
}
