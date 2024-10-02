package com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.DifficultyLevel;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "table_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameGroup;

    @OneToMany
    @JoinColumn(name = "moderator_id")
    private List<User> moderators = new ArrayList<>();

    @OneToMany(mappedBy = "group")
    private List<Message> messages = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "difficultyLevel_id")
    private DifficultyLevel difficultyLevel;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> user = new ArrayList<>();

    public Group(){

    }

    public Group(Integer id, String nameGroup, DifficultyLevel difficultyLevel, List<User> user, List<User> moderators, List<Message> messages) {
        this.id = id;
        this.nameGroup = nameGroup;
        this.difficultyLevel = difficultyLevel;
        this.user = user;
        this.moderators = moderators;
        this.messages = messages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<User> getModerators() {
        return moderators;
    }

    public void setModerators(List<User> moderators) {
        this.moderators = moderators;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
