package com.capgemini.librarymanagementsystem.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.db.DataBase;
import com.capgemini.librarymanagementsystem.dto.AdminInfo;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class AdminDAOImplementation implements AdminDAO {
	Date date = new Date();
	Date expectedReturnDate = new Date();
	Date retunedDate = new Date();
	Calendar calendar = Calendar.getInstance();

	@Override
	public boolean register(UserInfo user) {

		for (UserInfo userBean : DataBase.USERDB) {
			if ((userBean.getUserId() == user.getUserId()) || (userBean.getUserEmailId().equals(user.getUserEmailId())) ) {
				//if (userBean.getUserEmailId().equals(user.getUserEmailId())) {

					return false;
				//}

			}
		}
//		for (UserInfo userBean : DataBase.USERDB) {
//			if ((userBean.getUserId() == user.getUserId())) {
//				return false;
//			}
//
//		}

		
		DataBase.USERDB.add(user);

		return true;
	}

	@Override
	public BookInfo search(int bookId) {
		for (BookInfo bookBean : DataBase.BOOKDB) {
			if (bookBean.getIsbn() == bookId) {

				return bookBean;
			}
		}
		throw new LMSException("Book not found");
	}

	@Override
	public boolean addBook(BookInfo book) {
		for (BookInfo bookBean : DataBase.BOOKDB) {
			if (bookBean.getIsbn() == book.getIsbn()) {

				return false;
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
		// throw new LMSException("This book cannot be deleted");
		return false;
	}

	@Override
	public AdminInfo authentication(String adminEmailId, String adminPassword) {
		AdminInfo adminBean = new AdminInfo();
		if (adminBean.getAdminEmailId().equals(adminEmailId) && adminBean.getAdminPassword().equals(adminPassword)) {
			return adminBean;

		}
		throw new LMSException("Invalid Admin credentials");
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
	public boolean bookIssue(UserInfo user, BookInfo book) {
		boolean isValid = false;
		// calendar.setTime(date);
		calendar.add(Calendar.DATE, 15);
		expectedReturnDate = calendar.getTime();

//		UserInfo userInfo = new UserInfo();
//		BookInfo bookInfo = new BookInfo();
		RequestInfo requestInfo = new RequestInfo();

		int noOfBooksBorrowed = user.getNoOfBooksBorrowed();
		for (RequestInfo info : DataBase.REQUESTDB) {
			if (info.getUserInfo().getUserId() == user.getUserId()) {
				if (info.getBookInfo().getIsbn() == book.getIsbn()) {
					requestInfo = info;

					isValid = true;

				}
			}
		}

		if (isValid)

		{
			System.out.println("I am entreing into is valid");

			for (BookInfo info2 : DataBase.BOOKDB) {
				if (info2.getIsbn() == book.getIsbn()) {
					book = info2;
				}

			}

			for (UserInfo userInfo2 : DataBase.USERDB) {
				if (userInfo2.getUserId() == user.getUserId()) {
					user = userInfo2;
					noOfBooksBorrowed = user.getNoOfBooksBorrowed();

				}

			}

			if (noOfBooksBorrowed < 3) {
				System.out.println("entered into no of books borrowed");
				boolean isRemoved = DataBase.BOOKDB.remove(book);
				if (isRemoved) {
					System.out.println("book removed from db");
					System.out.println("enter into removed");
					noOfBooksBorrowed++;
					System.out.println(noOfBooksBorrowed);
					user.setNoOfBooksBorrowed(noOfBooksBorrowed);
					// DataBase.REQUESTDB.remove(requestInfo);
					requestInfo.setIssued(true);
					requestInfo.setIssuedDate(date);
					requestInfo.setExpectedReturnedDate(expectedReturnDate);
					return true;
				} else {
					throw new LMSException("Book can't be borrowed");
				}

			} else {
				throw new LMSException("Student Exceeds maximum limit");
			}

		} else {
			throw new LMSException("Book data or User data is incorrect");

		}
	}

	@Override
	public boolean isBookReceived(UserInfo user, BookInfo book) {
		boolean isValid = false;
		RequestInfo requestInfo1 = new RequestInfo();
		for (RequestInfo requestInfo : DataBase.REQUESTDB) {

			if (requestInfo.getBookInfo().getIsbn() == book.getIsbn()
					&& requestInfo.getUserInfo().getUserId() == user.getUserId() && requestInfo.isReturned() == true) {
				isValid = true;
				requestInfo1 = requestInfo;
				// DataBase.REQUESTDB.remove(requestInfo);
			}
		}
		if (isValid) {
//			for (BookInfo info2 : DataBase.BOOKDB) {
//				if (info2.getIsbn() == book.getIsbn()) {
//					//book = info2;
//					DataBase.BOOKDB.add(info2);
//				}
//			}

			book.setAuthourName(requestInfo1.getBookInfo().getAuthourName());
			book.setBookTitle(requestInfo1.getBookInfo().getBookTitle());
			book.setPrice(requestInfo1.getBookInfo().getPrice());
			DataBase.BOOKDB.add(book);
			DataBase.REQUESTDB.remove(requestInfo1);

			for (UserInfo userInfo2 : DataBase.USERDB) {
				if (userInfo2.getUserId() == user.getUserId()) {
					user = userInfo2;
				}

			}

			int noOfBooksBorrowed = user.getNoOfBooksBorrowed();
			noOfBooksBorrowed--;
			user.setNoOfBooksBorrowed(noOfBooksBorrowed);
			return true;

		}

		return false;
	}
}
