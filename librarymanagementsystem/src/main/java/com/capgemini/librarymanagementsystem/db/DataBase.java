package com.capgemini.librarymanagementsystem.db;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminInfo;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public class DataBase {
	AdminInfo adminBean = new AdminInfo();

	public static final List<AdminInfo> ADMINDB = new LinkedList<AdminInfo>();
	public static final List<UserInfo> USERDB = new LinkedList<UserInfo>();
	public static final List<BookInfo> BOOKDB = new LinkedList<BookInfo>();
	public static final List<RequestInfo> REQUESTDB = new LinkedList<RequestInfo>();
}
