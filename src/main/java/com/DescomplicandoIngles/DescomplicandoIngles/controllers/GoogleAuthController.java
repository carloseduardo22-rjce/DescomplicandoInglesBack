package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DescomplicandoIngles.DescomplicandoIngles.infra.security.GoogleTokenVerifier;

@RestController
@RequestMapping(value = "/api/v1/authentication")
public class GoogleAuthController {

	private final GoogleTokenVerifier googleTokenVerifier;
	
	public GoogleAuthController(GoogleTokenVerifier googleTokenVerifier) {
		this.googleTokenVerifier = googleTokenVerifier;
	}

	@PostMapping(value = "/google")
	public ResponseEntity<?> loginWithGoogle (@RequestBody Map<String, String> body) {
		try {
			this.googleTokenVerifier.verifyToken(body.get("idCredential"));
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
