package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.service.LessonService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/lesson")
public class LessonController {

    private final LessonService lessonService;

    public LessonController (LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public ResponseEntity<List<Lesson>> lessonsAvailable() {
        return ResponseEntity.status(HttpStatus.OK).body(lessonService.findAllAvailables());
    }

    @PostMapping(value = "/start/{id}")
    public ResponseEntity<Lesson> startLesson(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(lessonService.startLesson(id));
    }

    @PatchMapping(value = "/lesson/{id}")
    public ResponseEntity<Lesson> completeLesson(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(lessonService.completeLesson(id));
    }

}
