package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.AuthenticationDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.LoginResponseDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.RegisterDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.infra.security.TokenService;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserRepository;
import jakarta.validation.Valid;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/Login")
    public ResponseEntity login (@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        // autenticar usuário e senha
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping(value = "/Register")
    public ResponseEntity register (@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String ecryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        // nome, email, login, password, role
        User user = new User(data.login(), ecryptedPassword, data.role());

        User userSaved = this.userRepository.save(user);

        return ResponseEntity.ok().body(userSaved);
    }

}
