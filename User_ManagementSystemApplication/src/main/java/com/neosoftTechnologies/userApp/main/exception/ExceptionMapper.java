package com.neosoftTechnologies.userApp.main.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionMapper {

	@ExceptionHandler(value = FileMissingException.class)
	public ResponseEntity<ErrorResponse> FileMissingException(FileMissingException exception){
		ErrorResponse response=new ErrorResponse();
		response.setErrorCode("UMA01");
		response.setErrorMsg(exception.getMessage());
		response.setDateTime(LocalDateTime.now());
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
