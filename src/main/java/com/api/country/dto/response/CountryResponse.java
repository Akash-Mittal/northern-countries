package com.api.country.dto.response;

import java.io.Serializable;
import java.util.List;

public class CountryResponse implements Serializable {
	private final static long serialVersionUID = 6014256002050112228L;

	private List<String> northcountries = null;

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

	public static class Builder {
		private List<String> northcountries;

		public Builder northcountries(List<String> northcountries) {
			this.northcountries = northcountries;
			return this;
		}

		public CountryResponse build() {
			return new CountryResponse(this);
		}
	}

	private CountryResponse(Builder builder) {
		this.northcountries = builder.northcountries;
	}
}
