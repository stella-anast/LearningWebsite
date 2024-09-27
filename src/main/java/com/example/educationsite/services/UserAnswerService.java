package com.example.educationsite.services;

import com.example.educationsite.repositories.QuizRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerService {
    /*

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    public void saveUserAnswers(Long quizId, List<QuizController.QuizSubmission.Answer> answers) {
        // Assuming you have a method to fetch the current user
        UserEntity currentUser = // fetch the current user

        for (QuizController.QuizSubmission.Answer answer : answers) {
            UserAnswer userAnswer = new UserAnswer();
            userAnswer.setUserEntity(currentUser);
            userAnswer.setQuiz(quizRepository.findById(quizId).orElse(null));

            // Fetch the question using the ID provided in the answer
            QuizQuestion question = quizQuestionRepository.findById(Long.parseLong(answer.getQuestionId())).orElse(null);
            userAnswer.setQuizQuestion(question);

            // Check if the provided answer matches the correct answer
            boolean isCorrect = question != null && question.getCorrectAnswer().equals(answer.getAnswer());
            userAnswer.setCorrect(isCorrect);

            // Save the user's answer to the repository
            userAnswerRepository.save(userAnswer);
        }
    }
     */
}
