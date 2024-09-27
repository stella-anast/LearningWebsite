package com.example.educationsite.services;

import com.example.educationsite.models.QuizQuestion;
import com.example.educationsite.models.UserAnswer;
import com.example.educationsite.models.UserEntity;
import com.example.educationsite.repositories.UserAnswerRepository;
import com.example.educationsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerService {

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    public void saveUserAnswers(UserAnswer answer) {
            // Save the user's answer to the repository
            userAnswerRepository.save(answer);
    }

    // Method to find existing UserAnswer by user and question
    public UserAnswer findByUserAndQuestion(UserEntity user, QuizQuestion question) {
        return userAnswerRepository.findByUserEntityAndQuizQuestion(user, question).orElse(null);
    }

}
