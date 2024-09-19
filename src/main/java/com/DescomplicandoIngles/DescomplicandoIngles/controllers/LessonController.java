package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping
    public List<Lesson> lessonsAvailable() {
        List<Lesson> lessonList = lessonService.findAllAvailables();
        return lessonList;
    }

    @GetMapping(value = "/Start/{id}")
    public Lesson startLesson(@PathVariable Integer id) {
        Lesson lesson = lessonService.startLesson(id);
        return lesson;
    }

    @GetMapping(value = "/CompleteLesson/{id}")
    public Lesson completeLesson(@PathVariable Integer id) {
        Lesson lesson = lessonService.completLesson(id);
        return lesson;
    }

}
