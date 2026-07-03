package com.example.jixly.dto.user;

import com.example.jixly.entity.UrlEntity;
import com.example.jixly.enums.SubscriptionStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 6, max = 100)
    private String password;

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Введите корректный email")
    @Size(min = 8, max = 100)
    private String email;

    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 1, max = 15)
    private String name;

    @NotNull(message = "Подписка должна быть указана")
    private SubscriptionStatus subscription;
}
