package com.example.jixly.dto.user;

import com.example.jixly.enums.SubscriptionStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateResponseDTO {
    private Long id;

    private String email;

    private String name;

    private SubscriptionStatus subscription;
}
