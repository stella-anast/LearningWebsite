package com.example.educationsite.services;
import com.example.educationsite.models.UserEntity;
import com.example.educationsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(UserEntity user) {
        // Check user exists-email and username
        if (userRepository.existsByEmail(user.getEmail()) || userRepository.existsByUsername(user.getUsername())) {
            return false;
        }

        //save user
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Ensure password is encoded
        userRepository.save(user);
        return true;
    }
    public Optional<UserEntity> validateUser(String username, String password) {
        Optional<UserEntity> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }
    public Long findUserIdByUsername(String username) {
        Optional<UserEntity> userOpt = userRepository.findByUsername(username);
        return userOpt.map(UserEntity::getId).orElse(null); // Return user ID or null if not found
    }
    public UserEntity findByUsername(String username) {
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
        return userOptional.orElse(null);
    }

    public boolean updateUserSkill(UserEntity user){
        try {
            // Save the updated user entity with the new skill level
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            // Handle any potential exceptions
            System.out.println("Error updating user skill: " + e.toString());
            return false;
        }
    }

}
