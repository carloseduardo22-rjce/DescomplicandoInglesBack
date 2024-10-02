package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.DifficultyLevel;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.DifficultyLevelRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DifficultyLevelService {

    @Autowired
    private DifficultyLevelRepository difficultyLevelRepository;
    
    public DifficultyLevel findById (Integer id) {
        return difficultyLevelRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object DifficultyLevel not found!"));
    }

}
