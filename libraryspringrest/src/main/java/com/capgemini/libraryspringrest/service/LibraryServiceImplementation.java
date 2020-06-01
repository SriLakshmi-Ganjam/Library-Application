package com.capgemini.libraryspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.libraryspringrest.dao.LibraryDAO;
import com.capgemini.libraryspringrest.dto.BookInfo;
import com.capgemini.libraryspringrest.dto.LibraryHistory;
import com.capgemini.libraryspringrest.dto.LibraryUsers;
import com.capgemini.libraryspringrest.dto.RequestInfo;

@Service
public class LibraryServiceImplementation implements LibraryService {

	@Autowired
	private LibraryDAO dao;

	@Override
	public boolean register(LibraryUsers user) {
		return dao.register(user);
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
	public List<LibraryUsers> showUsers() {
		return dao.showUsers();
	}

	@Override
	public List<RequestInfo> showRequests() {
		return dao.showRequests();
	}

	@Override
	public boolean isBookIssued(int requestId) {
		return dao.isBookIssued(requestId);
	}

	@Override
	public boolean isBookReceived(int requestId) {
		return dao.isBookReceived(requestId);
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		return dao.bookReturn(userId, bookId);
	}

	@Override
	public boolean adminAuthentication(String emailId, String password) {
		return dao.adminAuthentication(emailId, password);
	}

	@Override
	public boolean userAuthentication(String emailId, String password) {
		return dao.userAuthentication(emailId, password);
	}

	@Override
	public List<BookInfo> searchBook(BookInfo bookInfo) {
		return dao.searchBook(bookInfo);
	}

	@Override
	public boolean bookRequest(int userId, int bookId) {
		return dao.bookRequest(userId, bookId);
	}

	@Override
	public boolean changePassword(int userId, String oldPassword, String newPassword) {
		return dao.changePassword(userId, oldPassword, newPassword);
	}

	@Override
	public BookInfo updateBook(BookInfo book) {
		return dao.updateBook(book);
	}

	@Override
	public LibraryUsers getUser(String email) {
		
		return dao.getUser(email);
	}

	@Override
	public List<RequestInfo> getRequestedBooks() {
		return dao.getRequestedBooks();
	}

	@Override
	public List<RequestInfo> userTakenBooks(int userId) {
		return dao.userTakenBooks(userId);
	}

	@Override
	public List<RequestInfo> getReturnedBooks() {
		return dao.getReturnedBooks();
	}

	@Override
	public List<LibraryHistory> getLibHistory() {
		return dao.getLibHistory();
	}

	@Override
	public List<LibraryHistory> getUserHistory(int userId) {
		return dao.getUserHistory(userId);
	}

}
