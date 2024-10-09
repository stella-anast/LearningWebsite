package com.example.educationsite.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name="quizzes")
public class Quiz {
    @Id
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="lesson_id",nullable = false)
    private Lesson lesson;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuizQuestion> questions;

}
