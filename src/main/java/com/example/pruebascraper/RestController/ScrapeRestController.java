package com.example.pruebascraper.RestController;

import com.example.pruebascraper.DTO.ScrapeResponseDTO;
import com.example.pruebascraper.Service.ScrapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScrapeRestController {

    @Autowired
    private ScrapeService scrapeService;

    @GetMapping("/scrape")
    public ScrapeResponseDTO scrape(@RequestParam String url) {
        return scrapeService.scrape(url);
    }

}
