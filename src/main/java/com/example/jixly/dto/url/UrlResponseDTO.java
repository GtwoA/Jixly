package com.example.jixly.dto.url;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UrlResponseDTO {
    private Long id;

    private String originalURL;

    private String shortUrl;
}
