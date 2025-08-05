package com.example.todoapp.web;

import com.example.todoapp.application.UserService;
import com.example.todoapp.domain.User;
import com.example.todoapp.web.dto.CreateUserRequest;
import com.example.todoapp.web.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        User createdUser = userService.createUser(user);
        return toUserDto(createdUser);
    }

    private UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        return dto;
    }
}
