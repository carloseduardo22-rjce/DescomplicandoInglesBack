package com.DescomplicandoIngles.DescomplicandoIngles.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@Profile("test")
public class ProductionSecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
         httpSecurity
                 .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)  // Continua desabilitando CSRF para facilitar testes via Postman
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // Sessão stateless - não guarda as informações
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/Authentication/Login").permitAll() // Permiti que todos os usuarios possam acessar a rota de login mesmo não autenticado
                        .requestMatchers(HttpMethod.POST, "/Authentication/Register").permitAll()
                        .requestMatchers(HttpMethod.GET,"/LearningModule/{moduleId}/difficulty/{difficultyId}/user/{userId}/lesson").hasRole("USER") // Permite acesso às rotas especificadas
                        .anyRequest().authenticated()  // Autenticação para outras rotas
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
         httpSecurity.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
         return httpSecurity.build();
    }

    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");  // Permite seu frontend do Angular
        config.addAllowedHeader("*");  // Permite todos os cabeçalhos
        config.addAllowedMethod("*");  // Permite todos os métodos (POST, GET, etc.)
        source.registerCorsConfiguration("/**", config);  // Aplica a configuração para todas as rotas
        return source;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // método para criptografar a senha do usuário
    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

}
