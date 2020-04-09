package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminInfo;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public interface AdminDAO {

	boolean register(UserInfo user);

	AdminInfo authentication(String adminEmailId, String adminPassword);

	boolean addBook(BookInfo book);

	BookInfo search(int bookId);

	boolean deleteBook(int isbn);

	List<UserInfo> showUsers();

	List<BookInfo> showBooks();

	List<RequestInfo> showRequests();

	boolean bookIssue(UserInfo user, BookInfo book);

	boolean isBookReceived(UserInfo user, BookInfo book);

//	Date bookIssueDate();
//	Date bookReturnDate();
//	

}
