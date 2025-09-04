package com.example.ems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems.model.Role;
import com.example.ems.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmailIgnoreCase(String email);
    List<User> findByRole(Role role);
    List<User> findByManagerId(Long managerId);
    boolean existsByEmailIgnoreCase(String email);
}
