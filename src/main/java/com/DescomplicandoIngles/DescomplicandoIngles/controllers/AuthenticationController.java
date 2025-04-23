package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.*;
import com.DescomplicandoIngles.DescomplicandoIngles.infra.security.TokenService;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.EmailService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private EmailService emailService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/Login")
    public ResponseEntity login (@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping(value = "/Register")
    public ResponseEntity register (@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String ecryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        if (data.email().isEmpty()) {
            throw new ValidationException("The object email is obrigatory!");
        }

        User user = new User(data.login(), ecryptedPassword, data.role(), data.email(), UserSituation.PENDING);

        emailService.sendEmailText(user.getEmail(), "Novo usuário cadastrado", "Você está recebendo um e-mail de cadastro");

        User userSaved = this.userRepository.save(user);

        return ResponseEntity.ok().body(userSaved);
    }

}
