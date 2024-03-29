package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.util.ErrorMessage;
import com.example.demo.util.FieldErrorMessage;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	ErrorMessage exceptionHandler(ValidationException e) {
		return new ErrorMessage("400", e.getMessage());
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {
		List<FieldError> fielderrors = e.getBindingResult().getFieldErrors();
		List<FieldErrorMessage> fieldErrorMessages = fielderrors.stream()
				.map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
				.collect(Collectors.toList());
		return fieldErrorMessages;
	}

}
