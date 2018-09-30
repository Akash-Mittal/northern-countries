package com.api.country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryService {
    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
    private final RestTemplate restTemplate;

    public CountryService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public List<CompletableFuture<IPResponse>> execute(final String[] ips) throws InterruptedException {
        logger.info("Looking up ", ips[0]);
        List<CompletableFuture<IPResponse>> ipfutures = new ArrayList<>();
        Arrays.stream(ips).forEach(ip -> {
            String url = String.format("https://ipvigilante.com/json/%s", ips[0]);
            IPResponse results = restTemplate.getForObject("https://demo7820409.mockable.io/json", IPResponse.class);
            ipfutures.add(CompletableFuture.completedFuture(results));
        });
        return ipfutures;
    }

    @Async
    public CompletableFuture<IPResponse> executeTest(final String[] ips) throws InterruptedException {
        logger.info("Looking up ", ips[0]);
        IPResponse results = restTemplate.getForObject("https://demo7820409.mockable.io/json", IPResponse.class);
        return (CompletableFuture.completedFuture(results));
    }
}
