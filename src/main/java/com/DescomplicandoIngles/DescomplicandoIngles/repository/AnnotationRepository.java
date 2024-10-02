package com.DescomplicandoIngles.DescomplicandoIngles.repository;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Annotation;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Integer> {
    List<Annotation> findByUser(User user);
}
