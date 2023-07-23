package com.example.orderservice.repository;

import com.example.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author daecheol song
 * @since 2023-07-23
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
