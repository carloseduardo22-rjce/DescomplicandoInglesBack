package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.LessonRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserLessonInteractionRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final UserLessonInteractionRepository userLessonInteractionRepository;

    public LessonService(LessonRepository lessonRepository, 
                        UserLessonInteractionRepository userLessonInteractionRepository) {
        this.lessonRepository = lessonRepository;
        this.userLessonInteractionRepository = userLessonInteractionRepository;
    }

    public Lesson findByID (Integer id) {
        Optional<Lesson> optionalLesson = lessonRepository.findById(id);
        return optionalLesson.orElseThrow(() -> new EntityNotFoundException("Lesson not found with id: " + id));
    }

    public Lesson startLesson(Integer id) {
        Lesson lesson = findByID(id);
        lesson.setStatus("pending");
        return lessonRepository.save(lesson);
    }

    public Lesson completeLesson(Integer id) {
        Lesson lesson = findByID(id);
        lesson.setAvailable(false);
        lesson.setStatus("completed");
        return lessonRepository.save(lesson);
    }

    public List<Lesson> findAllAvailables() {
        return lessonRepository.findAvailableLessons();
    }

    public List<Lesson> findLessonsByUser(User user) {
        List<UserLessonInteraction> interactions = userLessonInteractionRepository.findByUser(user);
        return interactions.stream()
                .map(UserLessonInteraction::getLesson)
                .collect(Collectors.toList());
    }
    
}


