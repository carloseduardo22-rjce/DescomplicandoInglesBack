package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.LessonDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.DifficultyLevel;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.LearningModule;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.User;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.DifficultyLevelRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.LearningModuleRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearningModuleService {

    @Autowired
    private LearningModuleRepository learningModuleRepository;

    @Autowired
    private DifficultyLevelRepository difficultyLevelRepository;

    @Autowired
    private UserRepository userRepository;


    public List<LearningModule> moduleList() {
        return learningModuleRepository.findAll();
    }

    public ResponseEntity<?> findLessonsByModuleAndDifficulty(Integer learningModuleId, Integer difficultyId, Integer userId) {
        LearningModule learningModule = learningModuleRepository.findById(learningModuleId)
                .orElseThrow(() -> new ObjectNotFoundException("Module not found!"));

        if (learningModule.getInMaintenance()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body("This module is currently under maintenance. Please try again later.");
        }

        DifficultyLevel difficultyLevel = difficultyLevelRepository.findByIdAndLearningModule(difficultyId, learningModule)
                .orElseThrow(() -> new ObjectNotFoundException("Difficulty level not found for this module!"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException("User not found!"));

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
