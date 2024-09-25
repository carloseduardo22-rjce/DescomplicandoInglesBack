package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.FeedBack;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.LessonRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import jdk.jfr.Timespan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public Lesson findByID (Integer id) {
        Optional<Lesson> optionalLesson = lessonRepository.findById(id);
        return optionalLesson.orElseThrow(() -> new ObjectNotFoundException("Lesson not found!"));
    }

    public List<Lesson> findAllAvailables() {
        return lessonRepository.findAvailableLessons();
    }

    public Lesson startLesson(Integer id) {
        try {
            Lesson lesson = findByID(id);
            lesson.setStatus("pending");
            lesson.setLessonStart(LocalDateTime.now());
            return lesson;
        }
        catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException(e.getMessage());
        }
    }

    public Lesson completLesson(Integer id) {
        try {
            Lesson lesson = findByID(id);
            lesson.setAvailable(false);
            lesson.setStatus("completed");
            lesson.setLessonEnd(LocalDateTime.now());
            return lesson;
        }
        catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException(e.getMessage());
        }
    }
}


