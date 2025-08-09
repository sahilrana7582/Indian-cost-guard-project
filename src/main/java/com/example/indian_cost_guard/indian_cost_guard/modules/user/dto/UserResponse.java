package com.example.indian_cost_guard.indian_cost_guard.modules.user.dto;


import java.time.OffsetDateTime;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String fullName,
        String email,
        boolean active,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {}