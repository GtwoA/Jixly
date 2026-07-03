package com.example.jixly.service;

import com.example.jixly.config.SecurityConfig;
import com.example.jixly.dto.user.UserCreateResponseDTO;
import com.example.jixly.dto.user.UserRequestDTO;
import com.example.jixly.dto.user.UserResponseDto;
import com.example.jixly.entity.UrlEntity;
import com.example.jixly.entity.UserEntity;
import com.example.jixly.repository.UrlRepository;
import com.example.jixly.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UrlRepository urlRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UrlRepository urlRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.urlRepository = urlRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto getUser(Long id){
        UserEntity user = userRepository.findById(id)
                .orElseThrow();

        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getSubscription(),
                user.getUrlEntities()
        );
    }

    public UserCreateResponseDTO createUser(UserRequestDTO userRequestDTO){
        UserEntity user = new UserEntity();

        user.setEmail(userRequestDTO.getEmail());
        user.setName(userRequestDTO.getName());
        user.setSubscription(userRequestDTO.getSubscription());

        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));

        UserEntity savedUser = userRepository.save(user);

        return new UserCreateResponseDTO(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getName(),
                savedUser.getSubscription()
        );
    }
}
