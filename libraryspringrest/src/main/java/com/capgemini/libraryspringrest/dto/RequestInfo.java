package com.capgemini.libraryspringrest.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "bookrequests")
public class RequestInfo implements Serializable {

	@Id
	@Column
	@GeneratedValue
	private int requestId;
	@Column
	private int userId;
	@Column
	private int bookId;
	@Column
	private Date issuedDate;
	@Column
	private Date returnedDate;
	@Column
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

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date date) {
		this.issuedDate = date;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "bookrequests", joinColumns = { @JoinColumn(name = "requestId") }, inverseJoinColumns = {
//			@JoinColumn(name = "userId") })
//	private List<LibraryUsers> users;
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "bookrequests", joinColumns = { @JoinColumn(name = "requestId") }, inverseJoinColumns = {
//			@JoinColumn(name = "bookId") })
//	private List<BookInfo> books;

}
