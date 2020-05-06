package com.capgemini.libraryspringrest.factory;


import com.capgemini.libraryspringrest.dao.LibraryDAO;
import com.capgemini.libraryspringrest.dao.LibraryDAOImplementation;
import com.capgemini.libraryspringrest.service.LibraryService;
import com.capgemini.libraryspringrest.service.LibraryServiceImplementation;

public class LibraryFactory {
	public static LibraryDAO getLibraryDAO() {
		return new LibraryDAOImplementation();
	}
	public static LibraryService getLibraryService()
	{
		return new LibraryServiceImplementation();
	}

}
