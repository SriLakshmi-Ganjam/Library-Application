package com.capgemini.librarymanagementsystemjdbc.validation;

import java.util.regex.Pattern;

import com.capgemini.librarymanagementsystemjdbc.exception.LibraryException;

public class Validation {

	public boolean validatedId(int id) throws LibraryException{
		String idRegx = "[\\d&&[^0]][\\d]{4}";
		boolean isValidated = Pattern.matches(idRegx, String.valueOf(id));
		if (isValidated) {
			return true;
		} else {
			throw new LibraryException("Id should contain 5 digits and first letter should be non zero digit");
		}
	}
	
	public boolean validatedName(String name) throws LibraryException{
		String nameRegx = "\\D{2,50}";

		boolean isValidated = Pattern.matches(nameRegx, name);
		if (isValidated) {
			return true;
		} else {
			throw new LibraryException("Name should contain atleast 2 characters and alphabets only");
		}
		
	}
	public boolean validatedEmail(String email) throws LibraryException{
		String emailRegx = "[\\w&&[^_]]{3,50}[@]{1}\\D{2,50}[.]{1}\\D{2,50}";
		boolean isValidated = Pattern.matches(emailRegx, email);
		if (isValidated) {
			return true;
		} else {
			throw new LibraryException("EmailId Should contain  @ and extensions(.com,.in,.org)");
		}
	}
	
	public boolean validatedPassword(String password) throws LibraryException{
		String passwordRegx = "^.{4,8}$";
		boolean isValidated = Pattern.matches(passwordRegx, password);
		if (isValidated) {
			return true;
		} else {
			throw new LibraryException("password should contains any string with atleast 4 charaters and atmost 10");
		}
	}
}
