package com.capgemini.libraryspringrest.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.libraryspringrest.exception.LibraryException;

public class Validation {

	public boolean validateId(int id) throws LibraryException {
		String idRegx = "[\\d&&[^0]][\\d]{2}";
		boolean isValidated = Pattern.matches(idRegx, String.valueOf(id));
		if (isValidated) {
			return true;
		} else {
			throw new LibraryException("Id should contain 3 digits and first letter should be non zero digit");
		}
	}

	public boolean validateName(String name) throws LibraryException {
		String nameRegEx = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new LibraryException("Name should contains only Alpabates");
		}
		return result;
	}

	public boolean validateEmail(String email) throws LibraryException {
		String emailRegx = "[\\w&&[^_]]{3,50}[@]{1}\\D{2,50}[.]{1}\\D{2,50}";
		boolean isValidated = Pattern.matches(emailRegx, email);
		if (isValidated) {
			return true;
		} else {
			throw new LibraryException("EmailId Should contain  @ and extensions(.com,.in,.org)");
		}
	}

	public boolean validatePassword(String password) throws LibraryException {
		String passwordRegx = "^.{4,10}$";
		boolean isValidated = Pattern.matches(passwordRegx, password);
		if (isValidated) {
			return true;
		} else {
			throw new LibraryException("password should contains any string with atleast 4 charaters and atmost 10");
		}
	}
}
