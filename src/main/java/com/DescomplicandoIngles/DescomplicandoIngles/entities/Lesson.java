package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
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

    @OneToMany(mappedBy = "lesson")
    @JsonIgnore
    private List<UserLessonInteraction> userLessonInteractions;

    @ManyToOne
    @JoinColumn(name = "difficulty_level_id")
    private DifficultyLevel difficultyLevel;

    public Lesson() {

    }

    public Lesson(Integer id, String title, String status, Boolean available, DifficultyLevel difficultyLevel, Content content, List<UserLessonInteraction> userLessonInteractions, LocalDateTime lessonStart, LocalDateTime lessonEnd, Integer points) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.available = available;
        this.difficultyLevel = difficultyLevel;
        this.content = content;
        this.userLessonInteractions = userLessonInteractions;
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

    public List<UserLessonInteraction> getUserLessonInteractions() {
        return userLessonInteractions;
    }

    public void setUserLessonInteractions(List<UserLessonInteraction> userLessonInteractions) {
        this.userLessonInteractions = userLessonInteractions;
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
