package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.Group;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.GroupRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Group> findById (@PathVariable Integer id) {
        return ResponseEntity.ok().body(groupService.findById(id));
    }

}
