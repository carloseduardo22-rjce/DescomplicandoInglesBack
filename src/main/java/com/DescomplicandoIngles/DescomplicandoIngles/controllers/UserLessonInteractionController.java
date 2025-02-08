package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.UpdateUserLessonInteractionDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.dto.UserLessonInteractionDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import com.DescomplicandoIngles.DescomplicandoIngles.service.UserLessonInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/UserLessonInteraction")
public class UserLessonInteractionController {

    @Autowired
    private UserLessonInteractionService userLessonInteractionService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserLessonInteraction> userLessonFeedback (@PathVariable Integer id) {
        return ResponseEntity.ok().body(userLessonInteractionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserLessonInteraction> createUserLessonInteraction (@RequestBody UserLessonInteractionDTO data) {
        return ResponseEntity.ok().body(this.userLessonInteractionService.saveUserLessonInteraction(data.getUserId(), data.getLessonId()));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateUserLessonInteraction (@PathVariable Integer id, @RequestBody UpdateUserLessonInteractionDTO updateUserLessonInteraction) {
        this.userLessonInteractionService.updateUserLessonInteraction(id, updateUserLessonInteraction);
        return ResponseEntity.ok().build();
    }

}
