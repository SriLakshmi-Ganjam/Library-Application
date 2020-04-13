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
	public boolean adminAuthentication(String adminEmailId, String adminPassword) {
		AdminInfo adminInfo = new AdminInfo();
		
		if (adminInfo.getAdminEmailId().equals(adminEmailId) && adminInfo.getAdminPassword().equals(adminPassword)) {
			return true;
		}
		throw new LMSException("Invalid Admin credentials");
	}

	@Override
	public boolean userAuthentication(String userEmailId, String userPassword) {
		for (UserInfo userInfo : DataBase.USERDB) {
			if ((userInfo.getUserEmailId().equals(userEmailId)) && (userInfo.getUserPassword().equals(userPassword))) {
				return true;
			}
		}
		throw new LMSException("Invalid user credentials");
	}

	@Override
	public boolean addBook(BookInfo book) {
		for (BookInfo bookBean : DataBase.BOOKDB) {
			if (bookBean.getIsbn() == book.getIsbn()) {
				throw new LMSException("Book Id Already Exists");
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
		throw new LMSException("Book Id Not Found");
	}

	@Override
	public List<BookInfo> showBooks() {
		List<BookInfo> booksList = new LinkedList<BookInfo>();

		for (BookInfo book : DataBase.BOOKDB) {
			book.getIsbn();
			book.getBookTitle();
			book.getAuthourName();
			book.getPrice();
			book.isAvailable();
			booksList.add(book);
		}
		return booksList;
	}

	@Override
	public List<BookInfo> searchBook(BookInfo bookInfo) {
		List<BookInfo> booksList = new LinkedList<BookInfo>();

		for (BookInfo bookBean : DataBase.BOOKDB) {
			try {
				if (bookBean.getIsbn() == bookInfo.getIsbn()) {
					booksList.add(bookBean);
				} else if (bookBean.getBookTitle().equalsIgnoreCase(bookInfo.getBookTitle())) {
					booksList.add(bookBean);
				} else if (bookBean.getAuthourName().equalsIgnoreCase(bookInfo.getAuthourName())) {
					booksList.add(bookBean);
				}
			} catch (LMSException e) {
				throw new LMSException("No Book Found");
			}
		}
		return booksList;
	}

	@Override
	public List<UserInfo> showUsers() {
		List<UserInfo> usersList = new LinkedList<UserInfo>();

		for (UserInfo userInfo : DataBase.USERDB) {
			try {
				userInfo.getUserId();
				userInfo.getUserName();
				userInfo.getUserEmailId();
				userInfo.getNoOfBooksBorrowed();
				usersList.add(userInfo);
			} catch (LMSException e) {
				throw new LMSException("No Users Found");
			}
		}
		return usersList;
	}

	@Override
	public List<RequestInfo> showRequests() {
		List<RequestInfo> requestsList = new LinkedList<RequestInfo>();

		for (RequestInfo requestInfo : DataBase.REQUESTDB) {
			try {
				requestInfo.getBookId();
				requestInfo.getUserId();
				requestInfo.isIssued();
				requestInfo.isReturned();
				requestsList.add(requestInfo);
			} catch (LMSException e) {
				throw new LMSException("No Requests Placed");
			}
		}
		return requestsList;
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

		throw new LMSException("Invalid request or you cannot request that book");
	}

	@Override
	public boolean bookIssue(int userId, int bookId) {
		RequestInfo requestInfo = new RequestInfo();
		UserInfo user = new UserInfo();
		BookInfo book = new BookInfo();
		int noOfBooksBorrowed = 0;
		boolean isValidReq = false;
		calendar.add(Calendar.DATE, 15);
		expectedReturnDate = calendar.getTime();

		for (RequestInfo requestInfo2 : DataBase.REQUESTDB) {
			if (requestInfo2.getUserId() == userId) {
				if ((requestInfo2.getBookId() == bookId)&&(requestInfo2.isIssued() == false)) {
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
				throw new LMSException("Student Exceeds maximum Borrowing limit");
			}

		} else {
			throw new LMSException("Invalid UserID/BookId");

		}
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		Date returnDate = new Date();

		for (RequestInfo requestInfo : DataBase.REQUESTDB) {
			if (requestInfo.getBookId() == bookId && requestInfo.getUserId() == userId
					&& requestInfo.isIssued() == true) {
				requestInfo.setReturned(true);
				requestInfo.setReturnedDate(returnDate);
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

		for (RequestInfo requestInfo1 : DataBase.REQUESTDB) {
			if (requestInfo1.getBookId() == bookId && requestInfo1.getUserId() == userId
					&& requestInfo1.isReturned() == true) {
				isValidReceive = true;
				requestInfo = requestInfo1;
			}
		}

		if (isValidReceive) {
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
					break;
				}
			}

			DataBase.REQUESTDB.remove(requestInfo);
			return true;
		}
		throw new LMSException("Invalid Recive");
	}
}
