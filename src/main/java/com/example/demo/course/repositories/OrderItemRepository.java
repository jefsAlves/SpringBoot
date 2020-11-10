package com.example.demo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
