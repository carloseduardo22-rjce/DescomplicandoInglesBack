package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "table_difficulty_level")
public class DifficultyLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String difficultyLevel;

    @OneToMany(mappedBy = "difficultyLevel")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "learning_module_id")
    private LearningModule learningModule;

    @OneToMany(mappedBy = "difficultyLevel")
    @JsonIgnore
    private List<Lesson> lessons;

    public DifficultyLevel() {

    }

    public DifficultyLevel(Integer id, String name, LearningModule learningModule, List<Lesson> lessons, String difficultyLevel) {
        this.id = id;
        this.name = name;
        this.learningModule = learningModule;
        this.lessons = lessons;
        this.difficultyLevel = difficultyLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LearningModule getModule() {
        return learningModule;
    }

    public void setModule(LearningModule learningModule) {
        this.learningModule = learningModule;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public LearningModule getLearningModule() {
        return learningModule;
    }

    public void setLearningModule(LearningModule learningModule) {
        this.learningModule = learningModule;
    }

}
