package com.DescomplicandoIngles.DescomplicandoIngles.repository;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.DifficultyLevel;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.LearningModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DifficultyLevelRepository extends JpaRepository<DifficultyLevel, Integer> {
    Optional<DifficultyLevel> findByIdAndLearningModule(Integer id, LearningModule learningModule);
}
