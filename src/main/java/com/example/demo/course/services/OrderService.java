package com.example.demo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.course.entities.Order;
import com.example.demo.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findByAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> or = orderRepository.findById(id);
		return or.get();
	}

}
