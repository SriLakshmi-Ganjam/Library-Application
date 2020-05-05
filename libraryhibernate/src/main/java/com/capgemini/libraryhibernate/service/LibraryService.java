package com.capgemini.libraryhibernate.service;

import java.util.List;

import com.capgemini.libraryhibernate.dto.BookInfo;
import com.capgemini.libraryhibernate.dto.LibraryUsers;
import com.capgemini.libraryhibernate.dto.RequestInfo;

public interface LibraryService {
	boolean register(LibraryUsers user);

	boolean adminAuthentication(int id, String password);

	boolean userAuthentication(int id, String password);

	boolean addBook(BookInfo book);

	boolean deleteBook(int isbn);

	List<BookInfo> showBooks();

	List<LibraryUsers> showUsers();

	List<BookInfo> searchBook(BookInfo bookInfo);

	List<RequestInfo> showRequests();

	boolean isBookIssued(int requestId);

	boolean isBookReceived(int requestId);

	// USER INTERFACE

	boolean bookRequest(int userId, int bookId);

	boolean bookReturn(int userId, int bookId);
	
	boolean changePassword(int userId, String oldPassword, String newPassword);

}
