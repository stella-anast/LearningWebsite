package com.example.educationsite.controllers;

import com.example.educationsite.dto.QuizStatisticsDTO;
import com.example.educationsite.services.UserAnswerService;
import com.example.educationsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class StatisticsController {

    @Autowired
    private UserAnswerService answerService;

    @Autowired
    private UserService userService;

    @GetMapping("/{username}/statistics")
    public String getStatistics(@PathVariable String username, Model model) {
        Long userId = userService.findUserIdByUsername(username);

        List<QuizStatisticsDTO> quizStatistics = answerService.getStatisticsForUser(userId);

        // Add the quiz statistics to the model
        model.addAttribute("quizStatistics", quizStatistics);

        return "statistics"; // The name of your HTML file without extension
    }
}
