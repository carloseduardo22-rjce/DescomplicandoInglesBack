package com.DescomplicandoIngles.DescomplicandoIngles.entities.user;

public record RegisterDTO(String login, String password, String email, UserRole role) {
}
