package com.example.educationsite.models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompletedQuizId implements Serializable {

    private Long quizId;
    private Long userId;

    public CompletedQuizId() {}

    public CompletedQuizId(Long quizId, Long userId) {
        this.quizId = quizId;
        this.userId = userId;
    }

    // Getters and setters

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompletedQuizId that = (CompletedQuizId) o;
        return Objects.equals(quizId, that.quizId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quizId, userId);
    }
}

