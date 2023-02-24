package com.riderx.ecom.services;

import com.riderx.ecom.dto.OrderDto;

public interface OrderService {

    OrderDto save(OrderDto orderDto);

    OrderDto findById(Long id);

    void delete(Long id);
}
