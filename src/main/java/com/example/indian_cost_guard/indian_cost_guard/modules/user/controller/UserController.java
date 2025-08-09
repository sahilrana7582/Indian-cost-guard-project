package com.example.indian_cost_guard.indian_cost_guard.modules.user.controller;


import com.example.indian_cost_guard.indian_cost_guard.modules.user.dto.NewUserRequest;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.dto.UserResponse;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody NewUserRequest req) {
        return userService.createUser(req);
    }

}
