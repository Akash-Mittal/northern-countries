package com.api.country;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest

public class CountryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CountryService service;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGet() throws Exception {
        List<String> northcountries = new ArrayList<>();
        northcountries.add("UAE");
        northcountries.add("Colombia");

        CountryResponse response = new CountryResponse().withNorthcountries(northcountries);
        // when(service.execute(Mockito.any())).thenReturn(response);
        this.mockMvc.perform(get(API.BASE_PATH + API.NORTH_COUNTRIES + "?ip=8.8.8.8&ip=8.8.0.0")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString(new Gson().toJson(response))));
    }

}
