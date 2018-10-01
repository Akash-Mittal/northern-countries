package com.api.country.dto.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class BaseResponse {
	private Date timestamp;
	private String message;
	private HttpStatus httpStatus;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public BaseResponse(Date timestamp, String message, HttpStatus httpStatus) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public static class Builder {
		private Date timestamp;
		private String message;
		private HttpStatus httpStatus;

		public Builder timestamp(Date timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public Builder httpStatus(HttpStatus httpStatus) {
			this.httpStatus = httpStatus;
			return this;
		}

		public BaseResponse build() {
			return new BaseResponse(this);
		}
	}

	private BaseResponse(Builder builder) {
		this.timestamp = builder.timestamp;
		this.message = builder.message;
		this.httpStatus = builder.httpStatus;
	}
}