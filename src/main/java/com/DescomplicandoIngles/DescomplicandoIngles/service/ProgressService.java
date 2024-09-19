package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Progress;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.ProgressRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public Progress findById (Integer id) {
        Optional<Progress> progress = progressRepository.findById(id);
        return progress.orElseThrow(() -> new ObjectNotFoundException("Progress not found!"));
    }

    public Progress updateProgress(Progress progress, int increment) {
        int newPercentual = progress.getPercentual() + increment;

        if (newPercentual > 100) {
            newPercentual = 100;
        }

        progress.setPercentual(newPercentual);
        progressRepository.save(progress);


        return progress;
    }

}
