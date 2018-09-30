package com.api.country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API.BASE_PATH)
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService walletClientService;

    @GetMapping(API.NORTH_COUNTRIES)
    public CountryResponse get() throws InterruptedException {
        logger.info("Recieved Request for IP's:{} ", "");
        return walletClientService.execute(null);
    }
}
