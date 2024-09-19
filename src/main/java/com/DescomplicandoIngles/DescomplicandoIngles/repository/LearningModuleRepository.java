package com.DescomplicandoIngles.DescomplicandoIngles.repository;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.LearningModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningModuleRepository extends JpaRepository<LearningModule, Integer> {

}
