package com.example.educationsite.controllers;
import com.example.educationsite.models.UserEntity;
import com.example.educationsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
public class ViewController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<String> signUp(@RequestBody UserEntity user) {
        if (userService.registerUser(user)) {
            return ResponseEntity.ok("User registered successfully.");
        } else {
            return ResponseEntity.badRequest().body("User registration failed.");
        }
    }
    @GetMapping("/{username}")
    public ResponseEntity<UserEntity> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
