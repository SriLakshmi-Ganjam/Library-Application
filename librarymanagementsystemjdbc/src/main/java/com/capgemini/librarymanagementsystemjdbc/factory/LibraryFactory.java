package com.capgemini.librarymanagementsystemjdbc.factory;


import com.capgemini.librarymanagementsystemjdbc.dao.LibraryDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.LibraryDAOImplementation;
import com.capgemini.librarymanagementsystemjdbc.service.LibraryService;
import com.capgemini.librarymanagementsystemjdbc.service.LibraryServiceImplementation;

public class LibraryFactory {
	public static LibraryDAO getLibraryDAO() {
		return new LibraryDAOImplementation();
	}
	public static LibraryService getLibraryService()
	{
		return new LibraryServiceImplementation();
	}

}
