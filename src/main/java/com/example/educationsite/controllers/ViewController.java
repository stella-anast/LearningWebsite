package com.example.educationsite.controllers;

import com.example.educationsite.SkillLevel;
import com.example.educationsite.dto.QuizSubmissionDTO;
import com.example.educationsite.models.*;
import com.example.educationsite.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/statistics/{userId}/{quizId}")
    public String getStatistics(@PathVariable String username,@PathVariable Long userId, @PathVariable Long quizId) {
        int correctCount = answerService.getCorrectAnswersCount(userId, quizId);
        int totalCount = answerService.getTotalAnswersCount(userId, quizId);
        double percentage = (double) correctCount / totalCount * 100;

        return String.format("User ID: %d, Quiz ID: %d, Correct Answers: %d, Total Answers: %d, Percentage: %.2f%%",
                userId, quizId, correctCount, totalCount, percentage);
    }
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

    @GetMapping("/quizzes/quiz/retry") // Endpoint to get quiz by ID
    public String showRetryQuiz(@PathVariable String username, Model model) {
        UserEntity user = userService.findByUsername(username);
        List<Long> wrongQuestionIds = answerService.getIncorrectQuestionIds(user);
        List<QuizQuestion> wrongQuestions = quizQuestionService.findQuestionsByIds(wrongQuestionIds);
        model.addAttribute("username", username);
        model.addAttribute("questions", wrongQuestions);
        model.addAttribute("user", user);
        model.addAttribute("quizId", 0);
        return "quiz";
    }

    @PostMapping("/quiz/submit")
    public ResponseEntity<Map<String, String>> submitQuiz(@PathVariable String username, @RequestBody QuizSubmissionDTO submission) {
        // Access quizId and answers from submission object
        Long quizId = submission.getQuizId();  // quizId can now be String or Long
        List<QuizSubmissionDTO.AnswerDTO> answers = submission.getAnswers();
        List<QuizQuestion> questions;
        Boolean lessonQuiz = false;

        if (quizId == 0.0) {
            List<Long> questionIds = answers.stream()
                    .map(answer -> Long.valueOf(answer.getQuestionId()))  // Convert Integer to Long
                    .collect(Collectors.toList());
            System.out.println(questionIds);
            questions = quizQuestionService.findQuestionsByIds(questionIds);

        } else if (quizId instanceof Long) {
            // If quizId is a Long, fetch all questions by quizId
            questions = quizQuestionService.findByQuizId((Long) quizId);
            lessonQuiz = true;
        } else {
            throw new IllegalArgumentException("Invalid quizId type");
        }

        UserEntity user = userService.findByUsername(username);

        // Iterate through the questions and save the answers
        int correctAnswers = 0;
        for (QuizQuestion question : questions) {
            Boolean correct = answerService.saveUserAnswer(user, answers, question);  // save and return boolean isCorrect
            if(correct){
                correctAnswers++;
            }
        }
        int score = (correctAnswers * 100) / questions.size();

        if(lessonQuiz){
            Quiz q = quizService.findById(quizId);
            // define composite id
            CompletedQuizId id = new CompletedQuizId();
            id.setUserId(user.getId());
            id.setQuizId(quizId);
            // define entry
            CompletedQuiz completedQuiz = new CompletedQuiz();
            completedQuiz.setId(id);
            if(score >= 80){
                completedQuiz.setCompleted(true);
            }
            else{
                completedQuiz.setCompleted(false);
            }
            answerService.submitQuiz(completedQuiz);
            System.out.println(score);
        }

        // Redirect to another controller to show the results
        Map<String, String> response = new HashMap<>();
        response.put("message", "Quiz submitted successfully");
        response.put("redirectUrl", "/api/" + username + "/quiz/" + quizId + "/results");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/quiz/{quizId}/results")
    public String getResults(@PathVariable String username, @PathVariable String quizId, Model model) {
        UserEntity user = userService.findByUsername(username);
        List<Long> wrongQuestionIds;
        Long qid = Long.valueOf(quizId);
        if(qid!=0){
            wrongQuestionIds = answerService.getIncorrectQuestionIds(user, Long.valueOf(quizId));
        } else {
            wrongQuestionIds = answerService.getIncorrectQuestionIds(user);
        }
        List<QuizQuestion> wrongQuestions = quizQuestionService.findQuestionsByIds(wrongQuestionIds);
        // Get the wrongQuestions from the quiz question service
        model.addAttribute("username", username);
        model.addAttribute("questions", wrongQuestions);
        model.addAttribute("user", user);
        model.addAttribute("quizId", quizId);
        return "results";  // Replace with the actual view name
    }

    @GetMapping("/quizzes")
    public String showQuizzes(@PathVariable String username, Model model) {
        UserEntity user = userService.findByUsername(username);
        List<Quiz> quizzes = quizService.findBySkillLevel(mapSkillLevelToLessonId(user.getSkillLevel()));

        // Prepare a map of quiz IDs to completion status
        Map<Long, Boolean> quizCompletionStatus = new HashMap<>();

        for (Quiz quiz : quizzes) {
            // Check if the quiz has been completed by the user
            CompletedQuizId completedQuizId = new CompletedQuizId(quiz.getId(), user.getId());
            Optional<CompletedQuiz> completedQuiz = answerService.findSubmissionById(completedQuizId);
            quizCompletionStatus.put(quiz.getId(),
                    completedQuiz.map(CompletedQuiz::isCompleted).orElse(null)
            );
        }

        // Group, sort by Lesson ID in ascending order, and collect entries
        List<Map.Entry<Lesson, List<Quiz>>> quizzesByLesson = quizzes.stream()
                .collect(Collectors.groupingBy(Quiz::getLesson))
                .entrySet().stream()
                .sorted(Map.Entry.<Lesson, List<Quiz>>comparingByKey(Comparator.comparingLong(Lesson::getId))) // Ascending order
                .collect(Collectors.toList());

        boolean allQuizzesCompleted = quizCompletionStatus.values().stream().allMatch(Boolean.TRUE::equals);
        model.addAttribute("username", username);
        model.addAttribute("quizzesByLesson", quizzesByLesson);
        model.addAttribute("user", user);
        model.addAttribute("allQuizzesCompleted", allQuizzesCompleted);
        model.addAttribute("quizCompletionStatus", quizCompletionStatus);  // Add quiz completion status to the model

        return "quizzes";
    }
    @GetMapping("/dashboard")
    public String showDashboard(@PathVariable String username, Model model) {
        UserEntity user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "dashboard";
    }

    private Long mapSkillLevelToLessonId(SkillLevel skillLevel) {
        switch (skillLevel) {
            case BEGINNER:
                return 1L;  // Lesson ID for Beginner
            case INTERMEDIATE:
                return 2L;  // Lesson ID for Intermediate
            case PRO:
                return 3L;  // Lesson ID for Pro
            default:
                throw new IllegalArgumentException("Unknown skill level: " + skillLevel);
        }
    }

}
