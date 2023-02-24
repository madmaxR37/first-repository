package com.riderx.ecom.services.implementation;

import com.riderx.ecom.Repositories.OrderRepo;
import com.riderx.ecom.Repositories.UserRepo;
import com.riderx.ecom.dto.OrderDto;
import com.riderx.ecom.exceptions.EntityNotFoundException;
import com.riderx.ecom.exceptions.ErrorCodes;
import com.riderx.ecom.exceptions.InvalideEntityException;
import com.riderx.ecom.models.Order;
import com.riderx.ecom.models.User;
import com.riderx.ecom.services.OrderService;
import com.riderx.ecom.validators.OrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;
    private UserRepo userRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, UserRepo userRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        List<String> errors = OrderValidator.validate(orderDto);
        if(!errors.isEmpty()){
            log.error("order is not valid {} ", orderDto);
            throw new InvalideEntityException("The item is not valid ", ErrorCodes.ORDER_NOT_VALID);
        }

        Optional<User> user = userRepo.findById(orderDto.getUserDto().getId());
        if(!user.isPresent()){
            log.warn("user with id {} was not found in the DB", orderDto.getUserDto().getId() );
            throw new EntityNotFoundException("No user with id " +orderDto.getUserDto().getId(), ErrorCodes.USER_NOT_FOUND);
        }
        return orderDto.fromEntity(orderRepo.save(orderDto.toEntity(orderDto)));
    }

    @Override
    public OrderDto findById(Long id) {

        if(id == null){
            log.error("id is null");
            return null;
        }

        Optional<Order> order = orderRepo.findById(id);
        OrderDto orderDto = OrderDto.fromEntity(order.get());
        return Optional.of(orderDto).orElseThrow(()->
                new EntityNotFoundException("No user with id " +id, ErrorCodes.ORDER_NOT_FOUND)
        );
    }



    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("Null id");
        }

        orderRepo.deleteById(id);

    }
}
