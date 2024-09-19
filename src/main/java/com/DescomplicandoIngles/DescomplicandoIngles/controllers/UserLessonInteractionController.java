package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.UserLessonInteraction;
import com.DescomplicandoIngles.DescomplicandoIngles.service.UserLessonInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/UserLessonInteraction")
public class UserLessonInteractionController {

    @Autowired
    private UserLessonInteractionService userLessonInteractionService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserLessonInteraction> userLessonFeedback (@PathVariable Integer id) {
        UserLessonInteraction userLessonInteraction = userLessonInteractionService.findById(id);
        return ResponseEntity.ok().body(userLessonInteraction);
    }

}
