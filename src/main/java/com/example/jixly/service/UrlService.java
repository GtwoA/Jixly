package com.example.jixly.service;

import com.example.jixly.constant.ClassConstants;
import com.example.jixly.dto.url.UrlRequestDTO;
import com.example.jixly.dto.url.UrlResponseDTO;
import com.example.jixly.entity.UrlEntity;
import com.example.jixly.entity.UserEntity;
import com.example.jixly.enums.SubscriptionStatus;
import com.example.jixly.repository.UrlRepository;
import com.example.jixly.repository.UserRepository;
import com.example.jixly.util.UrlChecker;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private final UserRepository userRepository;

    public UrlService(UrlRepository urlRepository, UserRepository userRepository) {
        this.urlRepository = urlRepository;
        this.userRepository = userRepository;
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

    public UrlResponseDTO createShortUrl(UrlRequestDTO requestDTO) {

        UserEntity user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow();

        UrlEntity url = new UrlEntity();

        url.setOriginalURL(requestDTO.getOriginalURL());
        url.setSlug(requestDTO.getSlug());
        url.setUser(user);

        if (!UrlChecker.isUrlValid(requestDTO.getOriginalURL())) {
            throw new IllegalArgumentException("Некорректная или недоступная ссылка");
        }
        if (user.getSubscription() == SubscriptionStatus.YES) {
            url.setDomain(requestDTO.getDomain());
        } else {
            url.setDomain("jix.ly");
        }

        url.setShortUrl("https://" + url.getDomain() + "/" + url.getSlug());

        UrlEntity savedUrl = urlRepository.save(url);

        return new UrlResponseDTO(
                savedUrl.getId(),
                savedUrl.getOriginalURL(),
                savedUrl.getShortUrl()
        );
    }
}
