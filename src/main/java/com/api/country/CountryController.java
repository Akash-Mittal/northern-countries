package com.api.country;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API.BASE_PATH)
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService walletClientService;

    @GetMapping(API.NORTH_COUNTRIES)
    public void get(@RequestParam(value = "ip") String[] ip) throws InterruptedException, ExecutionException {
        logger.info("Total {} Request Recieved for IP's:{} ", ip.length);
        Arrays.stream(ip).forEach(eyep -> logger.info("{}", eyep));
        CompletableFuture<IPResponse> ipr = walletClientService.executeTest(ip);
        logger.info("" + ipr.get());

    }
}
