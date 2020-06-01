package com.capgemini.libraryspringrest.dao;

import java.util.List;

import com.capgemini.libraryspringrest.dto.BookInfo;
import com.capgemini.libraryspringrest.dto.LibraryHistory;
import com.capgemini.libraryspringrest.dto.LibraryUsers;
import com.capgemini.libraryspringrest.dto.RequestInfo;

public interface LibraryDAO {

	boolean register(LibraryUsers user);

	boolean adminAuthentication(String emailId, String password);

	boolean userAuthentication(String emailId, String password);

	boolean addBook(BookInfo book);

	boolean deleteBook(int isbn);

	BookInfo updateBook(BookInfo book);
	
	List<BookInfo> showBooks();

	List<LibraryUsers> showUsers();
	
	LibraryUsers getUser(String emailId);

	List<BookInfo> searchBook(BookInfo bookInfo);

	List<RequestInfo> showRequests();

	boolean isBookIssued(int requestId);

	boolean isBookReceived(int requestId);

	boolean bookRequest(int userId, int bookId);

	boolean bookReturn(int userId, int bookId);
	
	boolean changePassword(int userId, String oldPassword, String newPassword);
	
	List<RequestInfo> getRequestedBooks();
	
	List<RequestInfo> userTakenBooks(int userId);
	
	List<RequestInfo> getReturnedBooks();
	
	boolean addToHistory(LibraryHistory history);
	
	List<LibraryHistory> getLibHistory();
	
	List<LibraryHistory> getUserHistory(int userId);
	

}

