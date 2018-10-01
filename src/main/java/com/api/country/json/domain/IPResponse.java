package com.api.country.json.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IPResponse implements Serializable {

    @Override
    public String toString() {
        return "IPResponse [status=" + status + ", data=" + data + "]";
    }

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private Data data;
    private final static long serialVersionUID = -8991768210895269225L;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public IPResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    public IPResponse withData(Data data) {
        this.data = data;
        return this;
    }

}