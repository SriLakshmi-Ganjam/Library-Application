package com.capgemini.librarymanagementsystemjdbc.dto;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class RequestInfo implements Serializable {

	private int requestId;
	private int userId;
	private int bookId;
	private Date issuedDate;
	private Date returnedDate;
	private Date expectedReturnDate;

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


	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnedDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
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

//	p
}
