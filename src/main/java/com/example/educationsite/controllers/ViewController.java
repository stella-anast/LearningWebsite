package com.example.educationsite.controllers;

import com.example.educationsite.dto.QuizSubmissionDTO;
import com.example.educationsite.services.QuizService;
import com.example.educationsite.models.Quiz;
import com.example.educationsite.models.QuizQuestion;
import com.example.educationsite.models.UserEntity;
import com.example.educationsite.services.QuizQuestionService;
import com.example.educationsite.services.UserAnswerService;
import com.example.educationsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/{username}")
public class ViewController {
    @Autowired
    private UserService userService;
    @Autowired
    private QuizQuestionService quizQuestionService;
    @Autowired
    private QuizService quizService;
    @Autowired
    private UserAnswerService answerService;
    @GetMapping("/material")
    public String showMaterial(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "material";
    }
    @GetMapping("/lecture1")
    public String showLecture(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "lecture1";
    }
    @GetMapping("/home")
    public String showHomePage(@PathVariable String username, Model model) {
        UserEntity user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "mainPage";
    }
   @GetMapping("/quizzes/quiz/{id}") // Endpoint to get quiz by ID
    public String showQuiz(@PathVariable String username, @PathVariable Long id, Model model) {
        UserEntity user = userService.findByUsername(username);

        List<QuizQuestion> questions = quizQuestionService.findByQuizId(id);
        model.addAttribute("username", username);
        model.addAttribute("questions", questions);
        model.addAttribute("user", user);
        model.addAttribute("quizId", id);

        return "quiz";
    }

    @PostMapping("/quiz/submit")
    public ResponseEntity<String> submitQuiz(@PathVariable String username, @RequestBody QuizSubmissionDTO submission) {
        // Access quizId and answers from submission object
        Long quizId = submission.getQuizId();
        List<QuizSubmissionDTO.AnswerDTO> answers = submission.getAnswers();
        List<QuizQuestion> questions = quizQuestionService.findByQuizId(quizId);
        UserEntity user = userService.findByUsername(username);
        // Iterate through the questions
        for (QuizQuestion question : questions) {
            answerService.saveUserAnswers(user,answers, question);  // Assume there's a service to handle saving UserAnswer
        }

        return ResponseEntity.status(HttpStatus.OK).body("Quiz submitted successfully.");
    }



    @GetMapping("/quizzes")
    public String showQuizzes(@PathVariable String username, Model model) {
        UserEntity user = userService.findByUsername(username);
        List<Quiz> quizzes = quizService.findAll();
        model.addAttribute("username", username);
        model.addAttribute("quizzes", quizzes);
        model.addAttribute("user", user);
        return "quizzes";
    }
    @GetMapping("/dashboard")
    public String showDashboard(@PathVariable String username, Model model) {
        UserEntity user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "dashboard";
    }

}
