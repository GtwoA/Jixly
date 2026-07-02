package com.example.jixly.service;

import com.example.jixly.config.SecurityConfig;
import com.example.jixly.dto.user.UserRequestDTO;
import com.example.jixly.dto.user.UserResponseDto;
import com.example.jixly.entity.UserEntity;
import com.example.jixly.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto getUser(Long id){
        UserEntity user = userRepository.findById(id)
                .orElseThrow();

        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getName()
        );
    }

    public UserResponseDto createUser(UserRequestDTO userRequestDTO){
        UserEntity user = new UserEntity();

        user.setEmail(userRequestDTO.getEmail());
        user.setName(userRequestDTO.getName());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));

        UserEntity savedUser = userRepository.save(user);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getName()
        );
    }
}
