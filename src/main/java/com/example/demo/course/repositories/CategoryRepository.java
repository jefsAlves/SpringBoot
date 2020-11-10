package com.example.demo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
