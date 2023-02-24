package com.riderx.ecom.controllers.api_s;

import com.riderx.ecom.dto.ItemDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.riderx.ecom.utils.Constant.APP_ROOT;

@Api(APP_ROOT + "/Items")
public interface ItemApi {

    @PostMapping(value = APP_ROOT + "/item/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Save an item", notes = "This method saves/modifies an item", response = ItemDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Item created/modified"),
            @ApiResponse(code = 400, message = "Item is not valid")
    })
    ItemDto save(@RequestBody ItemDto itemDto);


    @GetMapping(value = APP_ROOT + "/item/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="find an item by id", notes = "This method finds an item by it's id", response = ItemDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Item found"),
            @ApiResponse(code = 404, message = "Item is not found")
    })
    ItemDto findByID(@PathVariable Long id);

    @GetMapping(value = APP_ROOT + "/item/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="find  items by name", notes = "This method finds items ", responseContainer = "List<ItemDto>")
    List<ItemDto> findByItemNameStartingWith(@RequestParam(value = "name") String name);

    @GetMapping(value = APP_ROOT + "/item/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="find all items", notes = "This method finds all items ", responseContainer = "List<ItemDto>")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Items list/empty list"),
    })
    List<ItemDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Deletes an items", notes = "This method Delete an item ", response = ItemDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Items deleted"),
    })
    void delete(@PathVariable Long id);
}
