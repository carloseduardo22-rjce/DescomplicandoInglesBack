package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "table_userLessonInteraction")
public class UserLessonInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    private LocalDate completionDate;

    @OneToOne(mappedBy = "interaction")
    private FeedBack feedBack;

    public UserLessonInteraction() {
    }

    public UserLessonInteraction(Integer id, User user, Lesson lesson, LocalDate completionDate, FeedBack feedBack) {
        this.id = id;
        this.user = user;
        this.lesson = lesson;
        this.completionDate = completionDate;
        this.feedBack = feedBack;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public FeedBack getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(FeedBack feedBack) {
        this.feedBack = feedBack;
    }
}
