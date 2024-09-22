package com.example.educationsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
public class SignUpController {
        @GetMapping("/signup")
        public String showSignupPage() {
            return "signup"; // This maps to src/main/resources/templates/signup.html

    }
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // This maps to src/main/resources/templates/signup.html

    }
}
