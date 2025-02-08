package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.UpdateUserLessonInteractionDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.dto.UserLessonInteractionDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserLessonInteractionRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserLessonInteractionService {

    @Autowired
    private UserLessonInteractionRepository userLessonInteractionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private LessonService lessonService;

    public UserLessonInteraction findById (Integer id) {
        return userLessonInteractionRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("UserLessonInteraction not found!"));
    }

    public UserLessonInteraction saveUserLessonInteraction(UUID userId, Integer lessonId) {
        User user = userService.findById(userId);
        Lesson lesson = lessonService.findByID(lessonId);

        UserLessonInteraction userLessonInteraction = new UserLessonInteraction();

        userLessonInteraction.setUser(user);
        userLessonInteraction.setLesson(lesson);

        return userLessonInteractionRepository.save(userLessonInteraction);
    }

    public void updateUserLessonInteraction (Integer id, UpdateUserLessonInteractionDTO updateUserLessonInteractionDTO) {
        UserLessonInteraction userLessonInteraction = userLessonInteractionRepository.
                findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
        
        userLessonInteraction.setPoints(updateUserLessonInteractionDTO.points());
        userLessonInteraction.setCompletionDate(updateUserLessonInteractionDTO.date());
        userLessonInteraction.getLesson().setAvailable(false);

        this.userLessonInteractionRepository.save(userLessonInteraction);
    }

}
