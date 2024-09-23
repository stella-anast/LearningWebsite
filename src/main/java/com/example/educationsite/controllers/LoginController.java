package com.example.educationsite.controllers;

import com.example.educationsite.models.UserEntity;
import com.example.educationsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UserService userService;

        @GetMapping("/login")
        public String showLoginPage(@RequestParam(required = false) String error, Model model) {
            if (error != null) {
                model.addAttribute("errorMessage", "Invalid username or password.");
            }
            model.addAttribute("user", new UserEntity());
            return "login";
        }

    @GetMapping("/success")
    public String successPage() {
        return "success";
    }
    /*
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<UserEntity> loginUser = userService.validateUser(username, password);

        if (loginUser.isPresent()) {
            // Successful login
            System.out.println("Login successful for user: " + username);
            model.addAttribute("successMessage", "Login successful!");
            //return "redirect:/home"; // Redirect to home page
            return "login";
        } else {
            System.out.println("Invalid login attempt for user: " + username);
            model.addAttribute("errorMessage", "Invalid username or password.");
            return "login"; // Show error message if credentials are wrong
        }
    }

     */

}
