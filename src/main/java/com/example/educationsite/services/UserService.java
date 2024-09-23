package com.example.educationsite.services;
import com.example.educationsite.models.UserEntity;
import com.example.educationsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
