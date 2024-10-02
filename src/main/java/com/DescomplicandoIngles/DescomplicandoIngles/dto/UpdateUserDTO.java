package com.DescomplicandoIngles.DescomplicandoIngles.dto;

public class UpdateUserDTO {

    private String name;
    private Integer idDifficultyLevel;

    public UpdateUserDTO() {

    }

    public UpdateUserDTO(String name, Integer idDifficultyLevel) {
        this.name = name;
        this.idDifficultyLevel = idDifficultyLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdDifficultyLevel() {
        return idDifficultyLevel;
    }

    public void setIdDifficultyLevel(Integer idDifficultyLevel) {
        this.idDifficultyLevel = idDifficultyLevel;
    }

}
