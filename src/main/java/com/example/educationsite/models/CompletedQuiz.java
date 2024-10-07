package com.example.educationsite.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "completed_quizzes")
public class CompletedQuiz {

    @EmbeddedId
    private CompletedQuizId id;
    @Column(nullable = false)
    private boolean completed;

    public CompletedQuiz(CompletedQuizId id, boolean completed) {
        this.id = id;
        this.completed = completed;
    }

    // Getters and setters

    public CompletedQuizId getId() {
        return id;
    }

    public void setId(CompletedQuizId id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
