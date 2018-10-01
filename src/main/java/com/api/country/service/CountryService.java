package com.api.country.service;

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

import com.api.country.BASEAPI;
import com.api.country.json.domain.IPResponse;

@Service
public class CountryService {
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
	private final RestTemplate restTemplate;

	public List<CompletableFuture<IPResponse>> execute(final String[] ips) throws InterruptedException {
		return this.aggregateAllResponses(ips);
	}

	private List<CompletableFuture<IPResponse>> aggregateAllResponses(final String[] arrayOfIPAddressRecieved) {
		final List<CompletableFuture<IPResponse>> ipfutureResponse = new ArrayList<>();
		Arrays.stream(arrayOfIPAddressRecieved).peek(ip -> logger.info("Looking IP:{} ", ip)).forEach(ip -> {
			ipfutureResponse.add(callIPDetailsApi(ip));
		});
		return ipfutureResponse;
	}

	@Async
	public CompletableFuture<IPResponse> callIPDetailsApi(final String ip) {
		return CompletableFuture
				.completedFuture(restTemplate.getForObject(String.format(BASEAPI.API_IP_VIGILANTE, ip), IPResponse.class));
	}

	public CountryService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

}
