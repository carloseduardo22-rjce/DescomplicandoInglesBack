package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "table_alternative")
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    @JsonIgnore
    private Question question;

    private String text;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    public Alternative(){

    }

    public Alternative(Integer id, Question question, String text, Boolean isCorrect) {
        this.id = id;
        this.question = question;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
