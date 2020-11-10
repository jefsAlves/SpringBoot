package com.example.demo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.course.entities.Category;
import com.example.demo.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findByAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> cat = categoryRepository.findById(id);
		return cat.get();
	}
}
