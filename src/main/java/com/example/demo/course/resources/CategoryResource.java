package com.example.demo.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.course.entities.Category;
import com.example.demo.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<Category>> findByAll() {
		List<Category> cat = service.findByAll();
		return ResponseEntity.ok().body(cat);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> finById(@PathVariable Long id) {
		Category cat = service.findById(id);
		return ResponseEntity.ok().body(cat);
	}
}
