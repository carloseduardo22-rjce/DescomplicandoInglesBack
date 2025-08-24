package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.user.User;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User saveUser (User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById (UUID id) {
        return userRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException("User not found with id: " + id)
        );
    }

}
