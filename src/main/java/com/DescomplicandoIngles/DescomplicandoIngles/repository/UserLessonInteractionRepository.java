package com.DescomplicandoIngles.DescomplicandoIngles.repository;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLessonInteractionRepository extends JpaRepository<UserLessonInteraction, Integer> {

    List<UserLessonInteraction> findByUser(User user);

}
