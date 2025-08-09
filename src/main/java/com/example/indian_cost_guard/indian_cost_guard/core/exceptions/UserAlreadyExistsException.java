package com.example.indian_cost_guard.indian_cost_guard.core.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    private final String code;

    public UserAlreadyExistsException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}