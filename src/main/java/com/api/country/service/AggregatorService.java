package com.api.country.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.country.BASEAPI;
import com.api.country.dto.response.CountryResponse;
import com.api.country.exception.ServiceException;
import com.api.country.json.domain.IPResponse;

@Service
public class AggregatorService {
	private static final Logger logger = LoggerFactory.getLogger(AggregatorService.class);

	@Autowired
	CountryService countryService;

	public CountryResponse aggregate(final String[] ips) throws InterruptedException {
		return new CountryResponse.Builder()
				.northcountries(filterByLatitudeAndSortByName(getLatitudeAndCountryMap(aggregateAllResponses(ips))))
				.build();
	}

	private List<String> filterByLatitudeAndSortByName(final Map<BigDecimal, String> mapping) {
		final List<String> responseList = new ArrayList<>();
		mapping.entrySet().stream().filter(es -> BASEAPI.CHECKIFLATITUDEINNORTHERN.test(es.getKey()))
				.sorted(Map.Entry.<BigDecimal, String>comparingByKey())
				.forEach(val -> responseList.add(val.getValue()));
		return responseList;
	}

	private Map<BigDecimal, String> getLatitudeAndCountryMap(
			final List<CompletableFuture<IPResponse>> responseCompletableFuture) {
		final Map<BigDecimal, String> mapping = new HashMap<>();
		responseCompletableFuture.stream().forEach(futureResponse -> {
			try {
				IPResponse iresponse = futureResponse.get();

				if (iresponse.getStatus().contains("success")) {
					logger.info("Got Valid Response: {}", iresponse);
					mapping.put(new BigDecimal(iresponse.getData().getLatitude()),
							iresponse.getData().getCountryName());
				} else {
					logger.info("Request Fiailed:", iresponse);
				}
			} catch (InterruptedException | ExecutionException e) {
				logger.error("Got Error {} Will Not Retry", e.getMessage());
				throw new ServiceException("Got Error Please try after some time: " + e.getCause());
			}
		});
		return mapping;
	}

	private List<CompletableFuture<IPResponse>> aggregateAllResponses(final String[] arrayOfIPAddressRecieved) {
		final List<CompletableFuture<IPResponse>> ipfutureResponse = new ArrayList<>();
		if (BASEAPI.CHECK_IF_IPS_IS_GREATER_THAN_0_LESS_THAN_5.test(arrayOfIPAddressRecieved)) {
			Arrays.stream(arrayOfIPAddressRecieved).filter(BASEAPI.VALID_IP_ADDRESS)
					.peek(ip -> logger.info("Calling IP:{} ", ip)).forEach(ip -> {
						ipfutureResponse.add(countryService.callIPDetailsApi(ip));
					});
		}
		return ipfutureResponse;
	}

}
