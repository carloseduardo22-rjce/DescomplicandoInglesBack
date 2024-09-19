package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "table_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "difficulty_level_id")
    private DifficultyLevel difficultyLevel;

    @OneToMany(mappedBy = "user")
    private List<UserLessonInteraction> interactions;

    public User () {

    }

    public User(Integer id, String name, String email, String password, DifficultyLevel difficultyLevel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<UserLessonInteraction> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<UserLessonInteraction> interactions) {
        this.interactions = interactions;
    }

}
