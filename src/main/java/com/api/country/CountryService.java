package com.api.country;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

    public CountryResponse execute(final String[] ips) throws InterruptedException {

        List<String> northcountries = new ArrayList<>();
        northcountries.add("UAE");
        northcountries.add("Colombia");

        return new CountryResponse().withNorthcountries(northcountries);

    }
}
