package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public interface LibraryDAO {
	boolean register(UserInfo user);

	UserInfo authentication(int id, String password);

	boolean addBook(BookInfo book);

	boolean deleteBook(int isbn);

	List<BookInfo> showBooks();

	List<UserInfo> showUsers();

	List<BookInfo> search(BookInfo bookInfo);

	List<RequestInfo> showRequests();

//	boolean isBookIssued(int requestId);
//
//	boolean isBookReceived(int requestId);
	
	 boolean bookIssue(UserInfo user, BookInfo book);

	// USER INTERFACE

	RequestInfo bookRequest(int userId, int bookId);

	boolean bookReturn(int userId, int bookId);


}
