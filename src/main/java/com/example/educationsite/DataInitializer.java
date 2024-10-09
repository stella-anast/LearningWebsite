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
        quizQuestionService.addQuizQuestions1(quizId);
        quizId = 2L;
        quizQuestionService.addQuizQuestions2(quizId);
        quizId = 3L;
        quizQuestionService.addQuizQuestions3(quizId);
        quizId = 4L;
        quizQuestionService.addQuizQuestions4(quizId);
        quizId = 5L;
        quizQuestionService.addQuizQuestions5(quizId);
        quizId = 6L;
        quizQuestionService.addQuizQuestions6(quizId);
    }
}
