package com.hippomaru.petbooking.userService.exception;

public class UserCreationException extends RuntimeException {
    public UserCreationException() {
        super("User creation failed");
    }
}
