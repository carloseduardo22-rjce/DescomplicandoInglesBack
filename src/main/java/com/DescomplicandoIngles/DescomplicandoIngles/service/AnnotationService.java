package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Annotation;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.AnnotationRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnnotationService {

    @Autowired
    private AnnotationRepository annotationRepository;

    @Autowired
    private UserService userService;

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

    public List<Annotation> findListAnnotationsUser (UUID id) {
        return annotationRepository.findByUser(userService.findById(id));
    }

}
