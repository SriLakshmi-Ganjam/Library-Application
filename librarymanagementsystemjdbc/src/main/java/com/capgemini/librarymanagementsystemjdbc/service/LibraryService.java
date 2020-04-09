package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookInfo;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestInfo;
import com.capgemini.librarymanagementsystemjdbc.dto.LibraryUsers;

public interface LibraryService {
	boolean register(LibraryUsers user);

	LibraryUsers authentication(int id, String password);

	boolean addBook(BookInfo book);

	boolean deleteBook(int isbn);

	List<BookInfo> showBooks();

	List<BookInfo> search(BookInfo bookInfo);

	List<LibraryUsers> showUsers();

	List<RequestInfo> showRequests();

	boolean isBookIssued(int requestId);

	boolean isBookReceived(int requestId);

	// USER INTERFACE

	RequestInfo bookRequest(int userId, int bookId);

	//RequestInfo bookReturn(LibraryUsers userInfo, BookInfo bookInfo);
	
	boolean bookReturn(int userId, int bookId);



}
