package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.UserLessonInteraction;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserLessonInteractionRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLessonInteractionService {

    @Autowired
    private UserLessonInteractionRepository userLessonInteractionRepository;

    public UserLessonInteraction findById (Integer id) {
        return userLessonInteractionRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("UserLessonInteraction not found!"));
    }

}
