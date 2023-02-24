package com.riderx.ecom.controllers.api_s;

import com.riderx.ecom.dto.CategoryDto;
import com.riderx.ecom.dto.ItemDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.riderx.ecom.utils.Constant.APP_ROOT;

@Api(APP_ROOT + "/Category")

public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Save an category", notes = "This method saves/modifies a category", response = CategoryDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "category created/modified"),
            @ApiResponse(code = 400, message = "category is not valid")
    })
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value = APP_ROOT + "/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="find an category by id", notes = "This method finds a category by it's id", response = CategoryDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "category found"),
            @ApiResponse(code = 404, message = "category is not found")
    })
    CategoryDto findByID(@PathVariable Long id);

//    @GetMapping(value = APP_ROOT + "/category/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//    CategoryDto findByName(@PathVariable String name);

    @GetMapping(value = APP_ROOT + "/category/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="find all category", notes = "This method finds all categories ", responseContainer = "List<CategoryDto>")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "category list/empty list"),
    })
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Deletes a category", notes = "This method Delete an category ", response = CategoryDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Category deleted"),
    })
    void delete(@PathVariable Long id);
}
