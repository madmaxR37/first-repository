package com.riderx.ecom.Repositories;

import com.riderx.ecom.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
