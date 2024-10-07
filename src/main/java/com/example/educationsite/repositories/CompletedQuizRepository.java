package com.example.educationsite.repositories;

import com.example.educationsite.models.CompletedQuiz;
import com.example.educationsite.models.CompletedQuizId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedQuizRepository extends JpaRepository<CompletedQuiz, CompletedQuizId> {
}
