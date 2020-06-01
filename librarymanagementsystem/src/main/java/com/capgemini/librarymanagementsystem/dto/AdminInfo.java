package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminInfo implements Serializable {

	private int adminId;
	private String adminName;
	private String adminEmailId;
	private String adminPassword;	

	public AdminInfo() {

	}

	public AdminInfo(int adminId, String adminName, String adminEmailId, String adminPassword) {
//		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmailId = adminEmailId;
		this.adminPassword = adminPassword;
	}

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

	@Override
	public String toString() {
		return "AdminInfo [adminId=" + adminId + ", adminName=" + adminName + ", adminEmailId=" + adminEmailId
				+ ", adminPassword=" + adminPassword + "]";
	}

	
}
