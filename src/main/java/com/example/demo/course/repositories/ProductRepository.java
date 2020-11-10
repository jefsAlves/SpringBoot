package com.example.demo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
