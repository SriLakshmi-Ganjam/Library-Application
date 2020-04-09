package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dto.AdminInfo;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;

public class ServiceImplementation implements Service {
	
	private AdminDAO dao = LMSFactory.getAdminDAO();

	@Override
	public boolean register(UserInfo user) {
		
		return dao.register(user);
	}

	@Override
	public AdminInfo authentication(String adminId, String adminPassword) {
		return dao.authentication(adminId, adminPassword);
	}

	@Override
	public BookInfo search(int bookId) {
		return dao.search(bookId);
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
	public boolean bookIssue(UserInfo user, BookInfo book) {
		return dao.bookIssue(user, book);
	}

	@Override
	public List<RequestInfo> showRequests() {
		return dao.showRequests();
	}

	@Override
	public List<UserInfo> showUsers() {
		return dao.showUsers();
	}

	@Override
	public boolean isBookReceived(UserInfo user, BookInfo book) {
		return dao.isBookReceived(user, book);
	}


}
