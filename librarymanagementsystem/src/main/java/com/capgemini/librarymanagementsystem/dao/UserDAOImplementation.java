package com.capgemini.librarymanagementsystem.dao;

import java.util.Date;

import com.capgemini.librarymanagementsystem.db.DataBase;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class UserDAOImplementation implements UserDAO {
	Date returnDate = new Date();

	@Override
	public UserInfo userLogin(String userEmailId, String userPassword) {
		// UserInfo userInfo= new UserInfo();
		for (UserInfo userInfo : DataBase.USERDB) {
			//System.out.println("Entreing for each entry");
			if((userInfo.getUserEmailId().equals(userEmailId)) && (userInfo.getUserPassword().equals(userPassword))) {
				return userInfo;

//			if (userInfo.getUserEmailId().equals(userEmailId) && userInfo.getUserEmailId().equals(userPassword)) {
//				System.out.println("Validation done");
//				return userInfo;

			}
		}
		//System.out.println("Throwing exception");
		throw new LMSException("Invalid user credentials");
	}

	@Override
	public BookInfo bookSearch(int bookId) {
		for (BookInfo bookInfo : DataBase.BOOKDB) {
			if (bookInfo.getIsbn() == bookId) {
				return bookInfo;
			}
		}
		throw new LMSException("Invalid search");
	}

	@Override
	public RequestInfo bookRequest(UserInfo userInfo, BookInfo bookInfo) {
		boolean flag = false, isRequestExists = false;
		RequestInfo requestInfo = new RequestInfo();
		UserInfo userInfo2 = new UserInfo();
		BookInfo bookInfo2 = new BookInfo();

		for (RequestInfo requestInfo2 : DataBase.REQUESTDB) {
			if (bookInfo.getIsbn() == requestInfo2.getBookInfo().getIsbn()) {
				isRequestExists = true;

			}

		}

		if (!isRequestExists) {
			for (UserInfo user : DataBase.USERDB) {
				if (userInfo.getUserId() == user.getUserId()) {
					for (BookInfo book : DataBase.BOOKDB) {
						if (book.getIsbn() == bookInfo.getIsbn()) {
							userInfo2 = user;
							bookInfo2 = book;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookInfo(bookInfo2);
				requestInfo.setUserInfo(userInfo2);
				DataBase.REQUESTDB.add(requestInfo);
				return requestInfo;
			}

		}

		throw new LMSException("Invalid request or you cannot request that book");
	}

	@Override
	public RequestInfo bookReturn(UserInfo userInfo, BookInfo bookInfo) {
		// RequestInfo info = new RequestInfo();
		for (RequestInfo requestInfo : DataBase.REQUESTDB) {

			if (requestInfo.getBookInfo().getIsbn() == bookInfo.getIsbn()
					&& requestInfo.getUserInfo().getUserId() == userInfo.getUserId()
					&& requestInfo.isIssued() == true) {

//			if (requestInfo.isIssued() == true) {
				System.out.println("Returning Issued book only");
				requestInfo.setReturned(true);
				requestInfo.setReturnedDate(returnDate);
				// info = requestInfo;

				return requestInfo;
			}

		}

		throw new LMSException("Invalid return ");
	}

}
