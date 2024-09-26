package com.example.educationsite.services;

import com.example.educationsite.models.QuestionType;
import com.example.educationsite.models.Quiz;
import com.example.educationsite.models.QuizQuestion;
import com.example.educationsite.models.QuestionOptions;
import com.example.educationsite.repositories.QuizQuestionRepository;
import com.example.educationsite.repositories.QuestionOptionsRepository;
import com.example.educationsite.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class QuizQuestionService {

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private QuestionOptionsRepository questionOptionsRepository;
    @Autowired
    private QuizRepository quizRepository;

    @Transactional
    public void addQuizQuestions(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        QuizQuestion question1 = new QuizQuestion();
        question1.setQuestion("What is the capital of France?");
        question1.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question1.setCorrectAnswer("Paris");
        question1.setQuiz(quiz);
        quizQuestionRepository.save(question1);

        QuestionOptions option1 = new QuestionOptions();
        option1.setOptionText("Paris");
        option1.setCorrect(true);
        option1.setQuizQuestion(question1);
        questionOptionsRepository.save(option1);

        QuestionOptions option2 = new QuestionOptions();
        option2.setOptionText("London");
        option2.setCorrect(false);
        option2.setQuizQuestion(question1);
        questionOptionsRepository.save(option2);
    }

}
