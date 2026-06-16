package com.hippomaru.petbooking.userService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email address")
        String email,

        @NotBlank(message = "Password cannot be blank")
        @Size(min = 8, max = 128, message = "Passwords length must be between 8 and 128 symbols")
        String password
) {}
