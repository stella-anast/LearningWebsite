package com.example.educationsite.services;

import com.example.educationsite.models.Quiz;
import java.util.List;

public interface QuizService {
    List<Quiz> findAll();
    List<Quiz> findBySkillLevel(Long lessonId);
    Quiz findById(Long id);
}
