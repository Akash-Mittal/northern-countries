package com.api.country.controller;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.country.BASEAPI;
import com.api.country.dto.response.CountryResponse;
import com.api.country.service.AggregatorService;

@RestController
@RequestMapping(BASEAPI.BASE_PATH)
public class CountryController {
	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private AggregatorService service;

	@GetMapping(BASEAPI.NORTH_COUNTRIES)
	public CountryResponse get(@RequestParam(value = "ip") String[] ip)
			throws InterruptedException, ExecutionException {
		logger.info("Total {} Request Recieved for IP's:{} ", ip.length);
		return service.aggregate(ip);

	}

}
