package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.LearningModule;
import com.DescomplicandoIngles.DescomplicandoIngles.service.LearningModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/learning-module")
public class LearningModuleController {

    private final LearningModuleService learningModuleService;

    public LearningModuleController (LearningModuleService learningModuleService) {
        this.learningModuleService = learningModuleService;
    }

    @GetMapping
    public ResponseEntity<List<LearningModule>> learningModulesAvailables() {
        return ResponseEntity.status(HttpStatus.OK).body(learningModuleService.moduleList());
    }

    @GetMapping("/{moduleId}/difficulty/{difficultyId}/user/{userId}/lesson")
    public ResponseEntity<?> getLessonsByDifficultyLevel(
            @PathVariable Integer moduleId,
            @PathVariable Integer difficultyId,
            @PathVariable UUID userId) {

        return ResponseEntity.status(HttpStatus.OK).body(learningModuleService.findLessonsByModuleAndDifficulty(moduleId, difficultyId, userId));
    }

}
