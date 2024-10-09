package com.example.educationsite.services;

import com.example.educationsite.models.Quiz;
import com.example.educationsite.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Override
    public List<Quiz> findBySkillLevel(Long lessonId) {
        if (lessonId == 1L) {
            return quizRepository.findByLessonId(1L); // Return quizzes for lessonId 1
        } else if (lessonId == 2L) {
            // Combine quizzes for lessonId 1 and 2
            List<Quiz> quizzesForLesson1 = quizRepository.findByLessonId(1L);
            List<Quiz> quizzesForLesson2 = quizRepository.findByLessonId(2L);
            quizzesForLesson1.addAll(quizzesForLesson2); // Append both lists
            return quizzesForLesson1;
        } else if (lessonId == 3L) {
            // Return all quizzes
            return quizRepository.findAll();
        } else {
            // Optionally, handle cases where lessonId doesn't match expected values
            return new ArrayList<>();
        }
    }
}
