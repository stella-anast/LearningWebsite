package com.example.educationsite.services;

import com.example.educationsite.dto.QuizSubmissionDTO;
import com.example.educationsite.models.QuizQuestion;
import com.example.educationsite.models.UserAnswer;
import com.example.educationsite.models.UserEntity;
import com.example.educationsite.repositories.UserAnswerRepository;
import com.example.educationsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAnswerService {

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    public void saveUserAnswers(UserEntity user, List<QuizSubmissionDTO.AnswerDTO> answers, QuizQuestion question) {
            Long questionId = question.getId();
            String correctAnswer = question.getCorrectAnswer();

            // Find the corresponding answer from the answers list
            QuizSubmissionDTO.AnswerDTO submittedAnswer = answers.stream()
                    .filter(answer -> answer.getQuestionId()==(questionId))
                    .findFirst()
                    .orElse(null);

            UserAnswer userAnswer = this.findByUserAndQuestion(user, question);
            if(userAnswer==null){ // first time answering
                userAnswer = new UserAnswer();
            }
            userAnswer.setUserEntity(user);
            userAnswer.setQuiz(question.getQuiz());
            userAnswer.setQuizQuestion(question);

            if (submittedAnswer != null) {
                String providedAnswer = submittedAnswer.getAnswer();
                boolean isCorrect = correctAnswer.equals(providedAnswer);
                userAnswer.setCorrect(isCorrect);
                // Print true if the answer is correct, false otherwise
                System.out.println("Question ID: " + questionId);
                System.out.println("Answer: " + providedAnswer);
                System.out.println("Correct: " + isCorrect);
            } else {
                // If no answer was provided for this question, set isCorrect to false
                userAnswer.setCorrect(false);
                System.out.println("No answer provided for question ID: " + questionId);
            }
            // Save the user's answer to the repository
            userAnswerRepository.save(userAnswer);
    }

    // Method to find existing UserAnswer by user and question
    public UserAnswer findByUserAndQuestion(UserEntity user, QuizQuestion question) {
        return userAnswerRepository.findByUserEntityAndQuizQuestion(user, question).orElse(null);
    }

    public List<Long> getIncorrectQuestionIds(UserEntity user) {
        // Query repository to get all UserAnswer where isCorrect is false for the given user
        return userAnswerRepository.findByUserEntityAndIsCorrectFalse(user)
                .stream()
                .map(userAnswer -> userAnswer.getQuizQuestion().getId())  // Extract the ID from each UserAnswer
                .collect(Collectors.toList());
    }

    public List<Long> getIncorrectQuestionIds(UserEntity user, Long quizId) {
        // Query repository to get all UserAnswer where isCorrect is false for the given user and quiz
        return userAnswerRepository.findWrongAnswersByUserAndQuiz(user, quizId)
                .stream()
                .map(userAnswer -> userAnswer.getQuizQuestion().getId())  // Extract the ID from each UserAnswer
                .collect(Collectors.toList());
    }

}
