package com.DescomplicandoIngles.DescomplicandoIngles.dto;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Content;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;

public class LessonDTO {

    private Integer id;
    private String title;
    private String status;
    private Boolean available;
    private Content content;
    private String description;

    public LessonDTO(){

    }

    public LessonDTO(Lesson lesson) {
        this.id = lesson.getId();
        this.title = lesson.getTitle();
        this.content = lesson.getContent();
        this.status = lesson.getStatus();
        this.available = lesson.getAvailable();
        this.description = lesson.getDescription();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
