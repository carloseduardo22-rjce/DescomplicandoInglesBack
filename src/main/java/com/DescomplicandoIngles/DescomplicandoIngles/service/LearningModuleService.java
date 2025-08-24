package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.LessonDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.DifficultyLevel;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.LearningModule;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.DifficultyLevelRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.LearningModuleRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LearningModuleService {

    private final LearningModuleRepository learningModuleRepository;
    private final DifficultyLevelRepository difficultyLevelRepository;
    private final UserRepository userRepository;

    public LearningModuleService(LearningModuleRepository learningModuleRepository,
                                DifficultyLevelRepository difficultyLevelRepository,
                                UserRepository userRepository) {
        this.learningModuleRepository = learningModuleRepository;
        this.difficultyLevelRepository = difficultyLevelRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<LearningModule> moduleList() {
        return learningModuleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findLessonsByModuleAndDifficulty(Integer learningModuleId, Integer difficultyId, UUID userId) {
        LearningModule learningModule = learningModuleRepository.findById(learningModuleId)
                .orElseThrow(() -> new EntityNotFoundException("LearningModule not found with id: " + learningModuleId));

        if (learningModule.getInMaintenance()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body("This module is currently under maintenance. Please try again later.");
        }

        DifficultyLevel difficultyLevel = difficultyLevelRepository.findByIdAndLearningModule(difficultyId, learningModule)
                .orElseThrow(() -> new EntityNotFoundException("DifficultyLevel not found with id: " + difficultyId + " for module: " + learningModuleId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        if (user.getDifficultyLevel() != difficultyLevel) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("The user level is different from the requested module.");
        }

        List<Lesson> lessons = difficultyLevel.getLessons();

        List<LessonDTO> lessonDTOS = lessons.stream()
                .map(LessonDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lessonDTOS);
    }

}
