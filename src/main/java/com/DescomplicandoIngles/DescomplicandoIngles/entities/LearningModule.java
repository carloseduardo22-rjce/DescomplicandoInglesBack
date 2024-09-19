package com.DescomplicandoIngles.DescomplicandoIngles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "table_learning_module")
public class LearningModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Boolean inMaintenance;

    @OneToMany(mappedBy = "learningModule")
    @JsonIgnore
    private List<DifficultyLevel> difficultyLevels;

    public LearningModule(){

    }

    public LearningModule(Integer id, String name, String description, List<DifficultyLevel> difficultyLevels, Boolean inMaintenance) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficultyLevels = difficultyLevels;
        this.inMaintenance = inMaintenance;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DifficultyLevel> getDifficultyLevels() {
        return difficultyLevels;
    }

    public void setDifficultyLevels(List<DifficultyLevel> difficultyLevels) {
        this.difficultyLevels = difficultyLevels;
    }

    public Boolean getInMaintenance() {
        return inMaintenance;
    }

    public void setInMaintenance(Boolean inMaintenance) {
        this.inMaintenance = inMaintenance;
    }

}
