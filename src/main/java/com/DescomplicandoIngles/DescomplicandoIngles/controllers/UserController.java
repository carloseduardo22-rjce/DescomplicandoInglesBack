package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.UpdateUserDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.DifficultyLevel;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.service.DifficultyLevelService;
import com.DescomplicandoIngles.DescomplicandoIngles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DifficultyLevelService difficultyLevelService;

    @PutMapping(value = "/UpdateNameAndNivel/{id}")
    public ResponseEntity updateNameAndNivel (@PathVariable UUID id, @RequestBody UpdateUserDTO userDTO) {
        DifficultyLevel difficultyLevel = difficultyLevelService.findById(userDTO.getIdDifficultyLevel());
        User user = userService.findById(id);

        user.setName(userDTO.getName());
        user.setDifficultyLevel(difficultyLevel);

        userService.saveUser(user);

        return ResponseEntity.ok().build();
    }

}
