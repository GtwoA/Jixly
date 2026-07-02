package com.example.jixly.controller;

import com.example.jixly.dto.user.UserRequestDTO;
import com.example.jixly.dto.user.UserResponseDto;
import com.example.jixly.entity.UserEntity;
import com.example.jixly.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public UserResponseDto getUserById(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @PostMapping("/create/user")
    public UserResponseDto createNewUser(@RequestBody @Valid UserRequestDTO dto){
        return userService.createUser(dto);
    }
}
