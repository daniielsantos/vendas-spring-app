package br.com.vendas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler  {

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<?> handleApiRequestException(Exception apiRequestException){
		
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		
		ApiException apiException = new ApiException (
				apiRequestException.getMessage(), 
				badRequest, 
				ZonedDateTime.now()
		);
		
		return new ResponseEntity<>(apiException, badRequest);	
	}
}
