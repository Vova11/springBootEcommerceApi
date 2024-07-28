package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    Order findByOrderTrackingNumber(String orderTrackingNumber);
}
