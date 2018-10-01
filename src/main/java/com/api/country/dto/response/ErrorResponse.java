package com.api.country.dto.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponse extends BaseResponse {

	public ErrorResponse(Date timestamp, String message, HttpStatus httpStatus) {
		super(timestamp, message, httpStatus);
	}

}
