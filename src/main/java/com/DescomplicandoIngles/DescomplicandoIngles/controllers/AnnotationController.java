package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Annotation;
import com.DescomplicandoIngles.DescomplicandoIngles.service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/Annotation")
public class AnnotationController {

    @Autowired
    private AnnotationService annotationService;

    @PostMapping(value = "/NewAnnotation")
    public ResponseEntity<Annotation> saveAnnotation (@RequestBody Annotation annotation) {
        return ResponseEntity.ok().body(annotationService.saveAnnotation(annotation));
    }

    @GetMapping(value = "/User/{id}")
    public ResponseEntity<List<Annotation>> findListAnnotationsUser (@PathVariable UUID id) {
        return ResponseEntity.ok().body(annotationService.findListAnnotationsUser(id));
    }

}
