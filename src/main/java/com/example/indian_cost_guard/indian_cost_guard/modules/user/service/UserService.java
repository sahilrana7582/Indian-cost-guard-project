package com.example.indian_cost_guard.indian_cost_guard.modules.user.service;

import com.example.indian_cost_guard.indian_cost_guard.modules.user.dto.NewUserRequest;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.dto.UserResponse;

public interface UserService {
    UserResponse createUser(NewUserRequest request);
}
