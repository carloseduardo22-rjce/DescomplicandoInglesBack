package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Annotation;
import com.DescomplicandoIngles.DescomplicandoIngles.service.AnnotationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/annotation")
public class AnnotationController {

    private final AnnotationService annotationService;

    public AnnotationController(AnnotationService annotationService) {
        this.annotationService = annotationService;
    }

    @PostMapping
    public ResponseEntity<Annotation> saveAnnotation (@RequestBody Annotation annotation) {
        Annotation savedAnnotation = annotationService.saveAnnotation(annotation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAnnotation);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Annotation>> findListAnnotationsUser (@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(annotationService.findListAnnotationsUser(id));
    }

}
