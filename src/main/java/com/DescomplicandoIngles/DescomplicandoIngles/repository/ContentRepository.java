package com.DescomplicandoIngles.DescomplicandoIngles.repository;


import com.DescomplicandoIngles.DescomplicandoIngles.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
}
