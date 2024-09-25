package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "table_lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String status;
    Boolean available;
    LocalDateTime lessonStart;
    LocalDateTime lessonEnd;
    Integer points;

    @OneToOne
    @JoinColumn(name = "feedback_id")
    private FeedBack feedback;

    @OneToOne
    @JoinColumn(name = "content_id")
    private Content content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "lesson")
    @JsonIgnore
    private Progress progress;

    @ManyToOne
    @JoinColumn(name = "difficulty_level_id")
    private DifficultyLevel difficultyLevel;

    public Lesson() {

    }

    public Lesson(Integer id, String title, String status, Boolean available, Progress progress, DifficultyLevel difficultyLevel, Content content, User user, LocalDateTime lessonStart, LocalDateTime lessonEnd, Integer points) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.available = available;
        this.progress = progress;
        this.difficultyLevel = difficultyLevel;
        this.content = content;
        this.user = user;
        this.lessonStart = lessonStart;
        this.lessonEnd = lessonEnd;
        this.points = points;
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

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLessonStart() {
        return lessonStart;
    }

    public void setLessonStart(LocalDateTime lessonStart) {
        this.lessonStart = lessonStart;
    }

    public LocalDateTime getLessonEnd() {
        return lessonEnd;
    }

    public void setLessonEnd(LocalDateTime lessonEnd) {
        this.lessonEnd = lessonEnd;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public FeedBack getFeedback() {
        return feedback;
    }

    public void setFeedback(FeedBack feedback) {
        this.feedback = feedback;
    }
}
