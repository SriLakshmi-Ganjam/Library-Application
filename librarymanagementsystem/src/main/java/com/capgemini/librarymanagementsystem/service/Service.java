package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminInfo;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public interface Service {
	boolean register(UserInfo user);

	AdminInfo authentication(String adminEmailId, String adminPassword);

	BookInfo search(int bookId);

	boolean addBook(BookInfo book);

	boolean deleteBook(int isbn);

	List<BookInfo> showBooks();

	boolean bookIssue(UserInfo user, BookInfo book);

	List<RequestInfo> showRequests();

	List<UserInfo> showUsers();

	boolean isBookReceived(UserInfo user, BookInfo book);

}
