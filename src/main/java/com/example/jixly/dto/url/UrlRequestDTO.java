package com.example.jixly.dto.url;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UrlRequestDTO {
    @NotBlank(message = "Ссылка не может быть пустой")
    private String originalURL;

    @NotBlank(message = "Название не может быть пустым")
    private String slug;
}
