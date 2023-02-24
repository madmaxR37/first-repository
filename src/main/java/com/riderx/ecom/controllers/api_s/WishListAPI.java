package com.riderx.ecom.controllers.api_s;

import com.riderx.ecom.dto.ItemDto;
import com.riderx.ecom.dto.WishListDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.riderx.ecom.utils.Constant.APP_ROOT;

@Api(APP_ROOT + "/WhishList")
public interface WishListAPI {

    @PostMapping(value = APP_ROOT + "/wishList/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   @ApiOperation(value = "save wish list", notes = "This method saves/modifies wish lists", response = WishListDto.class)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Item created/modified"),
                    @ApiResponse(code = 400, message = "Item is not valid")
            })
    WishListDto save(@RequestBody WishListDto wishListDto);

    @GetMapping(value = APP_ROOT + "/wishList/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "find wish list by id", notes = "this method find wish list by id", response = WishListDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "wish list found"),
            @ApiResponse(code = 404, message = "wish list is not found")
    })
    WishListDto findByID(@PathVariable Long id);

    @GetMapping(value = APP_ROOT + "/wishList/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<WishListDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/wishList/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Deletes an wish List", notes = "This method Delete an wish list ", response = WishListDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "wish list deleted"),
    })
    void delete(@PathVariable Long id);
}
