package com.example.demo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
