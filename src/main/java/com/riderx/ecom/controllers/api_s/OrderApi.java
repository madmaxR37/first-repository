package com.riderx.ecom.controllers.api_s;

import com.riderx.ecom.dto.OrderDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static com.riderx.ecom.utils.Constant.APP_ROOT;

@Api(APP_ROOT + "/Orders")
public interface OrderApi {

    @PostMapping(value = APP_ROOT + "/order/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Save a order", notes = "This method saves/modifies a order", response = OrderDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "order created/modified"),
            @ApiResponse(code = 400, message = "order is not valid")
    })
    OrderDto save(OrderDto orderDto);

    @GetMapping(value = APP_ROOT + "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="find a order by id", notes = "This method finds a order by it's id", response = OrderDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "order found"),
            @ApiResponse(code = 404, message = "order is not found")
    })
    OrderDto findById(Long id);

    @DeleteMapping(value = APP_ROOT + "/order/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Deletes an order", notes = "This method Delete a order ", response = OrderDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "order deleted"),
    })
    void delete(Long id);
}
