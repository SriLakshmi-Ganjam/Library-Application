package com.capgemini.librarymanagementsystem.factory;

import com.capgemini.librarymanagementsystem.dao.LibraryDAO;
import com.capgemini.librarymanagementsystem.dao.LibraryDAOImplementation;
import com.capgemini.librarymanagementsystem.service.LibraryService;
import com.capgemini.librarymanagementsystem.service.LibraryServiceImplementation;

public class LMSFactory {

	public static LibraryDAO getLibraryDAO() {
		return new LibraryDAOImplementation();
	}

	public static LibraryService getLibraryServiceDAO() {
		return new LibraryServiceImplementation();
	}

}
