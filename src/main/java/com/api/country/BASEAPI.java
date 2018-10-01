package com.api.country;

import java.math.BigDecimal;
import java.util.function.Predicate;

public interface BASEAPI {
	String API = "/api";
	String V1 = "/v1";
	String BASE_PATH = API + V1;
	String NORTH_COUNTRIES = "/northcountries";
	int MIN_ALLOWED_IPS = 1;
	int MAX_ALLOWED_IPS = 5;
	String API_IP_VIGILANTE = "https://ipvigilante.com/json/%s";
	Predicate<Object> NOT_NULL = val -> val == null;
	Predicate<String[]> GREATER_THAN_MIN_IPS = i -> i.length >= MIN_ALLOWED_IPS;
	Predicate<String[]> LESS_THAN_MAX_IPS = i -> i.length <= MAX_ALLOWED_IPS;
	Predicate<String[]> GREATER_THAN_LESS_THAN = (input) -> GREATER_THAN_MIN_IPS.and(LESS_THAN_MAX_IPS).test(input);
	Predicate<BigDecimal> IFLATITUDEINNORTHERN = (
			input) -> (input.compareTo(BigDecimal.ZERO) >= 0 && input.compareTo(BigDecimal.valueOf(90)) <= 0);

}
