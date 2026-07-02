package com.example.jixly.entity;

import com.example.jixly.enums.SubscriptionStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "url")
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ссылка не может быть пустой")
    @Column(name = "original_url")
    private String originalURL;

    @Column(name = "domain")
    private String domain;

    @Column(name = "slug")
    private String slug;

    @Column(name = "short_url")
    private String shortUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
