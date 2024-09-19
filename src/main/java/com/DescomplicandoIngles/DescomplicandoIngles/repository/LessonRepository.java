package com.DescomplicandoIngles.DescomplicandoIngles.repository;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findByUser(User user);

    @Query("SELECT L FROM Lesson L where L.available = true")
    List<Lesson> findAvailableLessons();

}
