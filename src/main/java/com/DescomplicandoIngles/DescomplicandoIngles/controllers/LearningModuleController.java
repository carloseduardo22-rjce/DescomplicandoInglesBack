package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.LessonDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.LearningModule;
import com.DescomplicandoIngles.DescomplicandoIngles.service.LearningModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/LearningModule")
public class LearningModuleController {

    @Autowired
    private LearningModuleService learningModuleService;

    @GetMapping
    public ResponseEntity<List<LearningModule>> learningModulesAvailables() {
        return ResponseEntity.ok().body(learningModuleService.moduleList());
    }

    @GetMapping("/{moduleId}/difficulty/{difficultyId}/user/{userId}/lesson")
    public ResponseEntity<?> getLessonsByDifficultyLevel(
            @PathVariable Integer moduleId,
            @PathVariable Integer difficultyId,
            @PathVariable UUID userId) {

        return learningModuleService.findLessonsByModuleAndDifficulty(moduleId, difficultyId, userId);
    }

}
