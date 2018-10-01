package com.api.country.dto.response;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.api.country.dto.response.CountryResponse;
import com.google.gson.Gson;

public class CountryResponseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void checkFormat() {
		List<String> northcountries = new ArrayList<>();
		northcountries.add("UAE");
		northcountries.add("Colombia");

		System.out.println(new Gson().toJson(new CountryResponse.Builder().northcountries(northcountries).build()));
	}
}
