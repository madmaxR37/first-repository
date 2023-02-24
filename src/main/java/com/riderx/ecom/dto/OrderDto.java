package com.riderx.ecom.dto;


import com.riderx.ecom.models.Item;
import com.riderx.ecom.models.Order;
import com.riderx.ecom.models.User;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class OrderDto {
    private Long OrderId;

    private Instant orderDate;

    private ItemDto itemDto;

    private UserDto userDto;

    public static OrderDto fromEntity(Order order){

        if(order == null){
            return null;
            //TODO throw exception
        }

        return OrderDto.builder()
                .OrderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .itemDto(ItemDto.fromEntity(order.getItem()))
                .userDto(UserDto.fromEntity(order.getUser()))
                .build();
    }
    public static Order toEntity(OrderDto orderDto){

        if(orderDto == null){
            return null;
            //TODO throw exception
        }

        return Order.builder()
                .OrderId(orderDto.getOrderId())
                .orderDate(orderDto.getOrderDate())
                .item(ItemDto.toEntity(orderDto.getItemDto()))
                .user(UserDto.toEntity(orderDto.getUserDto()))
                .build();
    }



}
