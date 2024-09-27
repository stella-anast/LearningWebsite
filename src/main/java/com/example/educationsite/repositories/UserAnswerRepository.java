package com.example.educationsite.repositories;

import com.example.educationsite.models.QuizQuestion;
import com.example.educationsite.models.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.educationsite.models.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    Optional<UserAnswer> findByUserEntityAndQuizQuestion(UserEntity userEntity, QuizQuestion quizQuestion);
    List<UserAnswer> findByUserEntityAndIsCorrectFalse(UserEntity user);
}
