package com.api.country.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.api.country.dto.response.ErrorResponse;
import com.api.country.exception.ServiceException;
import com.api.country.exception.ValidationException;

@ControllerAdvice
@RestController
public class BaseExceptionHandler {
	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(ValidationException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ServiceException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(ServiceException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_GATEWAY);
	}

}
