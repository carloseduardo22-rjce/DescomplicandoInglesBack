package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Annotation;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.AnnotationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AnnotationService {

    private final AnnotationRepository annotationRepository;
    private final UserService userService;

    public AnnotationService(AnnotationRepository annotationRepository, UserService userService) {
        this.annotationRepository = annotationRepository;
        this.userService = userService;
    }

    @Transactional
    public Annotation saveAnnotation(Annotation annotation) {
        Annotation newAnnotation = new Annotation();
        newAnnotation.setContent(annotation.getContent());

        if (annotation.getUser() != null) {
            newAnnotation.setUser(annotation.getUser());
        } else {
            throw new RuntimeException("Usuário não encontrado na anotação.");
        }
        return annotationRepository.save(newAnnotation);
    }

    @Transactional(readOnly = true)
    public List<Annotation> findListAnnotationsUser (UUID id) {
        return annotationRepository.findByUser(userService.findById(id));
    }

}
