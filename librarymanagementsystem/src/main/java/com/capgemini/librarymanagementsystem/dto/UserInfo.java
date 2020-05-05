package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserInfo implements Serializable {

	private int userId;
	private String userName;
	private String userEmailId;
	private String userPassword;
	private int noOfBooksBorrowed;
	private double fine;

	public UserInfo() {
		super();
	}

	public UserInfo(int userId, String userName, String userEmailId, String userPassword, int noOfBooksBorrowed,
			double fine) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmailId = userEmailId;
		this.userPassword = userPassword;
		this.noOfBooksBorrowed = noOfBooksBorrowed;
		this.fine = fine;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getNoOfBooksBorrowed() {
		return noOfBooksBorrowed;
	}

	public void setNoOfBooksBorrowed(int noOfBooksBorrowed) {
		this.noOfBooksBorrowed = noOfBooksBorrowed;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userEmailId=" + userEmailId
				+ ", userPassword=" + userPassword + ", noOfBooksBorrowed=" + noOfBooksBorrowed + ", fine=" + fine
				+ "]";
	}

}
