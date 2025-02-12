package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.UserLessonInteraction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "table_progress")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer percentual = 0;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "interaction_id", referencedColumnName = "id")
    private UserLessonInteraction interaction;

    @OneToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;

    public Progress() {

    }

    public Progress(Integer id, Integer percentual, Lesson lesson, UserLessonInteraction userLessonInteraction) {
        this.id = id;
        this.percentual = percentual;
        this.interaction = userLessonInteraction;
        this.lesson = lesson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPercentual() {
        return percentual;
    }

    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }

    public UserLessonInteraction getInteraction() {
        return interaction;
    }

    public void setInteraction(UserLessonInteraction interaction) {
        this.interaction = interaction;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

}
