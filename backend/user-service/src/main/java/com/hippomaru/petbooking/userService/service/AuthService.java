package com.hippomaru.petbooking.userService.service;

import com.hippomaru.petbooking.userService.domain.Role;
import com.hippomaru.petbooking.userService.domain.User;
import com.hippomaru.petbooking.userService.dto.RegisterRequest;
import com.hippomaru.petbooking.userService.exception.UserCreationException;
import com.hippomaru.petbooking.userService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequest req) throws UserCreationException {

        User newUser = createUserFromDto(req);
        try {
            userRepo.save(newUser);
        } catch (DataIntegrityViolationException e) {
            throw new UserCreationException();
        }
    }



    private User createUserFromDto(RegisterRequest req) {
        return User.builder()
                .email(req.email())
                .passwordHash(passwordEncoder.encode(req.password()))
                .role(Role.USER)
                .createdAt(Instant.now())
                .build();
    }
}
