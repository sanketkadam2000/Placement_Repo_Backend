package com.ram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ram.exception.UserNotfoundException;

@ControllerAdvice
public class UserExceptionController
{
	@ExceptionHandler(value = UserNotfoundException.class)
	public ResponseEntity<Object> exception(UserNotfoundException exception)
	{
		return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	}
}
