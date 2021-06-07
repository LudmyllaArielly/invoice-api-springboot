package com.ludmylla.invoice.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErros handleMethodNotValidException(MethodArgumentNotValidException ex) {
		 List<String> errors = ex.getBindingResult().getAllErrors()
	                .stream()
	                .map(erro -> erro.getDefaultMessage())
	                .collect(Collectors.toList());
	        return new ApiErros(errors);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErros handleUserNotFoundException(UserNotFoundException ex) {
		return new ApiErros(ex);
	}
}
