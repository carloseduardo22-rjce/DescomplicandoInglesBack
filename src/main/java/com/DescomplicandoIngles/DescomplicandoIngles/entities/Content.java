package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "table_content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String audioUrl;
    private String imagemUrl;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @OneToOne(mappedBy = "content")
    @JsonIgnore
    private Lesson lesson;

    public Content () {
    }

    public Content(Integer id, Lesson lesson, String audioUrl, String imagemUrl, String text) {
        this.id = id;
        this.lesson = lesson;
        this.audioUrl = audioUrl;
        this.imagemUrl = imagemUrl;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return Objects.equals(id, content.id) && Objects.equals(lesson, content.lesson) && Objects.equals(audioUrl, content.audioUrl) && Objects.equals(imagemUrl, content.imagemUrl) && Objects.equals(text, content.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lesson, audioUrl, imagemUrl, text);
    }

    @Override
    public String toString() {
        return "Content {" +
                "id=" + id +
                ", lesson=" + lesson +
                ", audioUrl='" + audioUrl + '\'' +
                ", imagemUrl='" + imagemUrl + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

}
