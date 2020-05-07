package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagementsystem.db.DataBase;
import com.capgemini.librarymanagementsystem.dto.AdminInfo;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class LibraryDAOImplementation implements LibraryDAO {
	Date date = new Date();
	Date expectedReturnDate;
	Date returnedDate;

	@Override
	public boolean register(UserInfo user) {
		for (UserInfo userBean : DataBase.USERDB) {
			if ((userBean.getUserId() == user.getUserId())
					|| (userBean.getUserEmailId().equals(user.getUserEmailId()))) {
				throw new LMSException("Cannot Add User As User Already Exists");
			}
		}

		DataBase.USERDB.add(user);
		return true;
	}

	@Override
	public boolean adminAuthentication(String adminEmailId, String adminPassword) {

		for (AdminInfo adminInfo : DataBase.ADMINDB) {
			if (adminInfo.getAdminEmailId().equalsIgnoreCase(adminEmailId)
					&& adminInfo.getAdminPassword().equals(adminPassword)) {
				return true;
			}
		}
		throw new LMSException("Invalid Admin Credentials");
	}

	@Override
	public boolean userAuthentication(String userEmailId, String userPassword) {
		for (UserInfo userInfo : DataBase.USERDB) {
			if ((userInfo.getUserEmailId().equalsIgnoreCase(userEmailId)) && (userInfo.getUserPassword().equals(userPassword))) {
				return true;
			}
		}
		throw new LMSException("Invalid User Credentials");
	}

	@Override
	public boolean addBook(BookInfo book) {
		for (BookInfo bookBean : DataBase.BOOKDB) {
			if (bookBean.getIsbn() == book.getIsbn()) {
				throw new LMSException("Cannot Add Book, As Book Id Already Exists");
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
		throw new LMSException("Cannot Remove The Book, As Book Id Not Found");
	}

	@Override
	public List<BookInfo> showBooks() {
		List<BookInfo> booksList = new ArrayList<BookInfo>();

		for (BookInfo book : DataBase.BOOKDB) {
			book.getIsbn();
			book.getBookTitle();
			book.getAuthourName();
			book.getPrice();
			book.isAvailable();
			booksList.add(book);
		}

		if (booksList.isEmpty()) {
			throw new LMSException("No Books Found In Library");
		} else {
			return booksList;
		}

	}

	@Override
	public List<BookInfo> searchBook(BookInfo bookInfo) {
		List<BookInfo> booksList = new ArrayList<BookInfo>();

		for (BookInfo bookBean : DataBase.BOOKDB) {

			if (bookBean.getIsbn() == bookInfo.getIsbn()) {
				booksList.add(bookBean);
			} else if (bookBean.getBookTitle().equalsIgnoreCase(bookInfo.getBookTitle())) {
				booksList.add(bookBean);
			} else if (bookBean.getAuthourName().equalsIgnoreCase(bookInfo.getAuthourName())) {
				booksList.add(bookBean);
			}
		}

		if (booksList.isEmpty()) {
			throw new LMSException("Book Not Found");
		} else {
			return booksList;
		}

	}

	@Override
	public List<UserInfo> showUsers() {
		List<UserInfo> usersList = new ArrayList<UserInfo>();

		for (UserInfo userInfo : DataBase.USERDB) {
			userInfo.getUserId();
			userInfo.getUserName();
			userInfo.getUserEmailId();
			userInfo.getNoOfBooksBorrowed();
			usersList.add(userInfo);
		}

		if (usersList.isEmpty()) {
			throw new LMSException("No Users Found");
		} else {
			return usersList;
		}

	}

	@Override
	public List<RequestInfo> showRequests() {
		List<RequestInfo> requestsList = new ArrayList<RequestInfo>();

		for (RequestInfo requestInfo : DataBase.REQUESTDB) {
			requestInfo.getBookId();
			requestInfo.getUserId();
			requestInfo.isIssued();
			requestInfo.isReturned();
			requestsList.add(requestInfo);
		}

		if (requestsList.isEmpty()) {
			throw new LMSException("No Requests Placed");
		} else {
			return requestsList;
		}

	}

	@Override
	public boolean bookRequest(int userId, int bookId) {
		boolean isRequestExists = false;
		RequestInfo requestInfo = new RequestInfo();

		for (RequestInfo requestInfo1 : DataBase.REQUESTDB) {
			if (bookId == requestInfo1.getBookId()) {
				isRequestExists = true;
			}
		}

		if (!isRequestExists) {
			for (UserInfo user : DataBase.USERDB) {
				if (userId == user.getUserId()) {
					for (BookInfo book : DataBase.BOOKDB) {
						if ((book.getIsbn() == bookId) && (book.isAvailable() == true)) {
							requestInfo.setUserId(userId);
							requestInfo.setBookId(bookId);
							requestInfo.setIssued(false);
							DataBase.REQUESTDB.add(requestInfo);
							return true;
						}
					}
				}
			}
		}

		throw new LMSException("Invalid Request");
	}

	@Override
	public boolean bookIssue(int userId, int bookId) {
		RequestInfo requestInfo = new RequestInfo();
		UserInfo user = new UserInfo();
		BookInfo book = new BookInfo();
		int noOfBooksBorrowed = 0;
		boolean isValidReq = false;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 15);
		expectedReturnDate = calendar.getTime();

		for (RequestInfo requestInfo2 : DataBase.REQUESTDB) {
			if (requestInfo2.getUserId() == userId) {
				if ((requestInfo2.getBookId() == bookId) && (requestInfo2.isIssued() == false)) {
					isValidReq = true;
					requestInfo = requestInfo2;
				}
			}
		}

		if (isValidReq) {
			for (BookInfo bookInfo : DataBase.BOOKDB) {
				if (bookInfo.getIsbn() == bookId) {
					book = bookInfo;
				}
			}

			for (UserInfo userInfo : DataBase.USERDB) {
				if (userInfo.getUserId() == userId) {
					user = userInfo;
					noOfBooksBorrowed = user.getNoOfBooksBorrowed();
				}
			}

			if (noOfBooksBorrowed < 3) {
				book.setAvailable(false);
				noOfBooksBorrowed++;
				user.setNoOfBooksBorrowed(noOfBooksBorrowed);
				requestInfo.setIssued(true);
				requestInfo.setIssuedDate(date);
				requestInfo.setExpectedReturnedDate(expectedReturnDate);
				return true;
			} else {
				DataBase.REQUESTDB.remove(requestInfo);
				throw new LMSException("Book Cannot be Issued, as Student Exceeds maximum Borrowing limit");
			}

		} else {
			throw new LMSException("Book Cannot be Issued, as Invalid UserID/BookId");

		}
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		Calendar calendar2 = Calendar.getInstance();
		calendar2.add(Calendar.DATE, 20);
		returnedDate = calendar2.getTime();
//		  System.out.println(returnedDate);

		for (RequestInfo requestInfo : DataBase.REQUESTDB) {
			if (requestInfo.getBookId() == bookId && requestInfo.getUserId() == userId
					&& requestInfo.isIssued() == true) {
				requestInfo.setReturned(true);
				requestInfo.setReturnedDate(returnedDate);
				return true;
			}
		}
		throw new LMSException("Invalid Return");
	}

	@Override
	public boolean isBookReceived(int userId, int bookId) {
		boolean isValidReceive = false;
		RequestInfo requestInfo = new RequestInfo();
		int noOfBooksBorrowed;
		double fine;

		for (RequestInfo requestInfo1 : DataBase.REQUESTDB) {
			if (requestInfo1.getBookId() == bookId && requestInfo1.getUserId() == userId
					&& requestInfo1.isReturned() == true) {
				isValidReceive = true;
				expectedReturnDate = requestInfo1.getExpectedReturnedDate();
				returnedDate = requestInfo1.getReturnedDate();
				requestInfo = requestInfo1;
			}
		}

		if (isValidReceive) {

			long expReturnDateInMilliSecs = expectedReturnDate.getTime();
			long returnedDateInMilliSecs = returnedDate.getTime();
			long diffInMilliSecs = returnedDateInMilliSecs - expReturnDateInMilliSecs;
			int NoOfDaysDelayed = (int) (diffInMilliSecs / (24 * 60 * 60 * 1000));

			for (BookInfo bookInfo : DataBase.BOOKDB) {
				if (bookInfo.getIsbn() == bookId) {
					bookInfo.setAvailable(true);
					break;
				}
			}

			for (UserInfo userInfo : DataBase.USERDB) {
				if (userInfo.getUserId() == userId) {
					noOfBooksBorrowed = userInfo.getNoOfBooksBorrowed();
					noOfBooksBorrowed--;
					userInfo.setNoOfBooksBorrowed(noOfBooksBorrowed);
					fine = userInfo.getFine();
					if (NoOfDaysDelayed > 0) {
						fine = fine + (NoOfDaysDelayed * 5);
						userInfo.setFine(fine);
					}
//					System.out.println("fine :"+fine);
					break;
				}
			}

			DataBase.REQUESTDB.remove(requestInfo);
			return true;
		}
		throw new LMSException("Book Cannot be Received, as Invalid UserId/BookId");
	}

	@Override
	public boolean changePassword(int userId, String oldPassword, String newPassword) {

		for (UserInfo userInfo : DataBase.USERDB) {
			if ((userInfo.getUserId() == userId) && (userInfo.getUserPassword().equals(oldPassword))) {
				userInfo.setUserPassword(newPassword);
				return true;
			}
		}

		throw new LMSException("Password Can't be Changed Due To Invalid Credentials");
	}
}
