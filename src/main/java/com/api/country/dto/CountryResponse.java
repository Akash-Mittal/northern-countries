package com.api.country.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "northcountries" })

public class CountryResponse implements Serializable {

    private List<String> northcountries = null;
    private final static long serialVersionUID = 6014256002050112228L;

    public List<String> getNorthcountries() {
        return northcountries;
    }

    public void setNorthcountries(List<String> northcountries) {
        this.northcountries = northcountries;
    }

    public CountryResponse withNorthcountries(List<String> northcountries) {
        this.northcountries = northcountries;
        return this;
    }

}
