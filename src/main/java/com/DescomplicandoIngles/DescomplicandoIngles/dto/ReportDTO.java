package com.DescomplicandoIngles.DescomplicandoIngles.dto;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;

import java.util.List;

public class ReportDTO {

    private String title;
    private User user;
    private List<Lesson> lessonList;

    public ReportDTO () {

    }

    public ReportDTO(String title, User user, List<Lesson> lessonList) {
        this.title = title;
        this.user = user;
        this.lessonList = lessonList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }
}
