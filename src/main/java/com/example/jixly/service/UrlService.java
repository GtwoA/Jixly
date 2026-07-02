package com.example.jixly.service;

import com.example.jixly.constant.ClassConstants;
import com.example.jixly.dto.url.UrlRequestDTO;
import com.example.jixly.dto.url.UrlResponseDTO;
import com.example.jixly.entity.UrlEntity;
import com.example.jixly.repository.UrlRepository;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public UrlResponseDTO getUrlById(Long id){
        UrlEntity urlEntity = urlRepository.findById(id)
                .orElseThrow();

        return new UrlResponseDTO(
                urlEntity.getId(),
                urlEntity.getOriginalURL(),
                urlEntity.getShortUrl()
        );
    }

    public UrlResponseDTO createShortUrl(UrlRequestDTO requestDTO){
        UrlEntity urlEntity = new UrlEntity();

        urlEntity.setOriginalURL(requestDTO.getOriginalURL());
        String newUrl = "https://" + ClassConstants.DOMAIN_URL + "/" + requestDTO.getSlug();
        urlEntity.setShortUrl(newUrl);

        UrlEntity saveUrl = urlRepository.save(urlEntity);

        return new UrlResponseDTO(
                saveUrl.getId(),
                saveUrl.getOriginalURL(),
                saveUrl.getShortUrl()
        );
    }
}
