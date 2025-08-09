package com.example.indian_cost_guard.indian_cost_guard.modules.user.mapper;




import com.example.indian_cost_guard.indian_cost_guard.modules.user.dto.NewUserRequest;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.dto.UserResponse;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
public  class UserMapper {

    private UserMapper() {
    }

    public  UserResponse toResponse(User entity) {
        if (entity == null) return null;
        return new UserResponse(
                entity.getId(),
                entity.getUsername(),
                entity.getFullName(),
                entity.getEmail(),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public  List<UserResponse> toResponseList(List<User> entities) {
        if (entities == null) return List.of();
        return entities.stream()
                .filter(Objects::nonNull)
                .map(this::toResponse)
                .collect(Collectors.toList());
    }



    public  User fromNewRequest(NewUserRequest dto) {
        if (dto == null) return null;
        User entity = new User();
        entity.setUsername(dto.username());
        entity.setFullName(dto.fullName());
        entity.setEmail(dto.email());
        entity.setPassword(dto.password());
        entity.setActive(true);
        entity.setCreatedAt(OffsetDateTime.now());
        entity.setUpdatedAt(OffsetDateTime.now());
        return entity;
    }

}

