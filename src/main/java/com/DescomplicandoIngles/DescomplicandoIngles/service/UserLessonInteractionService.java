package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.UpdateUserLessonInteractionDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserLessonInteractionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

@Service
public class UserLessonInteractionService {

    private final UserLessonInteractionRepository userLessonInteractionRepository;
    private final UserService userService;
    private final LessonService lessonService;

    public UserLessonInteractionService(UserLessonInteractionRepository userLessonInteractionRepository,
                                       UserService userService,
                                       LessonService lessonService) {
        this.userLessonInteractionRepository = userLessonInteractionRepository;
        this.userService = userService;
        this.lessonService = lessonService;
    }

    @Transactional(readOnly = true)
    public UserLessonInteraction findById (Integer id) {
        return userLessonInteractionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserLessonInteraction not found with id: " + id));
    }

    @Transactional
    public UserLessonInteraction saveUserLessonInteraction(UUID userId, Integer lessonId) {
        User user = userService.findById(userId);
        Lesson lesson = lessonService.findByID(lessonId);

        UserLessonInteraction userLessonInteraction = new UserLessonInteraction();

        userLessonInteraction.setUser(user);
        userLessonInteraction.setLesson(lesson);

        return userLessonInteractionRepository.save(userLessonInteraction);
    }

    @Transactional
    public UserLessonInteraction updateUserLessonInteraction (Integer id, UpdateUserLessonInteractionDTO updateUserLessonInteractionDTO) {
        UserLessonInteraction userLessonInteraction = findById(id);
        
        userLessonInteraction.setPoints(updateUserLessonInteractionDTO.points());
        userLessonInteraction.setCompletionDate(updateUserLessonInteractionDTO.date());
        userLessonInteraction.getLesson().setAvailable(false);

        return this.userLessonInteractionRepository.save(userLessonInteraction);
    }

}
