package com.api.country.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.country.BASEAPI;
import com.api.country.json.domain.IPResponse;

@Service
public class CountryService {
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
	private final RestTemplate restTemplate;

	@Async
	public CompletableFuture<IPResponse> callIPDetailsApi(final String ip) {
		final String url = String.format(BASEAPI.API_IP_VIGILANTE, ip);
		logger.info("Calling Host: {}", url);
		return CompletableFuture.completedFuture(restTemplate.getForObject(url, IPResponse.class));
	}

	public CountryService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
}
