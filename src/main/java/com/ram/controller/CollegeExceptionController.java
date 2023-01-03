package com.ram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ram.exception.CollegeNotfoundException;


@ControllerAdvice
public class CollegeExceptionController
{
	@ExceptionHandler(value =CollegeNotfoundException.class)
	public ResponseEntity<Object> exception(CollegeNotfoundException exception)
	{
		return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	}
}
