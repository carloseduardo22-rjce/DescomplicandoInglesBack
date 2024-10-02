package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.ReportDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.LessonRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserLessonInteractionRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.NoLessonNotFound;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserLessonInteractionRepository userLessonInteractionRepository;

    public ReportDTO findByReport(UUID id) {
        User user = userService.findById(id);

        List<UserLessonInteraction> userLessonInteractions = userLessonInteractionRepository.findByUser(user);

        if (userLessonInteractions.isEmpty()) {
            throw new NoLessonNotFound("Não tem como puxar relatório porque não tem lição disponível.");
        }

        List<Lesson> lessons = userLessonInteractions.stream()
                .map(UserLessonInteraction::getLesson)
                .collect(Collectors.toList());

        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setUser(user);
        reportDTO.setTitle("Relatório de atividades feitas com seus progressos.");
        reportDTO.setLessonList(lessons);

        return reportDTO;
    }
}
