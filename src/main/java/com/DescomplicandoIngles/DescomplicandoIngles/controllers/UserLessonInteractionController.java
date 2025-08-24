package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.UpdateUserLessonInteractionDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.dto.UserLessonInteractionDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import com.DescomplicandoIngles.DescomplicandoIngles.service.UserLessonInteractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/userLessonInteraction")
public class UserLessonInteractionController {

    private final UserLessonInteractionService userLessonInteractionService;

    public UserLessonInteractionController (UserLessonInteractionService userLessonInteractionService) {
        this.userLessonInteractionService = userLessonInteractionService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserLessonInteraction> userLessonFeedback (@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(userLessonInteractionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserLessonInteraction> createUserLessonInteraction (@RequestBody UserLessonInteractionDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userLessonInteractionService.saveUserLessonInteraction(data.getUserId(), data.getLessonId()));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateUserLessonInteraction (@PathVariable Integer id, @RequestBody UpdateUserLessonInteractionDTO updateUserLessonInteraction) {
        UserLessonInteraction userLessonInteraction = userLessonInteractionService.updateUserLessonInteraction(id, updateUserLessonInteraction);
        return ResponseEntity.status(HttpStatus.OK).body(userLessonInteraction);
    }

}
