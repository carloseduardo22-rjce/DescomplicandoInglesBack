package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Progress;
import com.DescomplicandoIngles.DescomplicandoIngles.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @GetMapping(value = "/{id}")
    public void updateProgress (@PathVariable Integer id) {
        Progress progress = progressService.findById(id);
        int increment = 20;
        progressService.updateProgress(progress, increment);
    }

}
