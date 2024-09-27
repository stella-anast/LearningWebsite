package com.example.educationsite.services;

import com.example.educationsite.models.Quiz;
import com.example.educationsite.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository; // Autowire the QuizRepository

    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll(); // Fetch all quizzes from the database
    }

    @Override
    public Quiz findById(Long id) {
        return quizRepository.findById(id).orElse(null); // Fetch a quiz by its ID
    }
}
