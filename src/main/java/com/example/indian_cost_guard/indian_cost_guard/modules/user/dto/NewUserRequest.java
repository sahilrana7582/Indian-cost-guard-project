package com.example.indian_cost_guard.indian_cost_guard.modules.user.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record NewUserRequest(
        @NotBlank @Size(min = 3, max = 50)
        String username,
        String fullName,
        @Email String email,
        @NotBlank @Size(min = 8, max = 128) String password
) {}
