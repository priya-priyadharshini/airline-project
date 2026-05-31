package com.airline.airline_new.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.airline_new.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}