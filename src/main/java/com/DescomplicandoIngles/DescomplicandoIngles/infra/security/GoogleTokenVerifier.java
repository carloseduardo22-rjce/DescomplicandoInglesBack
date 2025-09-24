package com.DescomplicandoIngles.DescomplicandoIngles.infra.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

@Service
public class GoogleTokenVerifier {

	private final UserRepository userRepository;
	private final UserService userService;
	private final TokenService tokenService;
	private static final String client_id = "133167602528-v2m3cv3uu8mhqro2res2kgc4ma84m4eg.apps.googleusercontent.com";
	private static final JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
	
	public GoogleTokenVerifier(UserRepository userRepository, UserService userService, TokenService tokenService) {
		this.userRepository = userRepository;
		this.userService = userService;
		this.tokenService = tokenService;
	}

	public GoogleIdToken.Payload verifyToken (String idToken) throws Exception {
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), jsonFactory)
                .setAudience(Collections.singletonList(client_id)) 
                .build();
				
		GoogleIdToken googleIdToken = verifier.verify(idToken);
		if (googleIdToken != null) {
			GoogleIdToken.Payload payload =	googleIdToken.getPayload();
			String email = (String) payload.getEmail();
			String name = (String) payload.get("name");
			String pictureUrl = (String) payload.get("picture");
			Optional<User> optionalUser = userRepository.findByEmail(email);
			if (optionalUser.isEmpty()) {
				User user = new User(name, email);
				User userSaved = userService.saveUser(user);
				tokenService.generateToken(userSaved);
			}
		} 
		
		return null;
		
	}
	
}
