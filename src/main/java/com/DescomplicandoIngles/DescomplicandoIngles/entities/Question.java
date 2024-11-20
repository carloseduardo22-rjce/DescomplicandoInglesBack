package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "table_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    @Column(name = "question_text")
    private String text;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alternative> alternatives;

    @ManyToOne
    @JoinColumn(name = "content_id")
    @JsonIgnore
    private Content content;

    public Question(){

    }

    public Question(Integer id, Integer number, String text, List<Alternative> alternatives, Content content) {
        this.id = id;
        this.number = number;
        this.text = text;
        this.alternatives = alternatives;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

}
