package com.example.educationsite.services;

import com.example.educationsite.models.UserEntity;
import com.example.educationsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean registerUser(UserEntity user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return false; // User already exists
        }
        System.out.println("Saving user: " + user); // Log user details
        userRepository.save(user);
        return true; // User registered successfully
    }


    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

