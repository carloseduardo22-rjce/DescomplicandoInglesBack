package com.DescomplicandoIngles.DescomplicandoIngles.entities.user;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.Annotation;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.BlockedUser;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.DifficultyLevel;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.Group;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "table_users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String email;
    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserSituation situation;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserLessonInteraction> userLessonInteractions;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "sender")
    private List<Message> messages = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "difficulty_level_id")
    private DifficultyLevel difficultyLevel;

    @ManyToOne
    private BlockedUser blockedUser;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Annotation> annotations;

    @OneToMany(mappedBy = "user")
    private List<UserLessonInteraction> interactions;

    public User () {

    }

    public User (String login, String password, UserRole role, String email, UserSituation situation) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.situation = situation;
    }

    public User(UUID id, String name, String email, DifficultyLevel difficultyLevel, Group group, BlockedUser blockedUser, List<Message> messages, List<UserLessonInteraction> userLessonInteractions, List<Annotation> annotations) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.difficultyLevel = difficultyLevel;
        this.group = group;
        this.blockedUser = blockedUser;
        this.messages = messages;
        this.userLessonInteractions = userLessonInteractions;
        this.annotations = annotations;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER"));
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<UserLessonInteraction> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<UserLessonInteraction> interactions) {
        this.interactions = interactions;
    }

    public UserSituation getSituation() {
        return situation;
    }

    public void setSituation(UserSituation situation) {
        this.situation = situation;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Group getGroups() {
        return group;
    }

    public void setGroups(Group groups) {
        this.group = groups;
    }

    public BlockedUser getBlockedUser() {
        return blockedUser;
    }

    public void setBlockedUser(BlockedUser blockedUser) {
        this.blockedUser = blockedUser;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<UserLessonInteraction> getUserLessonInteractions() {
        return userLessonInteractions;
    }

    public void setUserLessonInteractions(List<UserLessonInteraction> userLessonInteractions) {
        this.userLessonInteractions = userLessonInteractions;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name)
                && Objects.equals(email, user.email)
                && Objects.equals(password, user.password) && Objects.equals(role, user.role)
                && Objects.equals(difficultyLevel, user.difficultyLevel) && Objects.equals(interactions, user.interactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, role, difficultyLevel, interactions);
    }

}
