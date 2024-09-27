package com.example.educationsite.controllers;

import com.example.educationsite.services.UserAnswerService;
import com.example.educationsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class StatisticsController {

    @Autowired
    private UserAnswerService answerService;

    @Autowired
    private UserService userService;

    @GetMapping("/{username}/statistics/1")
    public String getStatistics(@PathVariable String username, Model model) {
        Long userId = userService.findUserIdByUsername(username);
        int correctCount = answerService.getCorrectAnswersCount(userId, 1L); // Quiz ID is hardcoded to 1
        int totalCount = answerService.getTotalAnswersCount(userId, 1L); // Quiz ID is hardcoded to 1
        double percentage = (totalCount > 0) ? (double) correctCount / totalCount * 100 : 0;

        int incorrectCount = totalCount - correctCount;

        model.addAttribute("totalQuestions", totalCount);
        model.addAttribute("correctAnswers", correctCount);
        model.addAttribute("incorrectAnswers", incorrectCount);
        model.addAttribute("scorePercentage", percentage);

        return "statistics"; // The name of your HTML file without extension
    }

}

