package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "table_content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "content")
    private Lesson lesson;

    private String audioUrl;
    private String imagemUrl;
    private String text;

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
