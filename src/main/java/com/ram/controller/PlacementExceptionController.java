package com.ram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ram.exception.PlacementNotfoundException;

@ControllerAdvice
public class PlacementExceptionController
{
	@ExceptionHandler(value = PlacementNotfoundException.class)
	public ResponseEntity<Object> exception(PlacementNotfoundException exception)
	{
		return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	}
}
