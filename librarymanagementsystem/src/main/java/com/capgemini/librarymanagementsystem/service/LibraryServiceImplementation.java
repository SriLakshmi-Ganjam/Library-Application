package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dao.LibraryDAO;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;

public class LibraryServiceImplementation implements LibraryService {
	private LibraryDAO dao = LMSFactory.getLibraryDAO();

	@Override
	public boolean register(UserInfo user) {
		return dao.register(user);
	}

	@Override
	public boolean adminAuthentication(String adminEmailId, String adminPassword) {
		return dao.adminAuthentication(adminEmailId, adminPassword);
	}

	@Override
	public boolean userAuthentication(String userEmailId, String userPassword) {
		return dao.userAuthentication(userEmailId, userPassword);
	}

	@Override
	public boolean addBook(BookInfo book) {
		return dao.addBook(book);
	}

	@Override
	public boolean deleteBook(int isbn) {
		return dao.deleteBook(isbn);
	}

	@Override
	public List<BookInfo> showBooks() {
		return dao.showBooks();
	}

	@Override
	public List<UserInfo> showUsers() {
		return dao.showUsers();
	}

	@Override
	public List<BookInfo> searchBook(BookInfo bookInfo) {
		return dao.searchBook(bookInfo);
	}

	@Override
	public List<RequestInfo> showRequests() {
		return dao.showRequests();
	}

	@Override
	public boolean bookIssue(int userId, int bookId) {
		return dao.bookIssue(userId, bookId);
	}

	@Override
	public boolean isBookReceived(int userId, int bookId) {
		return dao.isBookReceived(userId, bookId);
	}

	@Override
	public boolean bookRequest(int userId, int bookId) {
		return dao.bookRequest(userId, bookId);
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		return dao.bookReturn(userId, bookId);
	}

	@Override
	public boolean changePassword(int userId, String oldPassword, String newPassword) {
		return dao.changePassword(userId, oldPassword, newPassword);
	}

}
