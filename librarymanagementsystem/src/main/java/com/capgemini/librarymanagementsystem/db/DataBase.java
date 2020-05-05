package com.capgemini.librarymanagementsystem.db;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminInfo;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public class DataBase {
		
	public static final List<AdminInfo> ADMINDB = new ArrayList<AdminInfo>();	
	public static final List<UserInfo> USERDB = new ArrayList<UserInfo>();
	public static final List<BookInfo> BOOKDB = new ArrayList<BookInfo>();
	public static final List<RequestInfo> REQUESTDB = new ArrayList<RequestInfo>();
	
	public static void addToDB() {
		
		ADMINDB.add(new AdminInfo(1, "Sri", "sri@gmail.com","sri1234"));
		ADMINDB.add(new AdminInfo(2, "Bhagya","bhagya@gmail.com", "Bhagya"));
		
		USERDB.add(new UserInfo(111,"Lakshmi","lakshmi@gmail.com","lakshmi",3,0));
		USERDB.add(new UserInfo(222,"Bhargavi","bhargavi@gmail.com","bhargavi",1,5));
		USERDB.add(new UserInfo(333,"padma","padma@gmail.com","padma",0,0));
		
		BOOKDB.add(new BookInfo(101,"Life","Gopal Das",200,true));
		BOOKDB.add(new BookInfo(102,"Monk Who Sold His Ferari","Robin Sharma",300,true));
		BOOKDB.add(new BookInfo(103,"Die","Robin Sharma",250,true));
		BOOKDB.add(new BookInfo(104,"C","Bala Guru Swamy",200,true));
		BOOKDB.add(new BookInfo(105,"Java","James",500,false));
						
	}
}
