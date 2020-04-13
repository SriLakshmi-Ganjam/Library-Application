package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public interface LibraryService {
	boolean register(UserInfo user);

	boolean adminAuthentication(String adminEmailId, String adminPassword);

	boolean userAuthentication(String userEmailId, String userPassword);

	boolean addBook(BookInfo book);

	boolean deleteBook(int isbn);

	List<BookInfo> showBooks();

	List<UserInfo> showUsers();

	List<BookInfo> searchBook(BookInfo bookInfo);

	List<RequestInfo> showRequests();

	boolean bookIssue(int userId, int bookId);

	public boolean isBookReceived(int userId, int bookId);
	// USER INTERFACE

	boolean bookRequest(int userId, int bookId);

	boolean bookReturn(int userId, int bookId);

}
