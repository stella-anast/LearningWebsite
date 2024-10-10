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
    public List<QuizQuestion> findQuestionsByIds(List<Long> questionIds) {
        return quizQuestionRepository.findAllById(questionIds);
    }
    //1st quiz beginner-quiz_id=1
    @Transactional
    public void addQuizQuestions1(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

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

        QuizQuestion question7 = new QuizQuestion();
        question7.setQuestion("In Python, variables are automatically declared when a value is assigned.");
        question7.setQuestionType(QuestionType.TRUE_FALSE);
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

    //2nd quiz beginner-quiz_id=2
    @Transactional
    public void addQuizQuestions2(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Question 1 - What is Python?
        QuizQuestion question1 = new QuizQuestion();
        question1.setQuestion("What is Python?");
        question1.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question1.setCorrectAnswer("A high-level, interpreted programming language");
        question1.setQuiz(quiz);
        quizQuestionRepository.save(question1);

        QuestionOptions option1Q1 = new QuestionOptions();
        option1Q1.setOptionText("A type of snake");
        option1Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option1Q1);

        QuestionOptions option2Q1 = new QuestionOptions();
        option2Q1.setOptionText("A scripting language for web development");
        option2Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option2Q1);

        QuestionOptions option3Q1 = new QuestionOptions();
        option3Q1.setOptionText("A high-level, interpreted programming language");
        option3Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option3Q1);

        QuestionOptions option4Q1 = new QuestionOptions();
        option4Q1.setOptionText("A database management tool");
        option4Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option4Q1);

        // Question 2 - How do you create a variable in Python?
        QuizQuestion question2 = new QuizQuestion();
        question2.setQuestion("Which of the following correctly declares a variable in Python?");
        question2.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question2.setCorrectAnswer("x = 5");
        question2.setQuiz(quiz);
        quizQuestionRepository.save(question2);

        QuestionOptions option1Q2 = new QuestionOptions();
        option1Q2.setOptionText("int x = 5;");
        option1Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option1Q2);

        QuestionOptions option2Q2 = new QuestionOptions();
        option2Q2.setOptionText("x = 5");
        option2Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option2Q2);

        QuestionOptions option3Q2 = new QuestionOptions();
        option3Q2.setOptionText("var x = 5;");
        option3Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option3Q2);

        QuestionOptions option4Q2 = new QuestionOptions();
        option4Q2.setOptionText("x := 5");
        option4Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option4Q2);

        // Question 3 - What is the output of print(2 + 2)?
        QuizQuestion question3 = new QuizQuestion();
        question3.setQuestion("What is the output of print(2 + 2)?");
        question3.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question3.setCorrectAnswer("4");
        question3.setQuiz(quiz);
        quizQuestionRepository.save(question3);

        QuestionOptions option1Q3 = new QuestionOptions();
        option1Q3.setOptionText("22");
        option1Q3.setQuizQuestion(question3);
        questionOptionsRepository.save(option1Q3);

        QuestionOptions option2Q3 = new QuestionOptions();
        option2Q3.setOptionText("4");
        option2Q3.setQuizQuestion(question3);
        questionOptionsRepository.save(option2Q3);

        QuestionOptions option3Q3 = new QuestionOptions();
        option3Q3.setOptionText("Error");
        option3Q3.setQuizQuestion(question3);
        questionOptionsRepository.save(option3Q3);

        QuestionOptions option4Q3 = new QuestionOptions();
        option4Q3.setOptionText("None");
        option4Q3.setQuizQuestion(question3);
        questionOptionsRepository.save(option4Q3);

        // Question 4 - How do you create a function in Python?
        QuizQuestion question4 = new QuizQuestion();
        question4.setQuestion("How do you create a function in Python?");
        question4.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question4.setCorrectAnswer("def my_function():");
        question4.setQuiz(quiz);
        quizQuestionRepository.save(question4);

        QuestionOptions option1Q4 = new QuestionOptions();
        option1Q4.setOptionText("function my_function()");
        option1Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option1Q4);

        QuestionOptions option2Q4 = new QuestionOptions();
        option2Q4.setOptionText("def my_function():");
        option2Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option2Q4);

        QuestionOptions option3Q4 = new QuestionOptions();
        option3Q4.setOptionText("func my_function()");
        option3Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option3Q4);

        QuestionOptions option4Q4 = new QuestionOptions();
        option4Q4.setOptionText("function:my_function()");
        option4Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option4Q4);

        // Question 5 - Python supports which data structures?
        QuizQuestion question5 = new QuizQuestion();
        question5.setQuestion("Which of the following are data structures supported by Python?");
        question5.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question5.setCorrectAnswer("List, Tuple, Set, and Dictionary");
        question5.setQuiz(quiz);
        quizQuestionRepository.save(question5);

        QuestionOptions option1Q5 = new QuestionOptions();
        option1Q5.setOptionText("Array, Stack, Queue");
        option1Q5.setQuizQuestion(question5);
        questionOptionsRepository.save(option1Q5);

        QuestionOptions option2Q5 = new QuestionOptions();
        option2Q5.setOptionText("List, Tuple, Set, and Dictionary");
        option2Q5.setQuizQuestion(question5);
        questionOptionsRepository.save(option2Q5);

        QuestionOptions option3Q5 = new QuestionOptions();
        option3Q5.setOptionText("Set, List, Stack, and Tree");
        option3Q5.setQuizQuestion(question5);
        questionOptionsRepository.save(option3Q5);

        QuestionOptions option4Q5 = new QuestionOptions();
        option4Q5.setOptionText("LinkedList, HashMap, Dictionary");
        option4Q5.setQuizQuestion(question5);
        questionOptionsRepository.save(option4Q5);

        // Question 6 - What does the len() function do?
        QuizQuestion question6 = new QuizQuestion();
        question6.setQuestion("What does the len() function return?");
        question6.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question6.setCorrectAnswer("The length of a list, string, or other iterable");
        question6.setQuiz(quiz);
        quizQuestionRepository.save(question6);

        QuestionOptions option1Q6 = new QuestionOptions();
        option1Q6.setOptionText("The maximum value in a list");
        option1Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option1Q6);

        QuestionOptions option2Q6 = new QuestionOptions();
        option2Q6.setOptionText("The length of a list, string, or other iterable");
        option2Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option2Q6);

        QuestionOptions option3Q6 = new QuestionOptions();
        option3Q6.setOptionText("The length of an integer");
        option3Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option3Q6);

        QuestionOptions option4Q6 = new QuestionOptions();
        option4Q6.setOptionText("The number of function arguments");
        option4Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option4Q6);

        // Question 7 - Python allows what kind of indentation?
        QuizQuestion question7 = new QuizQuestion();
        question7.setQuestion("What is the correct indentation style in Python?");
        question7.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question7.setCorrectAnswer("4 spaces or 1 tab, but consistent");
        question7.setQuiz(quiz);
        quizQuestionRepository.save(question7);

        QuestionOptions option1Q7 = new QuestionOptions();
        option1Q7.setOptionText("It doesn't matter as long as the code works");
        option1Q7.setQuizQuestion(question7);
        questionOptionsRepository.save(option1Q7);

        QuestionOptions option2Q7 = new QuestionOptions();
        option2Q7.setOptionText("4 spaces or 1 tab, but consistent");
        option2Q7.setQuizQuestion(question7);
        questionOptionsRepository.save(option2Q7);

        QuestionOptions option3Q7 = new QuestionOptions();
        option3Q7.setOptionText("2 spaces, regardless of context");
        option3Q7.setQuizQuestion(question7);
        questionOptionsRepository.save(option3Q7);

        QuestionOptions option4Q7 = new QuestionOptions();
        option4Q7.setOptionText("No indentation required");
        option4Q7.setQuizQuestion(question7);
        questionOptionsRepository.save(option4Q7);

        // Question 8 - What is the result of `4 / 2` in Python?
        QuizQuestion question8 = new QuizQuestion();
        question8.setQuestion("What is the result of `4 / 2` in Python?");
        question8.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question8.setCorrectAnswer("2.0");
        question8.setQuiz(quiz);
        quizQuestionRepository.save(question8);

        QuestionOptions option1Q8 = new QuestionOptions();
        option1Q8.setOptionText("2");
        option1Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option1Q8);

        QuestionOptions option2Q8 = new QuestionOptions();
        option2Q8.setOptionText("2.0");
        option2Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option2Q8);

        QuestionOptions option3Q8 = new QuestionOptions();
        option3Q8.setOptionText("None");
        option3Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option3Q8);

        QuestionOptions option4Q8 = new QuestionOptions();
        option4Q8.setOptionText("Error");
        option4Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option4Q8);
        
        // Question 9 - What are the three numeric types in Python?
        QuizQuestion question9 = new QuizQuestion();
        question9.setQuestion("What are the three numeric types in Python?");
        question9.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question9.setCorrectAnswer("int, float, and complex");
        question9.setQuiz(quiz);
        quizQuestionRepository.save(question9);

        QuestionOptions option1Q9 = new QuestionOptions();
        option1Q9.setOptionText("int, float, and double");
        option1Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option1Q9);

        QuestionOptions option2Q9 = new QuestionOptions();
        option2Q9.setOptionText("integer, decimal, and fraction");
        option2Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option2Q9);

        QuestionOptions option3Q9 = new QuestionOptions();
        option3Q9.setOptionText("int, float, and complex");
        option3Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option3Q9);

        QuestionOptions option4Q9 = new QuestionOptions();
        option4Q9.setOptionText("integer, float, and complex");
        option4Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option4Q9);

        // Question 10 - What does the range() function do in Python?
        QuizQuestion question10 = new QuizQuestion();
        question10.setQuestion("What does the range() function do in Python?");
        question10.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question10.setCorrectAnswer("Returns a sequence of numbers");
        question10.setQuiz(quiz);
        quizQuestionRepository.save(question10);

        QuestionOptions option1Q10 = new QuestionOptions();
        option1Q10.setOptionText("Creates a list of random numbers");
        option1Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option1Q10);

        QuestionOptions option2Q10 = new QuestionOptions();
        option2Q10.setOptionText("Returns a sequence of numbers");
        option2Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option2Q10);

        QuestionOptions option3Q10 = new QuestionOptions();
        option3Q10.setOptionText("Generates a set of even numbers");
        option3Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option3Q10);

        QuestionOptions option4Q10 = new QuestionOptions();
        option4Q10.setOptionText("Reverses the order of a list");
        option4Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option4Q10);

    }
    //1st quiz intermediate-quiz_id=3
    @Transactional
    public void addQuizQuestions3(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Question 1 - What is Python primarily used for?
        QuizQuestion question1 = new QuizQuestion();
        question1.setQuestion("What is Python primarily used for?");
        question1.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question1.setCorrectAnswer("General-purpose programming");
        question1.setQuiz(quiz);
        quizQuestionRepository.save(question1);

        QuestionOptions option1Q1 = new QuestionOptions();
        option1Q1.setOptionText("General-purpose programming");
        option1Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option1Q1);

        QuestionOptions option2Q1 = new QuestionOptions();
        option2Q1.setOptionText("Only web development");
        option2Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option2Q1);

        QuestionOptions option3Q1 = new QuestionOptions();
        option3Q1.setOptionText("Only data science");
        option3Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option3Q1);

        QuestionOptions option4Q1 = new QuestionOptions();
        option4Q1.setOptionText("Only automation");
        option4Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option4Q1);

        // Question 2 - What is the output of 5 // 2 in Python?
        QuizQuestion question2 = new QuizQuestion();
        question2.setQuestion("What is the output of 5 // 2 in Python?");
        question2.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question2.setCorrectAnswer("2");
        question2.setQuiz(quiz);
        quizQuestionRepository.save(question2);

        QuestionOptions option1Q2 = new QuestionOptions();
        option1Q2.setOptionText("2");
        option1Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option1Q2);

        QuestionOptions option2Q2 = new QuestionOptions();
        option2Q2.setOptionText("2.5");
        option2Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option2Q2);

        QuestionOptions option3Q2 = new QuestionOptions();
        option3Q2.setOptionText("3");
        option3Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option3Q2);

        QuestionOptions option4Q2 = new QuestionOptions();
        option4Q2.setOptionText("Error");
        option4Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option4Q2);

        // Question 3 - True or False: Python uses indentation to define blocks of code.
        QuizQuestion question3 = new QuizQuestion();
        question3.setQuestion("Python uses indentation to define blocks of code.");
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

        // Question 4 - Which of the following is not a data structure in Python?
        QuizQuestion question4 = new QuizQuestion();
        question4.setQuestion("Which of the following is not a data structure in Python?");
        question4.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question4.setCorrectAnswer("Enum");
        question4.setQuiz(quiz);
        quizQuestionRepository.save(question4);

        QuestionOptions option1Q4 = new QuestionOptions();
        option1Q4.setOptionText("List");
        option1Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option1Q4);

        QuestionOptions option2Q4 = new QuestionOptions();
        option2Q4.setOptionText("Tuple");
        option2Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option2Q4);

        QuestionOptions option3Q4 = new QuestionOptions();
        option3Q4.setOptionText("Set");
        option3Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option3Q4);

        QuestionOptions option4Q4 = new QuestionOptions();
        option4Q4.setOptionText("Enum");
        option4Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option4Q4);

        // Question 5 - What is the method to add an element to a set?
        QuizQuestion question5 = new QuizQuestion();
        question5.setQuestion("What is the method to add an element to a set?");
        question5.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question5.setCorrectAnswer("add()");
        question5.setQuiz(quiz);
        quizQuestionRepository.save(question5);

        QuestionOptions option1Q5 = new QuestionOptions();
        option1Q5.setOptionText("insert()");
        option1Q5.setQuizQuestion(question5);
        questionOptionsRepository.save(option1Q5);

        QuestionOptions option2Q5 = new QuestionOptions();
        option2Q5.setOptionText("add()");
        option2Q5.setQuizQuestion(question5);
        questionOptionsRepository.save(option2Q5);

        QuestionOptions option3Q5 = new QuestionOptions();
        option3Q5.setOptionText("append()");
        option3Q5.setQuizQuestion(question5);
        questionOptionsRepository.save(option3Q5);

        QuestionOptions option4Q5 = new QuestionOptions();
        option4Q5.setOptionText("push()");
        option4Q5.setQuizQuestion(question5);
        questionOptionsRepository.save(option4Q5);

        // Question 6 - True or False: Python is a statically typed language.
        QuizQuestion question6 = new QuizQuestion();
        question6.setQuestion("Python is a statically typed language.");
        question6.setQuestionType(QuestionType.TRUE_FALSE);
        question6.setCorrectAnswer("False");
        question6.setQuiz(quiz);
        quizQuestionRepository.save(question6);

        QuestionOptions option1Q6 = new QuestionOptions();
        option1Q6.setOptionText("True");
        option1Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option1Q6);

        QuestionOptions option2Q6 = new QuestionOptions();
        option2Q6.setOptionText("False");
        option2Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option2Q6);

        // Question 7 - What keyword is used to define a function in Python?
        QuizQuestion question7 = new QuizQuestion();
        question7.setQuestion("What keyword is used to define a function in Python?");
        question7.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question7.setCorrectAnswer("def");
        question7.setQuiz(quiz);
        quizQuestionRepository.save(question7);

        QuestionOptions option1Q7 = new QuestionOptions();
        option1Q7.setOptionText("func");
        option1Q7.setQuizQuestion(question7);
        questionOptionsRepository.save(option1Q7);

        QuestionOptions option2Q7 = new QuestionOptions();
        option2Q7.setOptionText("define");
        option2Q7.setQuizQuestion(question7);
        questionOptionsRepository.save(option2Q7);

        QuestionOptions option3Q7 = new QuestionOptions();
        option3Q7.setOptionText("def");
        option3Q7.setQuizQuestion(question7);
        questionOptionsRepository.save(option3Q7);

        QuestionOptions option4Q7 = new QuestionOptions();
        option4Q7.setOptionText("function");
        option4Q7.setQuizQuestion(question7);
        questionOptionsRepository.save(option4Q7);

        // Question 8 - What will be the output of len([1, 2, 3])?
        QuizQuestion question8 = new QuizQuestion();
        question8.setQuestion("What will be the output of len([1, 2, 3])?");
        question8.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question8.setCorrectAnswer("3");
        question8.setQuiz(quiz);
        quizQuestionRepository.save(question8);

        QuestionOptions option1Q8 = new QuestionOptions();
        option1Q8.setOptionText("2");
        option1Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option1Q8);

        QuestionOptions option2Q8 = new QuestionOptions();
        option2Q8.setOptionText("3");
        option2Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option2Q8);

        QuestionOptions option3Q8 = new QuestionOptions();
        option3Q8.setOptionText("4");
        option3Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option3Q8);

        QuestionOptions option4Q8 = new QuestionOptions();
        option4Q8.setOptionText("Error");
        option4Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option4Q8);

        // Question 9 - True or False: Python lists can contain mixed data types.
        QuizQuestion question9 = new QuizQuestion();
        question9.setQuestion("Python lists can contain mixed data types.");
        question9.setQuestionType(QuestionType.TRUE_FALSE);
        question9.setCorrectAnswer("True");
        question9.setQuiz(quiz);
        quizQuestionRepository.save(question9);

        QuestionOptions option1Q9 = new QuestionOptions();
        option1Q9.setOptionText("True");
        option1Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option1Q9);

        QuestionOptions option2Q9 = new QuestionOptions();
        option2Q9.setOptionText("False");
        option2Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option2Q9);

        // Question 10 - What will be the output of 3 * 'abc'?
        QuizQuestion question10 = new QuizQuestion();
        question10.setQuestion("What will be the output of 3 * 'abc'?");
        question10.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question10.setCorrectAnswer("abcabcabc");
        question10.setQuiz(quiz);
        quizQuestionRepository.save(question10);

        QuestionOptions option1Q10 = new QuestionOptions();
        option1Q10.setOptionText("abcabcabc");
        option1Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option1Q10);

        QuestionOptions option2Q10 = new QuestionOptions();
        option2Q10.setOptionText("abcabc");
        option2Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option2Q10);

        QuestionOptions option3Q10 = new QuestionOptions();
        option3Q10.setOptionText("Error");
        option3Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option3Q10);

        QuestionOptions option4Q10 = new QuestionOptions();
        option4Q10.setOptionText("None");
        option4Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option4Q10);
    }
    //2nd quiz intermediate-quiz_id=4
    @Transactional
    public void addQuizQuestions4(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Question 1 - What is the output of print(2 + 3)?
        QuizQuestion question1 = new QuizQuestion();
        question1.setQuestion("What is the output of print(2 + 3)?");
        question1.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question1.setCorrectAnswer("5");
        question1.setQuiz(quiz);
        quizQuestionRepository.save(question1);

        QuestionOptions option1Q1 = new QuestionOptions();
        option1Q1.setOptionText("4");
        option1Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option1Q1);

        QuestionOptions option2Q1 = new QuestionOptions();
        option2Q1.setOptionText("5");
        option2Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option2Q1);

        QuestionOptions option3Q1 = new QuestionOptions();
        option3Q1.setOptionText("6");
        option3Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option3Q1);

        QuestionOptions option4Q1 = new QuestionOptions();
        option4Q1.setOptionText("Error");
        option4Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option4Q1);

        // Question 2 - True or False: Python supports lists and tuples.
        QuizQuestion question2 = new QuizQuestion();
        question2.setQuestion("Python supports lists and tuples.");
        question2.setQuestionType(QuestionType.TRUE_FALSE);
        question2.setCorrectAnswer("True");
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

        // Question 3 - How do you remove a key from a dictionary?
        QuizQuestion question3 = new QuizQuestion();
        question3.setQuestion("How do you remove a key from a dictionary?");
        question3.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question3.setCorrectAnswer("del dict[key]");
        question3.setQuiz(quiz);
        quizQuestionRepository.save(question3);

        QuestionOptions option1Q3 = new QuestionOptions();
        option1Q3.setOptionText("dict.remove(key)");
        option1Q3.setQuizQuestion(question3);
        questionOptionsRepository.save(option1Q3);

        QuestionOptions option2Q3 = new QuestionOptions();
        option2Q3.setOptionText("del dict[key]");
        option2Q3.setQuizQuestion(question3);
        questionOptionsRepository.save(option2Q3);

        QuestionOptions option3Q3 = new QuestionOptions();
        option3Q3.setOptionText("dict.pop(key)");
        option3Q3.setQuizQuestion(question3);
        questionOptionsRepository.save(option3Q3);

        QuestionOptions option4Q3 = new QuestionOptions();
        option4Q3.setOptionText("key.delete()");
        option4Q3.setQuizQuestion(question3);
        questionOptionsRepository.save(option4Q3);

        // Question 4 - What keyword is used for exception handling in Python?
        QuizQuestion question4 = new QuizQuestion();
        question4.setQuestion("What keyword is used for exception handling in Python?");
        question4.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question4.setCorrectAnswer("try");
        question4.setQuiz(quiz);
        quizQuestionRepository.save(question4);

        QuestionOptions option1Q4 = new QuestionOptions();
        option1Q4.setOptionText("try");
        option1Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option1Q4);

        QuestionOptions option2Q4 = new QuestionOptions();
        option2Q4.setOptionText("catch");
        option2Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option2Q4);

        QuestionOptions option3Q4 = new QuestionOptions();
        option3Q4.setOptionText("except");
        option3Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option3Q4);

        QuestionOptions option4Q4 = new QuestionOptions();
        option4Q4.setOptionText("throw");
        option4Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option4Q4);

        // Question 5 - True or False: Python uses a compiler to run the code.
        QuizQuestion question5 = new QuizQuestion();
        question5.setQuestion("Python uses a compiler to run the code.");
        question5.setQuestionType(QuestionType.TRUE_FALSE);
        question5.setCorrectAnswer("False");
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

        // Question 6 - What is the use of the input() function in Python?
        QuizQuestion question6 = new QuizQuestion();
        question6.setQuestion("What is the use of the input() function in Python?");
        question6.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question6.setCorrectAnswer("To take input from the user.");
        question6.setQuiz(quiz);
        quizQuestionRepository.save(question6);

        QuestionOptions option1Q6 = new QuestionOptions();
        option1Q6.setOptionText("To take input from the user.");
        option1Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option1Q6);

        QuestionOptions option2Q6 = new QuestionOptions();
        option2Q6.setOptionText("To display output to the user.");
        option2Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option2Q6);

        QuestionOptions option3Q6 = new QuestionOptions();
        option3Q6.setOptionText("To read files.");
        option3Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option3Q6);

        QuestionOptions option4Q6 = new QuestionOptions();
        option4Q6.setOptionText("To pause the execution.");
        option4Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option4Q6);

        // Question 7 - True or False: A lambda function can have multiple expressions.
        QuizQuestion question7 = new QuizQuestion();
        question7.setQuestion("A lambda function can have multiple expressions.");
        question7.setQuestionType(QuestionType.TRUE_FALSE);
        question7.setCorrectAnswer("False");
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

        // Question 8 - What is the purpose of the global keyword in Python?
        QuizQuestion question8 = new QuizQuestion();
        question8.setQuestion("What is the purpose of the global keyword in Python?");
        question8.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question8.setCorrectAnswer("To declare a variable as global.");
        question8.setQuiz(quiz);
        quizQuestionRepository.save(question8);

        QuestionOptions option1Q8 = new QuestionOptions();
        option1Q8.setOptionText("To declare a variable as local.");
        option1Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option1Q8);

        QuestionOptions option2Q8 = new QuestionOptions();
        option2Q8.setOptionText("To declare a variable as global.");
        option2Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option2Q8);

        QuestionOptions option3Q8 = new QuestionOptions();
        option3Q8.setOptionText("To declare a function.");
        option3Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option3Q8);

        QuestionOptions option4Q8 = new QuestionOptions();
        option4Q8.setOptionText("To initialize a variable.");
        option4Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option4Q8);

        // Question 9 - What is a correct way to create a dictionary in Python?
        QuizQuestion question9 = new QuizQuestion();
        question9.setQuestion("What is a correct way to create a dictionary in Python?");
        question9.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question9.setCorrectAnswer("{}");
        question9.setQuiz(quiz);
        quizQuestionRepository.save(question9);

        QuestionOptions option1Q9 = new QuestionOptions();
        option1Q9.setOptionText("[]");
        option1Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option1Q9);

        QuestionOptions option2Q9 = new QuestionOptions();
        option2Q9.setOptionText("{}");
        option2Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option2Q9);

        QuestionOptions option3Q9 = new QuestionOptions();
        option3Q9.setOptionText("dict()");
        option3Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option3Q9);

        QuestionOptions option4Q9 = new QuestionOptions();
        option4Q9.setOptionText("dict{}");
        option4Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option4Q9);

        // Question 10 - True or False: Python is an interpreted language.
        QuizQuestion question10 = new QuizQuestion();
        question10.setQuestion("Python is an interpreted language.");
        question10.setQuestionType(QuestionType.TRUE_FALSE);
        question10.setCorrectAnswer("True");
        question10.setQuiz(quiz);
        quizQuestionRepository.save(question10);

        QuestionOptions option1Q10 = new QuestionOptions();
        option1Q10.setOptionText("True");
        option1Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option1Q10);

        QuestionOptions option2Q10 = new QuestionOptions();
        option2Q10.setOptionText("False");
        option2Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option2Q10);
    }
    //1st quiz expert-quiz_id=5
    @Transactional
    public void addQuizQuestions5(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Question 1 - True or False: In Python, functions are first-class objects.
        QuizQuestion question1 = new QuizQuestion();
        question1.setQuestion("In Python, functions are first-class objects.");
        question1.setQuestionType(QuestionType.TRUE_FALSE);
        question1.setCorrectAnswer("True");
        question1.setQuiz(quiz);
        quizQuestionRepository.save(question1);

        QuestionOptions option1Q1 = new QuestionOptions();
        option1Q1.setOptionText("True");
        option1Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option1Q1);

        QuestionOptions option2Q1 = new QuestionOptions();
        option2Q1.setOptionText("False");
        option2Q1.setQuizQuestion(question1);
        questionOptionsRepository.save(option2Q1);

        // Question 2 - Which method allows any Python callable object to be invoked like a function?
        QuizQuestion question2 = new QuizQuestion();
        question2.setQuestion("Which method allows any Python callable object to be invoked like a function?");
        question2.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question2.setCorrectAnswer("__call__()");
        question2.setQuiz(quiz);
        quizQuestionRepository.save(question2);

        QuestionOptions option1Q2 = new QuestionOptions();
        option1Q2.setOptionText("__init__()");
        option1Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option1Q2);

        QuestionOptions option2Q2 = new QuestionOptions();
        option2Q2.setOptionText("__call__()");
        option2Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option2Q2);

        QuestionOptions option3Q2 = new QuestionOptions();
        option3Q2.setOptionText("__getitem__()");
        option3Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option3Q2);

        QuestionOptions option4Q2 = new QuestionOptions();
        option4Q2.setOptionText("__setitem__()");
        option4Q2.setQuizQuestion(question2);
        questionOptionsRepository.save(option4Q2);

        // Question 3 - True or False: The keyword `lambda` is used to define anonymous functions.
        QuizQuestion question3 = new QuizQuestion();
        question3.setQuestion("The keyword `lambda` is used to define anonymous functions.");
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

        // Question 4 - In Python, which module is used for multi-dimensional arrays?
        QuizQuestion question4 = new QuizQuestion();
        question4.setQuestion("In Python, which module is used for multi-dimensional arrays?");
        question4.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question4.setCorrectAnswer("NumPy");
        question4.setQuiz(quiz);
        quizQuestionRepository.save(question4);

        QuestionOptions option1Q4 = new QuestionOptions();
        option1Q4.setOptionText("list");
        option1Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option1Q4);

        QuestionOptions option2Q4 = new QuestionOptions();
        option2Q4.setOptionText("NumPy");
        option2Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option2Q4);

        QuestionOptions option3Q4 = new QuestionOptions();
        option3Q4.setOptionText("dict");
        option3Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option3Q4);

        QuestionOptions option4Q4 = new QuestionOptions();
        option4Q4.setOptionText("tuple");
        option4Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option4Q4);

        // Question 5 - True or False: Lists in Python can be used to represent two-dimensional arrays.
        QuizQuestion question5 = new QuizQuestion();
        question5.setQuestion("Lists in Python can be used to represent two-dimensional arrays.");
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

        // Question 6 - What will be the output of print([i for i in range(3)])?
        QuizQuestion question6 = new QuizQuestion();
        question6.setQuestion("What will be the output of print([i for i in range(3)])?");
        question6.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question6.setCorrectAnswer("[0, 1, 2]");
        question6.setQuiz(quiz);
        quizQuestionRepository.save(question6);

        QuestionOptions option1Q6 = new QuestionOptions();
        option1Q6.setOptionText("[1, 2, 3]");
        option1Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option1Q6);

        QuestionOptions option2Q6 = new QuestionOptions();
        option2Q6.setOptionText("[0, 1, 2]");
        option2Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option2Q6);

        QuestionOptions option3Q6 = new QuestionOptions();
        option3Q6.setOptionText("[0, 1, 2, 3]");
        option3Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option3Q6);

        QuestionOptions option4Q6 = new QuestionOptions();
        option4Q6.setOptionText("Error");
        option4Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option4Q6);

        // Question 7 - True or False: `__getitem__()` is a method used to access items via indexing in Python.
        QuizQuestion question7 = new QuizQuestion();
        question7.setQuestion("The `__getitem__()` is a method used to access items via indexing in Python.");
        question7.setQuestionType(QuestionType.TRUE_FALSE);
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

        // Question 8 - Which Python function is used to inspect the attributes of a function object?
        QuizQuestion question8 = new QuizQuestion();
        question8.setQuestion("Which Python function is used to inspect the attributes of a function object?");
        question8.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question8.setCorrectAnswer("dir()");
        question8.setQuiz(quiz);
        quizQuestionRepository.save(question8);

        QuestionOptions option1Q8 = new QuestionOptions();
        option1Q8.setOptionText("type()");
        option1Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option1Q8);

        QuestionOptions option2Q8 = new QuestionOptions();
        option2Q8.setOptionText("dir()");
        option2Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option2Q8);

        QuestionOptions option3Q8 = new QuestionOptions();
        option3Q8.setOptionText("id()");
        option3Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option3Q8);

        QuestionOptions option4Q8 = new QuestionOptions();
        option4Q8.setOptionText("help()");
        option4Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option4Q8);

        // Question 9 - True or False: A two-dimensional array can be represented as a list of lists in Python.
        QuizQuestion question9 = new QuizQuestion();
        question9.setQuestion("A two-dimensional array can be represented as a list of lists in Python.");
        question9.setQuestionType(QuestionType.TRUE_FALSE);
        question9.setCorrectAnswer("True");
        question9.setQuiz(quiz);
        quizQuestionRepository.save(question9);

        QuestionOptions option1Q9 = new QuestionOptions();
        option1Q9.setOptionText("True");
        option1Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option1Q9);

        QuestionOptions option2Q9 = new QuestionOptions();
        option2Q9.setOptionText("False");
        option2Q9.setQuizQuestion(question9);
        questionOptionsRepository.save(option2Q9);

        // Question 10 - Which type of object is used to handle multi-threading in Python?
        QuizQuestion question10 = new QuizQuestion();
        question10.setQuestion("Which type of object is used to handle multi-threading in Python?");
        question10.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question10.setCorrectAnswer("Thread");
        question10.setQuiz(quiz);
        quizQuestionRepository.save(question10);

        QuestionOptions option1Q10 = new QuestionOptions();
        option1Q10.setOptionText("Queue");
        option1Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option1Q10);

        QuestionOptions option2Q10 = new QuestionOptions();
        option2Q10.setOptionText("Thread");
        option2Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option2Q10);

        QuestionOptions option3Q10 = new QuestionOptions();
        option3Q10.setOptionText("Lock");
        option3Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option3Q10);

        QuestionOptions option4Q10 = new QuestionOptions();
        option4Q10.setOptionText("Event");
        option4Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option4Q10);
    }
    //2nd quiz expert-quiz_id=6
   @Transactional
    public void addQuizQuestions6(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Question 1 - True or False: Functions in Python are not objects and cannot be assigned to variables.
        QuizQuestion question1 = new QuizQuestion();
        question1.setQuestion("Functions in Python are not objects and cannot be assigned to variables.");
        question1.setQuestionType(QuestionType.TRUE_FALSE);
        question1.setCorrectAnswer("False");
        question1.setQuiz(quiz);
        quizQuestionRepository.save(question1);

        // Question 2 - Which Python library is commonly used for data manipulation and analysis,especially with tabular data?
       QuizQuestion question2 = new QuizQuestion();
       question2.setQuestion("Which Python library is commonly used for data manipulation and analysis,especially with tabular data?");
       question2.setQuestionType(QuestionType.MULTIPLE_CHOICE);
       question2.setCorrectAnswer("Pandas");
       question2.setQuiz(quiz);
       quizQuestionRepository.save(question2);

       QuestionOptions option1Q2 = new QuestionOptions();
       option1Q2.setOptionText("Pandas");
       option1Q2.setQuizQuestion(question2);
       questionOptionsRepository.save(option1Q2);

       QuestionOptions option2Q2 = new QuestionOptions();
       option2Q2.setOptionText("SciPy");
       option2Q2.setQuizQuestion(question2);
       questionOptionsRepository.save(option2Q2);

       QuestionOptions option3Q2 = new QuestionOptions();
       option3Q2.setOptionText("Matplotlib");
       option3Q2.setQuizQuestion(question2);
       questionOptionsRepository.save(option3Q2);

       QuestionOptions option4Q2 = new QuestionOptions();
       option4Q2.setOptionText("Seaborn");
       option4Q2.setQuizQuestion(question2);
       questionOptionsRepository.save(option4Q2);

       // Question 3 - True or False: The `__init__()` method is used to initialize an object in Python.
        QuizQuestion question3 = new QuizQuestion();
        question3.setQuestion("The `__init__()` method is used to initialize an object in Python.");
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

        // Question 4 - What is the output of the following list comprehension: `[x**2 for x in range(4)]`?
        QuizQuestion question4 = new QuizQuestion();
        question4.setQuestion("What is the output of the following list comprehension: `[x**2 for x in range(4)]`?");
        question4.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question4.setCorrectAnswer("[0, 1, 4, 9]");
        question4.setQuiz(quiz);
        quizQuestionRepository.save(question4);

        QuestionOptions option1Q4 = new QuestionOptions();
        option1Q4.setOptionText("[1, 2, 3, 4]");
        option1Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option1Q4);

        QuestionOptions option2Q4 = new QuestionOptions();
        option2Q4.setOptionText("[0, 1, 4, 9]");
        option2Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option2Q4);

        QuestionOptions option3Q4 = new QuestionOptions();
        option3Q4.setOptionText("[1, 4, 9, 16]");
        option3Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option3Q4);

        QuestionOptions option4Q4 = new QuestionOptions();
        option4Q4.setOptionText("[0, 1, 2, 3]");
        option4Q4.setQuizQuestion(question4);
        questionOptionsRepository.save(option4Q4);

        // Question 5 - True or False: A `TypeError` occurs when accessing a list with a float index in Python.
        QuizQuestion question5 = new QuizQuestion();
        question5.setQuestion("A `TypeError` occurs when accessing a list with a float index in Python.");
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

        // Question 6 - Which of these statements is true regarding list slicing in Python?
        QuizQuestion question6 = new QuizQuestion();
        question6.setQuestion("Which of these statements is true regarding list slicing in Python?");
        question6.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question6.setCorrectAnswer("Slice notation is used to get a subset of a list.");
        question6.setQuiz(quiz);
        quizQuestionRepository.save(question6);

        QuestionOptions option1Q6 = new QuestionOptions();
        option1Q6.setOptionText("You can only slice lists with positive integers.");
        option1Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option1Q6);

        QuestionOptions option2Q6 = new QuestionOptions();
        option2Q6.setOptionText("Slices are immutable.");
        option2Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option2Q6);

        QuestionOptions option3Q6 = new QuestionOptions();
        option3Q6.setOptionText("Slice notation is used to get a subset of a list.");
        option3Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option3Q6);

        QuestionOptions option4Q6 = new QuestionOptions();
        option4Q6.setOptionText("Slice indices can only be integers.");
        option4Q6.setQuizQuestion(question6);
        questionOptionsRepository.save(option4Q6);

        // Question 7 - True or False: The method `__setitem__()` is used to set a value at a particular index in Python.
        QuizQuestion question7 = new QuizQuestion();
        question7.setQuestion("The method `__setitem__()` is used to set a value at a particular index in Python.");
        question7.setQuestionType(QuestionType.TRUE_FALSE);
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

        // Question 8 - Which of the following would raise a `KeyError` in Python?
        QuizQuestion question8 = new QuizQuestion();
        question8.setQuestion("Which of the following would raise a `KeyError` in Python?");
        question8.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question8.setCorrectAnswer("my_dict['key']");
        question8.setQuiz(quiz);
        quizQuestionRepository.save(question8);

        QuestionOptions option1Q8 = new QuestionOptions();
        option1Q8.setOptionText("my_dict.get('key')");
        option1Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option1Q8);

        QuestionOptions option2Q8 = new QuestionOptions();
        option2Q8.setOptionText("my_dict['key']");
        option2Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option2Q8);

        QuestionOptions option3Q8 = new QuestionOptions();
        option3Q8.setOptionText("my_dict.setdefault('key', None)");
        option3Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option3Q8);

        QuestionOptions option4Q8 = new QuestionOptions();
        option4Q8.setOptionText("my_dict.update({'key': 'value'})");
        option4Q8.setQuizQuestion(question8);
        questionOptionsRepository.save(option4Q8);

        // Question 9 - True or False: In Python, the `compose()` function is used to combine multiple functions into one.
        QuizQuestion question9 = new QuizQuestion();
        question9.setQuestion("In Python, the `compose()` function is used to combine multiple functions into one.");
        question9.setQuestionType(QuestionType.TRUE_FALSE);
        question9.setCorrectAnswer("True");
        question9.setQuiz(quiz);
        quizQuestionRepository.save(question9);

       QuestionOptions option1Q9 = new QuestionOptions();
       option1Q9.setOptionText("True");
       option1Q9.setQuizQuestion(question9);
       questionOptionsRepository.save(option1Q9);

       QuestionOptions option2Q9 = new QuestionOptions();
       option2Q9.setOptionText("False");
       option2Q9.setQuizQuestion(question9);
       questionOptionsRepository.save(option2Q9);

        // Question 10 - Which of the following is an example of delegation in Python?
        QuizQuestion question10 = new QuizQuestion();
        question10.setQuestion("Which of the following is an example of delegation in Python?");
        question10.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        question10.setCorrectAnswer("Calling methods from another object");
        question10.setQuiz(quiz);
        quizQuestionRepository.save(question10);

        QuestionOptions option1Q10 = new QuestionOptions();
        option1Q10.setOptionText("Inheriting from a base class");
        option1Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option1Q10);

        QuestionOptions option2Q10 = new QuestionOptions();
        option2Q10.setOptionText("Overloading an operator");
        option2Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option2Q10);

        QuestionOptions option3Q10 = new QuestionOptions();
        option3Q10.setOptionText("Calling methods from another object");
        option3Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option3Q10);

        QuestionOptions option4Q10 = new QuestionOptions();
        option4Q10.setOptionText("Implementing recursion");
        option4Q10.setQuizQuestion(question10);
        questionOptionsRepository.save(option4Q10);
    }
}









