package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.UpdateUserDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.DifficultyLevel;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.service.DifficultyLevelService;
import com.DescomplicandoIngles.DescomplicandoIngles.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private final UserService userService;
    private final DifficultyLevelService difficultyLevelService;

    public UserController (UserService userService, DifficultyLevelService difficultyLevelService) {
        this.userService = userService;
        this.difficultyLevelService = difficultyLevelService;
    }

    @PutMapping(value = "/updateNameAndLevel/{id}")
    public ResponseEntity updateNameAndLevel (@PathVariable UUID id, @RequestBody UpdateUserDTO userDTO) {
        DifficultyLevel difficultyLevel = difficultyLevelService.findById(userDTO.getIdDifficultyLevel());
        User user = userService.findById(id);

        user.setName(userDTO.getName());
        user.setDifficultyLevel(difficultyLevel);

        User userUpdated = userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.OK).body(userUpdated);
    }

}
