package com.DescomplicandoIngles.DescomplicandoIngles.entities.user;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.FeedBack;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Lesson;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.Progress;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "table_userLessonInteraction")
public class UserLessonInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate completionDate;
    private Integer points;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @OneToOne(mappedBy = "interaction")
    private FeedBack feedBack;

    @OneToOne(mappedBy = "interaction", cascade = CascadeType.ALL)
    private Progress progress;

    public UserLessonInteraction() {
    }

    public UserLessonInteraction(Integer id, User user, Lesson lesson, LocalDate completionDate, FeedBack feedBack, Progress progress, Integer points) {
        this.id = id;
        this.user = user;
        this.lesson = lesson;
        this.completionDate = completionDate;
        this.feedBack = feedBack;
        this.progress = progress;
        this.points = points;
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

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}
