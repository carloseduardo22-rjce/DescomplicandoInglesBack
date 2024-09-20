package com.DescomplicandoIngles.DescomplicandoIngles.dto;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Content;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;

public class LessonDTO {
    private Integer id;
    private String title;
    private Content content;

    public LessonDTO(){

    }

    public LessonDTO(Lesson lesson) {
        this.id = lesson.getId();
        this.title = lesson.getTitle();
        this.content = lesson.getContent();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

}
