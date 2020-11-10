package com.example.demo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.course.entities.Product;
import com.example.demo.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findBydId(Long id) {
		Optional<Product> pro = productRepository.findById(id);
		return pro.get();
	}
}
