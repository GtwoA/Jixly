package com.example.jixly.controller;

import com.example.jixly.dto.url.UrlRequestDTO;
import com.example.jixly.dto.url.UrlResponseDTO;
import com.example.jixly.service.UrlService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UlrController {
    private final UrlService urlService;

    public UlrController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/url/{id}")
    public UrlResponseDTO getUrlById(@PathVariable("id") Long id){
        return urlService.getUrlById(id);
    }

    @PostMapping("/create/url")
    public UrlResponseDTO createNewUrl(@RequestBody UrlRequestDTO requestDTO){
        return urlService.createShortUrl(requestDTO);
    }
}
