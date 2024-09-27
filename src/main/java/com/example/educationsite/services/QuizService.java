package com.example.educationsite.services;

import com.example.educationsite.models.Quiz;
import java.util.List;

public interface QuizService {
    List<Quiz> findAll();
    Quiz findById(Long id);
}
