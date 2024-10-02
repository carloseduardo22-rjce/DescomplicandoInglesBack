package com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "table_blocked_user")
public class BlockedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime lockDateAndTime;
    private String description;

    @OneToMany
    @JoinColumn(name = "blocked_user_id")
    private List<User> user = new ArrayList<>();

    public BlockedUser(){

    }

    public BlockedUser(Integer id, List<User> user, LocalDateTime lockDateAndTime, String decription) {
        this.id = id;
        this.user = user;
        this.lockDateAndTime = lockDateAndTime;
        this.description = decription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public LocalDateTime getLockDateAndTime() {
        return lockDateAndTime;
    }

    public void setLockDateAndTime(LocalDateTime lockDateAndTime) {
        this.lockDateAndTime = lockDateAndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
