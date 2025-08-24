package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.ReportDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserLessonInteractionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final UserService userService;
    private final UserLessonInteractionRepository userLessonInteractionRepository;

    public ReportService(UserService userService, UserLessonInteractionRepository userLessonInteractionRepository) {
        this.userService = userService;
        this.userLessonInteractionRepository = userLessonInteractionRepository;
    }

    @Transactional(readOnly = true)
    public ReportDTO findByReport(UUID id) {
        User user = userService.findById(id);

        List<UserLessonInteraction> userLessonInteractions = userLessonInteractionRepository.findByUser(user);

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
