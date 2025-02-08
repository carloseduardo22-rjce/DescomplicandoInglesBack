package com.DescomplicandoIngles.DescomplicandoIngles.entities.user;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "table_pending_user")
public class PendingUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String token;
    private LocalDateTime createAt;
    private LocalDateTime expiredAt;

    public PendingUser () {

    }

    public PendingUser(Integer id, String name, String email, String token, LocalDateTime createAt, LocalDateTime expiredAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.token = token;
        this.createAt = createAt;
        this.expiredAt = expiredAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }
}
