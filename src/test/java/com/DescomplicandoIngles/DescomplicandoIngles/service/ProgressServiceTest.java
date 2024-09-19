package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Progress;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.ProgressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProgressServiceTest {

    @Mock
    private ProgressRepository progressRepository;

    @InjectMocks
    private ProgressService progressService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Se a função upgradeProgress for chamada, o percentual de progresso da lição vai ser incrementado em 20.")
    public void testUpgradeProgress_IncrementBy20() {
        Lesson lesson = new Lesson();
        lesson.setId(1);
        lesson.setTitle("Present simple");
        lesson.setAvailable(true);
        lesson.setStatus("pending");

        Progress progress = new Progress();
        progress.setId(1);
        progress.setPercentual(0);
        progress.setLesson(lesson);

        when(progressRepository.findByLessonId(lesson.getId())).thenReturn(lesson);

        Progress updateProgress = progressService.updateProgress(progress, 20);

        assertEquals(20, updateProgress.getPercentual());
        System.out.print(progress.getPercentual());
    }

}