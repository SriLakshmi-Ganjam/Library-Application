package com.capgemini.librarymanagementsystemjdbc.dto;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class RequestInfo implements Serializable {

//	private BookInfo bookInfo;
//	private LibraryUsers userInfo;

	private int requestId;

	private int userId;
	private int bookId;

	private boolean isIssued;
	private boolean isReturned;
	private Date issuedDate;
	private Date returnedDate;
	private Date expectedReturnedDate;
	private double fine;
	
	

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public Date getExpectedReturnedDate() {
		return expectedReturnedDate;
	}

	public void setExpectedReturnedDate(Date expectedReturnedDate) {
		this.expectedReturnedDate = expectedReturnedDate;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
//	public BookInfo getBookInfo() {
//		return bookInfo;
//	}
//	public void setBookInfo(BookInfo bookInfo) {
//		this.bookInfo = bookInfo;
//	}
//	public LibraryUsers getUserInfo() {
//		return userInfo;
//	}
//	public void setUserInfo(LibraryUsers userInfo) {
//		this.userInfo = userInfo;
//	}
//	

}
