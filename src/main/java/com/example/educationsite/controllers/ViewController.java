package com.example.educationsite.controllers;

import com.example.educationsite.SkillLevel;
import com.example.educationsite.models.UserEntity;
import com.example.educationsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class ViewController {
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "signup";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute UserEntity user, Model model) {
        if (!userService.registerUser(user)) {
            model.addAttribute("errorMessage", "User with this email or username already exists.");
            model.addAttribute("user", user);
            return "signup";
        } else {

            model.addAttribute("successMessage", "User registered successfully!");
            return "redirect:/api/login"; // Redirect to login or wherever you want
        }

    }
}
