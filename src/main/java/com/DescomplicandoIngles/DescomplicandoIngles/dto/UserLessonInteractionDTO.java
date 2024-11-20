package com.DescomplicandoIngles.DescomplicandoIngles.dto;

import java.util.UUID;

public class UserLessonInteractionDTO {

    private UUID userId;
    private Integer lessonId;

    public UserLessonInteractionDTO(){
    }

    public UserLessonInteractionDTO(UUID userId, Integer id) {
        this.userId = userId;
        this.lessonId = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }
}
