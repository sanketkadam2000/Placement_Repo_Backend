package com.ram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ram.exception.CourseNotfoundException;

@ControllerAdvice
public class CourseExceptionController
{
	@ExceptionHandler(value = CourseNotfoundException.class)
	public ResponseEntity<Object> exception(CourseNotfoundException exception)
	{
		return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
	}
}
