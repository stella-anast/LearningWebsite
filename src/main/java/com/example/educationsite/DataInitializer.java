package com.example.educationsite;

import com.example.educationsite.services.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private QuizQuestionService quizQuestionService;

    @Override
    public void run(String... args) throws Exception {
        Long quizId = 1L; 
        //quizQuestionService.addQuizQuestions(quizId);

        //System.out.println("Quiz questions added successfully for Quiz ID: " + quizId);
    }
}
