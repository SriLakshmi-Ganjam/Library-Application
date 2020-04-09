package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dao.LibraryDAO;
import com.capgemini.librarymanagementsystemjdbc.dto.BookInfo;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestInfo;
import com.capgemini.librarymanagementsystemjdbc.dto.LibraryUsers;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryFactory;

public class LibraryServiceImplementation implements LibraryService {

	private LibraryDAO dao = LibraryFactory.getLibraryDAO();

	@Override
	public boolean register(LibraryUsers user) {
		return dao.register(user);
	}

	@Override
	public LibraryUsers authentication(int id, String password) {
		return dao.authentication(id, password);
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
	public List<BookInfo> search(BookInfo bookInfo) {
		return dao.search(bookInfo);
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
	public RequestInfo bookRequest(int  userId, int bookId) {
		return dao.bookRequest(userId, bookId);
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		return dao.bookReturn(userId, bookId);
	}

}
