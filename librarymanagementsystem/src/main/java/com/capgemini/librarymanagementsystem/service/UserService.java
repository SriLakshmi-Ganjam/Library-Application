package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public interface UserService {
	UserInfo userLogin(String userEmailId, String userPassword);

	BookInfo bookSearch(int bookId);

	RequestInfo bookRequest(UserInfo userInfo, BookInfo bookInfo);

	RequestInfo bookReturn(UserInfo userInfo, BookInfo bookInfo);
}
