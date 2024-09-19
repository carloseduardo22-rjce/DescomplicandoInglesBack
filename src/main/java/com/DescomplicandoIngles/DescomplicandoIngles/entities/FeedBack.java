package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "table _feedback")
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String message;
    private Integer score;
    private Long responseTime;
    private Boolean correctness;

    @OneToOne
    @JoinColumn(name = "interaction_id")
    private UserLessonInteraction interaction;

    public FeedBack() {

    }

    public FeedBack(Integer id, String message, Integer score, Long responseTime, Boolean correctness, UserLessonInteraction interaction) {
        this.id = id;
        this.message = message;
        this.score = score;
        this.responseTime = responseTime;
        this.correctness = correctness;
        this.interaction = interaction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public Boolean getCorrectness() {
        return correctness;
    }

    public void setCorrectness(Boolean correctness) {
        this.correctness = correctness;
    }

    public UserLessonInteraction getInteraction() {
        return interaction;
    }

    public void setInteraction(UserLessonInteraction interaction) {
        this.interaction = interaction;
    }

}
