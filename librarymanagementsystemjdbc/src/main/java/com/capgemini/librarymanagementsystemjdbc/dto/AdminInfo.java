package com.capgemini.librarymanagementsystemjdbc.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminInfo implements Serializable {

	private  int adminId = 1;
	private String adminName = "sri";
	private String adminPassword = "Sri@1234";
	private String adminEmailId = "sri@gmail.com";
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminEmailId() {
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
	
	
}
