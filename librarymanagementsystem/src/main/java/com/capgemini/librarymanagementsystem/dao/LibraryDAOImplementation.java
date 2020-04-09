package com.capgemini.librarymanagementsystem.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.db.DataBase;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class LibraryDAOImplementation implements LibraryDAO {
	
	Date date = new Date();
	Date expectedReturnDate = new Date();
	Date retunedDate = new Date();
	Calendar calendar = Calendar.getInstance();


	@Override
	public boolean register(UserInfo user) {
		for (UserInfo userBean : DataBase.USERDB) {
			if ((userBean.getUserId() == user.getUserId())
					|| (userBean.getUserEmailId().equals(user.getUserEmailId()))) {

				throw new LMSException("User Already Exists");

			}
		}

		DataBase.USERDB.add(user);
		return true;
	}

	@Override
	public UserInfo authentication(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBook(BookInfo book) {
		for (BookInfo bookBean : DataBase.BOOKDB) {
			if (bookBean.getIsbn() == book.getIsbn()) {

				throw new LMSException("Book With This Id Already Exists");
			}
		}
		DataBase.BOOKDB.add(book);
		return true;
	}

	@Override
	public boolean deleteBook(int isbn) {
		for (BookInfo bookInfo : DataBase.BOOKDB) {
			if (bookInfo.getIsbn() == isbn) {
				DataBase.BOOKDB.remove(bookInfo);
				return true;
			}
		}
		throw new LMSException("Invalid Book Id To Delete");
	}

	@Override
	public List<BookInfo> showBooks() {
		List<BookInfo> booksList = new LinkedList<BookInfo>();
		for (BookInfo book : DataBase.BOOKDB) {
			book.getIsbn();
			book.getBookTitle();
			book.getAuthourName();
			book.getPrice();
			booksList.add(book);
		}
		return booksList;

	}

	@Override
	public List<UserInfo> showUsers() {
		List<UserInfo> infos = new LinkedList<UserInfo>();

		for (UserInfo userInfo : DataBase.USERDB) {
			userInfo.getUserId();
			userInfo.getUserName();
			userInfo.getUserEmailId();
			userInfo.getNoOfBooksBorrowed();
			infos.add(userInfo);
		}
		return infos;
	}

	@Override
	public List<BookInfo> search(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestInfo> showRequests() {
		List<RequestInfo> infos = new LinkedList<RequestInfo>();
		for (RequestInfo requestInfo : DataBase.REQUESTDB) {
			requestInfo.getBookInfo();
			requestInfo.getUserInfo();
			requestInfo.isIssued();
			requestInfo.isReturned();
			infos.add(requestInfo);
		}
		return infos;
	}


	

	@Override
	public RequestInfo bookRequest(int userId, int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bookIssue(UserInfo user, BookInfo book) {
		// TODO Auto-generated method stub
		return false;
	}

}
