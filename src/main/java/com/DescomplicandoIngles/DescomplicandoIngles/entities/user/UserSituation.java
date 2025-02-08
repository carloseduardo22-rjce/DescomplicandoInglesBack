package com.DescomplicandoIngles.DescomplicandoIngles.entities.user;

public enum UserSituation {

    PENDING("pending"),
    CONFIRMED("confirmed");

    private String situation;

    UserSituation (String situation) {
        this.situation = situation;
    }

    public String getSituation() {
        return situation;
    }

}
