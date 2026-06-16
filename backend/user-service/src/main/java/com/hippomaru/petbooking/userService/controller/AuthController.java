package com.hippomaru.petbooking.userService.controller;

import com.hippomaru.petbooking.userService.dto.RegisterRequest;
import com.hippomaru.petbooking.userService.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Valid @RequestBody RegisterRequest req
    ) {
        authService.register(req);
        return ResponseEntity.status(201).build();
    }

}
