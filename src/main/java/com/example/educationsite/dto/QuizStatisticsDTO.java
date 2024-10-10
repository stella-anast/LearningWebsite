package com.example.educationsite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizStatisticsDTO {
    private Long quizId;
    private int totalQuestions;
    private int correctAnswers;
    private int incorrectAnswers;
    private double scorePercentage;
}
