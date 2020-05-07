package com.capgemini.libraryspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.libraryspringrest.dto.LibraryResponse;
import com.capgemini.libraryspringrest.exception.LibraryException;

@RestControllerAdvice
public class LibraryRestControllerAdvice {

	@ExceptionHandler
	public LibraryResponse myExceptionHandler(LibraryException libraryException) {
		LibraryResponse response = new LibraryResponse();
		
		response.setError(true);
		response.setMessage(libraryException.getMessage());
		return response;

	}

}
