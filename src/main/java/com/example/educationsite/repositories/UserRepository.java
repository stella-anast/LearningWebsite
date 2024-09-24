package com.example.educationsite.repositories;
import com.example.educationsite.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


//queries
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}