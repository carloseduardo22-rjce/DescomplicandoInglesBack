package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Progress;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.LessonRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.ProgressRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private LessonService lessonService;

    public Progress findById (Integer id) {
        Lesson lesson = lessonService.findByID(id);
        return progressRepository.findByLesson(lesson);
    }

    public Progress updateProgress(Progress progress, int increment) {
        int newPercentual = progress.getPercentual() + increment;

        if (newPercentual > 100) {
            newPercentual = 100;
        }

        progress.setPercentual(newPercentual);
        progressRepository.save(progress);


        return progress;
    }

}
