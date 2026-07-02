package com.example.jixly.entity;

import com.example.jixly.enums.SubscriptionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription")
    private SubscriptionStatus subscription;

    @NotBlank(message = "Email не может быть пустым")
    @Size(min = 8, max = 100, message = "Email должен быть от 5 до 254 символов")
    @Email(message = "Введите корректный email адрес")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 1, max = 15)
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    List<UrlEntity> urlEntities;
}
