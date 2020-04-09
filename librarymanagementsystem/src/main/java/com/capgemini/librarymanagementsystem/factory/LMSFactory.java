package com.capgemini.librarymanagementsystem.factory;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dao.AdminDAOImplementation;
import com.capgemini.librarymanagementsystem.dao.UserDAO;
import com.capgemini.librarymanagementsystem.dao.UserDAOImplementation;
import com.capgemini.librarymanagementsystem.service.Service;
import com.capgemini.librarymanagementsystem.service.ServiceImplementation;
import com.capgemini.librarymanagementsystem.service.UserService;
import com.capgemini.librarymanagementsystem.service.UserServiceImplementation;

public class LMSFactory {
	
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImplementation();
	}
	
	public static Service getServiceDAO() {
		return new ServiceImplementation();
	}
	
	public static UserDAO getUserDAO() {
		return new UserDAOImplementation();
	}
	
	public static UserService getUserServiceDAO() {
		return new UserServiceImplementation();
	}

}
