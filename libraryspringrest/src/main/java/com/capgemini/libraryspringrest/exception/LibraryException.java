package com.capgemini.libraryspringrest.exception;

@SuppressWarnings("serial")
public class LibraryException extends RuntimeException {
	public LibraryException(String msg) {
		super(msg);
	}

}
