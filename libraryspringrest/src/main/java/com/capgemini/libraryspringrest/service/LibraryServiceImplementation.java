package com.capgemini.libraryspringrest.service;

import java.util.List;

import com.capgemini.libraryspringrest.dao.LibraryDAO;
import com.capgemini.libraryspringrest.dto.BookInfo;
import com.capgemini.libraryspringrest.dto.LibraryUsers;
import com.capgemini.libraryspringrest.dto.RequestInfo;
import com.capgemini.libraryspringrest.factory.LibraryFactory;

public class LibraryServiceImplementation implements LibraryService {

	private LibraryDAO dao = LibraryFactory.getLibraryDAO();

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
	public boolean adminAuthentication(int id, String password) {
		return dao.adminAuthentication(id, password);
	}

	@Override
	public boolean userAuthentication(int id, String password) {
		return dao.userAuthentication(id, password);
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

}
