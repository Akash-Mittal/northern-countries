package com.api.country.json.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    @Override
    public String toString() {
        return "Data [ipv4=" + ipv4 + ", continentName=" + continentName + ", countryName=" + countryName
                + ", subdivision1Name=" + subdivision1Name + ", subdivision2Name=" + subdivision2Name + ", cityName="
                + cityName + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }

    @JsonProperty("ipv4")
    private String ipv4;
    @JsonProperty("continent_name")
    private String continentName;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("subdivision_1_name")
    private String subdivision1Name;
    @JsonProperty("subdivision_2_name")
    private Object subdivision2Name;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    private final static long serialVersionUID = -6081098617004427327L;

    @JsonProperty("ipv4")
    public String getIpv4() {
        return ipv4;
    }

    @JsonProperty("ipv4")
    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public Data withIpv4(String ipv4) {
        this.ipv4 = ipv4;
        return this;
    }

    @JsonProperty("continent_name")
    public String getContinentName() {
        return continentName;
    }

    @JsonProperty("continent_name")
    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public Data withContinentName(String continentName) {
        this.continentName = continentName;
        return this;
    }

    @JsonProperty("country_name")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("country_name")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Data withCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    @JsonProperty("subdivision_1_name")
    public String getSubdivision1Name() {
        return subdivision1Name;
    }

    @JsonProperty("subdivision_1_name")
    public void setSubdivision1Name(String subdivision1Name) {
        this.subdivision1Name = subdivision1Name;
    }

    public Data withSubdivision1Name(String subdivision1Name) {
        this.subdivision1Name = subdivision1Name;
        return this;
    }

    @JsonProperty("subdivision_2_name")
    public Object getSubdivision2Name() {
        return subdivision2Name;
    }

    @JsonProperty("subdivision_2_name")
    public void setSubdivision2Name(Object subdivision2Name) {
        this.subdivision2Name = subdivision2Name;
    }

    public Data withSubdivision2Name(Object subdivision2Name) {
        this.subdivision2Name = subdivision2Name;
        return this;
    }

    @JsonProperty("city_name")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("city_name")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Data withCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Data withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Data withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

}