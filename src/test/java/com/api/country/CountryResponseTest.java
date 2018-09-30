package com.api.country;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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

        System.out.println(new Gson().toJson(new CountryResponse().withNorthcountries(northcountries)));
    }
}
