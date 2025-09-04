package com.example.ems.service;

import org.springframework.stereotype.Service;

import com.example.ems.model.Role;
import com.example.ems.model.User;
import com.example.ems.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service @Transactional
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo){
        this.repo=repo;
    }

    //logic for creating user in the database
    public User creatUser(User u){
        if(repo.existsByEmailIgnoreCase(u.getEmail())){
            throw new IllegalArgumentException("Email already in use");
        }
        if(u.getRole()==null) u.setRole(Role.EMPLOYEE);
        return repo.save(u);
    }
}
