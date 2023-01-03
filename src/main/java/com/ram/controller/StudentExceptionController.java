package com.ram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ram.exception.StudentNotfoundException;

@ControllerAdvice
public class StudentExceptionController
{
	@ExceptionHandler(value = StudentNotfoundException.class)
	public ResponseEntity<Object> exception(StudentNotfoundException exception)
	{
		return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	}
}
