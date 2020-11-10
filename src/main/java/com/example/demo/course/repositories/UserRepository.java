package com.example.demo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
