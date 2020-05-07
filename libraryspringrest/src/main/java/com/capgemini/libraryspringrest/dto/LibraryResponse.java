package com.capgemini.libraryspringrest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibraryResponse {
	private boolean error;
	private String message;
	private LibraryUsers libraryUsers;
	private List<LibraryUsers> userList;
	private BookInfo bookInfo;
	private List<BookInfo> bookList;
	private RequestInfo requestInfo;
	private List<RequestInfo> requestList;
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LibraryUsers getLibraryUsers() {
		return libraryUsers;
	}
	public void setLibraryUsers(LibraryUsers libraryUsers) {
		this.libraryUsers = libraryUsers;
	}
	public List<LibraryUsers> getUserList() {
		return userList;
	}
	public void setUserList(List<LibraryUsers> userList) {
		this.userList = userList;
	}
	public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	public List<BookInfo> getBookList() {
		return bookList;
	}
	public void setBookList(List<BookInfo> bookList) {
		this.bookList = bookList;
	}
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}
	public List<RequestInfo> getRequestList() {
		return requestList;
	}
	public void setRequestList(List<RequestInfo> requestList) {
		this.requestList = requestList;
	}
	
}
