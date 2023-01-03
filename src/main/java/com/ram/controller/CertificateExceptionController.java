package com.ram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ram.exception.CertificateNotfoundException;

@ControllerAdvice
public class CertificateExceptionController
{
	@ExceptionHandler(value = CertificateNotfoundException.class)
	public ResponseEntity<Object> exception(CertificateNotfoundException exception)
	{
		return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	}
}
