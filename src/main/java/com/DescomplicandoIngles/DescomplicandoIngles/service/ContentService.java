package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Content;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.ContentRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public Content findById (Integer id) {
        return contentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Content not found!"));
    }

}
