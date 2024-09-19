package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.ReportDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.User;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.LessonRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.NoLessonNotFound;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public ReportDTO findByReport (Integer id) {
            Optional<User> optionalUser = userRepository.findById(id);
            User user = optionalUser.orElseThrow(() -> new ObjectNotFoundException("User not found!"));

            List<Lesson> lesson = lessonRepository.findByUser(user);

            if (lesson.isEmpty()) {
                throw new NoLessonNotFound("Não tem como puxar relatório porque não tem lição disponível.");
            }

            ReportDTO reportDTO = new ReportDTO();
            reportDTO.setUser(user);
            reportDTO.setTitle("Relatório de atividades feitas com seus progressos.");
            reportDTO.setLessonList(lesson);

            return reportDTO;
    }

}
