package com.riderx.ecom.controllers;

import com.riderx.ecom.controllers.api_s.OrderApi;
import com.riderx.ecom.dto.OrderDto;
import com.riderx.ecom.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
