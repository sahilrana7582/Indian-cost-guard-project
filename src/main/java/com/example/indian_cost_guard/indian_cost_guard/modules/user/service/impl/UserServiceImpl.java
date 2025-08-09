package com.example.indian_cost_guard.indian_cost_guard.modules.user.service.impl;

import com.example.indian_cost_guard.indian_cost_guard.core.exceptions.UserAlreadyExistsException;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.dto.NewUserRequest;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.dto.UserResponse;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.mapper.UserMapper;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.model.User;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.repository.UserRepository;
import com.example.indian_cost_guard.indian_cost_guard.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;  // works now

    @Override
    public UserResponse createUser(NewUserRequest request) {
        if(userRepository.findByUsername(request.username()).isPresent() || userRepository.findByEmail(request.email()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists", "USER_ALREADY_EXISTS");
        }
        User user = userMapper.fromNewRequest(request);
        return userMapper.toResponse(userRepository.save(user));
    }
}

