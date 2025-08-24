package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Content;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.ContentRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Content findById(Integer id) {
        return contentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Content not found with id: " + id));
    }

}
