package com.example.educationsite.dto;

import java.util.List;

public class QuizSubmissionDTO {
    private Long quizId;
    private List<AnswerDTO> answers;

    public Long getQuizId() {
        return quizId;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    // Getters and setters

    public static class AnswerDTO {
        private int questionId;
        private String answer;

        public String getAnswer() {
            return answer;
        }

        public int getQuestionId() {
            return questionId;
        }

    }
}
