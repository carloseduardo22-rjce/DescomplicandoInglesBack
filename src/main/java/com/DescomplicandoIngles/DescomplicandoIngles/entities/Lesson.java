package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "table_lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String status;
    private Boolean available = true;
    private String description;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

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

    public Lesson(Integer id, String title, String status, Boolean available, DifficultyLevel difficultyLevel, Content content, List<UserLessonInteraction> userLessonInteractions,
                  Topic topic, String description) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.available = available;
        this.difficultyLevel = difficultyLevel;
        this.content = content;
        this.userLessonInteractions = userLessonInteractions;
        this.topic = topic;
        this.description = description;
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
