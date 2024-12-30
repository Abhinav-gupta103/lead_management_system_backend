package com.lead_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lead_management_system.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}