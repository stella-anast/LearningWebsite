package com.example.educationsite.services;
import com.example.educationsite.models.UserEntity;
import com.example.educationsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(UserEntity user) {
        // Check if the email or username already exists before saving
        if (userRepository.existsByEmail(user.getEmail()) || userRepository.existsByUsername(user.getUsername())) {
            return false; // User already exists
        }

        // If no conflict, save the new user
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Ensure password is encoded
        userRepository.save(user);
        return true;
    }
}
