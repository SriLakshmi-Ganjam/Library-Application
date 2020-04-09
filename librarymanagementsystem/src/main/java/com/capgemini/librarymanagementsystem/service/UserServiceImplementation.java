package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.dao.UserDAO;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;

public class UserServiceImplementation implements UserService{
	
	private UserDAO dao = LMSFactory.getUserDAO();

	@Override
	public UserInfo userLogin(String userEmailId, String userPassword) {
		return dao.userLogin(userEmailId, userPassword);
	}

	@Override
	public BookInfo bookSearch(int bookId) {
		return dao.bookSearch(bookId);
	}

	@Override
	public RequestInfo bookRequest(UserInfo userInfo, BookInfo bookInfo) {
		return dao.bookRequest(userInfo, bookInfo);
	}

	@Override
	public RequestInfo bookReturn(UserInfo userInfo, BookInfo bookInfo) {
		return dao.bookReturn(userInfo, bookInfo);
	}

	
}
