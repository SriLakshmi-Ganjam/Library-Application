package com.capgemini.libraryhibernate.factory;


import com.capgemini.libraryhibernate.dao.LibraryDAO;
import com.capgemini.libraryhibernate.dao.LibraryDAOImplementation;
import com.capgemini.libraryhibernate.service.LibraryService;
import com.capgemini.libraryhibernate.service.LibraryServiceImplementation;

public class LibraryFactory {
	public static LibraryDAO getLibraryDAO() {
		return new LibraryDAOImplementation();
	}
	public static LibraryService getLibraryService()
	{
		return new LibraryServiceImplementation();
	}

}
