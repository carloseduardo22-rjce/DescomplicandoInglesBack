package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.DifficultyLevel;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.DifficultyLevelRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DifficultyLevelService {

    private final DifficultyLevelRepository difficultyLevelRepository;

    public DifficultyLevelService(DifficultyLevelRepository difficultyLevelRepository) {
        this.difficultyLevelRepository = difficultyLevelRepository;
    }
    
    public DifficultyLevel findById (Integer id) {
        return difficultyLevelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DifficultyLevel not found with id: " + id));
    }

}
