package com.example.educationsite.services;

import com.example.educationsite.models.*;
import com.example.educationsite.repositories.QuestionOptionsRepository;
import com.example.educationsite.repositories.QuizQuestionRepository;
import com.example.educationsite.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuizQuestionService {

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private QuestionOptionsRepository questionOptionsRepository;
    @Autowired
    private QuizRepository quizRepository;

    @Transactional
    public List<QuizQuestion> findByQuizId(Long id) {
        List<QuizQuestion> quizQuestions = quizQuestionRepository.findAllByQuizId(id);
        return quizQuestions;
    }

    @Transactional
    public void addQuizQuestions(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Question 1 - Who created Python?
        QuizQuestion question1 = new QuizQuestion();
        question1.setQuestion("Who created Python and when was it first released?");
        question1.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question1.setCorrectAnswer("Guido van Rossum, 1991");
        question1.setQuiz(quiz);
        quizQuestionRepository.save(question1);

        QuestionOptions option1Q1 = new QuestionOptions();
        option1Q1.setOptionText("Guido van Rossum, 1991");
        option1Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option1Q1);

        QuestionOptions option2Q1 = new QuestionOptions();
        option2Q1.setOptionText("James Gosling, 1995");
        option2Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option2Q1);

        QuestionOptions option3Q1 = new QuestionOptions();
        option3Q1.setOptionText("Brendan Eich, 1997");
        option3Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option3Q1);

        QuestionOptions option4Q1 = new QuestionOptions();
        option4Q1.setOptionText("Dennis Ritchie, 1972");
        option4Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option4Q1);

        // Question 2 - Python has three numeric types
        QuizQuestion question2 = new QuizQuestion();
        question2.setQuestion("Python has three numeric types: int, float, and decimal.");
        question2.setQuestionType(QuestionType.TRUE_FALSE);
        question2.setCorrectAnswer("False");
        question2.setQuiz(quiz);
        quizQuestionRepository.save(question2);

        QuestionOptions option1Q2 = new QuestionOptions();
        option1Q2.setOptionText("True");
        option1Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option1Q2);

        QuestionOptions option2Q2 = new QuestionOptions();
        option2Q2.setOptionText("False");
        option2Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option2Q2);

        // Question 3 - print(a[1]) prints second character
        QuizQuestion question3 = new QuizQuestion();
        question3.setQuestion("In Python, print(a[1]) will print the second character of the string 'a'.");
        question3.setQuestionType(QuestionType.TRUE_FALSE);
        question3.setCorrectAnswer("True");
        question3.setQuiz(quiz);
        quizQuestionRepository.save(question3);

        QuestionOptions option1Q3 = new QuestionOptions();
        option1Q3.setOptionText("True");
        option1Q3.setQuizQuestion(question3);
        questionOptionsRepository.save(option1Q3);

        QuestionOptions option2Q3 = new QuestionOptions();
        option2Q3.setOptionText("False");
        option2Q3.setQuizQuestion(question3);
        questionOptionsRepository.save(option2Q3);

        // Question 4 - A tuple is mutable
        QuizQuestion question4 = new QuizQuestion();
        question4.setQuestion("A Python tuple is mutable, meaning it can be changed after creation.");
        question4.setQuestionType(QuestionType.TRUE_FALSE);
        question4.setCorrectAnswer("False");
        question4.setQuiz(quiz);
        quizQuestionRepository.save(question4);

        QuestionOptions option1Q4 = new QuestionOptions();
        option1Q4.setOptionText("True");
        option1Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option1Q4);

        QuestionOptions option2Q4 = new QuestionOptions();
        option2Q4.setOptionText("False");
        option2Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option2Q4);

        // Question 5 - range(10, 0, -2) generates even numbers
        QuizQuestion question5 = new QuizQuestion();
        question5.setQuestion("The range(10, 0, -2) function generates even numbers from 10 to 0 in reverse order.");
        question5.setQuestionType(QuestionType.TRUE_FALSE);
        question5.setCorrectAnswer("True");
        question5.setQuiz(quiz);
        quizQuestionRepository.save(question5);

        QuestionOptions option1Q5 = new QuestionOptions();
        option1Q5.setOptionText("True");
        option1Q5.setQuizQuestion(question5);
        questionOptionsRepository.save(option1Q5);

        QuestionOptions option2Q5 = new QuestionOptions();
        option2Q5.setOptionText("False");
        option2Q5.setQuizQuestion(question5);
        questionOptionsRepository.save(option2Q5);

        // Question 6 - Python supports multiple programming paradigms
        QuizQuestion question6 = new QuizQuestion();
        question6.setQuestion("Python supports multiple programming paradigms including procedural, object-oriented, and functional.");
        question6.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question6.setCorrectAnswer("All of the above");
        question6.setQuiz(quiz);
        quizQuestionRepository.save(question6);

        QuestionOptions option1Q6 = new QuestionOptions();
        option1Q6.setOptionText("Procedural");
        option1Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option1Q6);

        QuestionOptions option2Q6 = new QuestionOptions();
        option2Q6.setOptionText("Object-oriented");
        option2Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option2Q6);

        QuestionOptions option3Q6 = new QuestionOptions();
        option3Q6.setOptionText("Functional");
        option3Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option3Q6);

        QuestionOptions option4Q6 = new QuestionOptions();
        option4Q6.setOptionText("All of the above");
        option4Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option4Q6);

        // Question 7 - Variables are automatically declared when assigned
        QuizQuestion question7 = new QuizQuestion();
        question7.setQuestion("In Python, variables are automatically declared when a value is assigned.");
        question7.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question7.setCorrectAnswer("True");
        question7.setQuiz(quiz);
        quizQuestionRepository.save(question7);

        QuestionOptions option1Q7 = new QuestionOptions();
        option1Q7.setOptionText("True");
        option1Q7.setQuizQuestion(question7);
        questionOptionsRepository.save(option1Q7);

        QuestionOptions option2Q7 = new QuestionOptions();
        option2Q7.setOptionText("False");
        option2Q7.setQuizQuestion(question7);
        questionOptionsRepository.save(option2Q7);

        // Question 8 - Indentation defines code blocks
        QuizQuestion question8 = new QuizQuestion();
        question8.setQuestion("Which symbol does Python use to define code blocks like loops and functions?");
        question8.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question8.setCorrectAnswer("Indentation");
        question8.setQuiz(quiz);
        quizQuestionRepository.save(question8);

        QuestionOptions option1Q8 = new QuestionOptions();
        option1Q8.setOptionText("Curly braces {}");
        option1Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option1Q8);

        QuestionOptions option2Q8 = new QuestionOptions();
        option2Q8.setOptionText("Square brackets []");
        option2Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option2Q8);

        QuestionOptions option3Q8 = new QuestionOptions();
        option3Q8.setOptionText("Indentation");
        option3Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option3Q8);

        QuestionOptions option4Q8 = new QuestionOptions();
        option4Q8.setOptionText("Parentheses ()");
        option4Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option4Q8);

        // Question 9 - append() adds an element to the end of a list
        QuizQuestion question9 = new QuizQuestion();
        question9.setQuestion("What does the append() method do in Python?");
        question9.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question9.setCorrectAnswer("Add an element to the end of a list");
        question9.setQuiz(quiz);
        quizQuestionRepository.save(question9);

        QuestionOptions option1Q9 = new QuestionOptions();
        option1Q9.setOptionText("Add an element to the end of a list");
        option1Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option1Q9);

        QuestionOptions option2Q9 = new QuestionOptions();
        option2Q9.setOptionText("Remove an element from a list");
        option2Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option2Q9);

        QuestionOptions option3Q9 = new QuestionOptions();
        option3Q9.setOptionText("Add an element at the beginning of a list");
        option3Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option3Q9);

        QuestionOptions option4Q9 = new QuestionOptions();
        option4Q9.setOptionText("Replace an element in a list");
        option4Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option4Q9);

        // Question 10 - A set does not allow duplicate values
        QuizQuestion question10 = new QuizQuestion();
        question10.setQuestion("Which of the following data types does not allow duplicate values in Python?");
        question10.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question10.setCorrectAnswer("Set");
        question10.setQuiz(quiz);
        quizQuestionRepository.save(question10);

        QuestionOptions option1Q10 = new QuestionOptions();
        option1Q10.setOptionText("List");
        option1Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option1Q10);

        QuestionOptions option2Q10 = new QuestionOptions();
        option2Q10.setOptionText("Tuple");
        option2Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option2Q10);

        QuestionOptions option3Q10 = new QuestionOptions();
        option3Q10.setOptionText("Set");
        option3Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option3Q10);

        QuestionOptions option4Q10 = new QuestionOptions();
        option4Q10.setOptionText("Dictionary");
        option4Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option4Q10);
    }


}
