package com.DescomplicandoIngles.DescomplicandoIngles.infra.security;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("$api.security.token.secret")

    private String secret;

    public String generateToken (User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("descomplicandoIngles-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        }
        catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generatin token", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("descomplicandoIngles-api")
                    .build()
                    .verify(token)
                    // O subject geralmente é usado para armazenar o identificador principal do usuário ou entidade associada ao token (como um ID de usuário).
                    .getSubject();
        }
        catch (JWTVerificationException exception) {
            return "";
        }
    }


    // Informando ao Java que o tempo local está 3 horas atrás do UTC usando ZoneOffset.of("-03:00").
    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
