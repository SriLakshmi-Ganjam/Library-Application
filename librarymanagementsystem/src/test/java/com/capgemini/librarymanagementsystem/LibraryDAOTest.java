package com.capgemini.librarymanagementsystem;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dao.LibraryDAO;
import com.capgemini.librarymanagementsystem.dao.LibraryDAOImplementation;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public class LibraryDAOTest {
	private LibraryDAO dao = new LibraryDAOImplementation();
	
	@Test
	public void testShowBooksEmpty() {
		List<BookInfo> list = dao.showBooks();
		Assertions.assertNull(list);
	}

	@Test
	public void testAddBook() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn(111);
		bookInfo.setAuthourName("Savi Sharma");
		bookInfo.setBookTitle("Every One Has A Story");
		bookInfo.setPrice(250);
		bookInfo.setAvailable(true);
		boolean status = dao.addBook(bookInfo);
		Assertions.assertTrue(status);
	}
	

	@Test
//	(expected = LMSException.class)
	public void testAddBook2() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn(222);
		bookInfo.setAuthourName("Savi Sharma");
		bookInfo.setBookTitle("Every One Has A Story");
		bookInfo.setPrice(250);
		bookInfo.setAvailable(true);
		boolean status = dao.addBook(bookInfo);
	//Assertions.assertFalse(status);
		Assertions.assertTrue(status);
//		Assertions.fail();
		
	}
	
	@Test
	public void testRegister() {
		UserInfo info = new UserInfo();
		info.setUserId(111);
		info.setUserEmailId("sri@gmail.com");
		info.setUserName("Sri");
		info.setUserPassword("sril");
		info.setNoOfBooksBorrowed(1);
		
		boolean status = dao.register(info);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testRegister2() {
		UserInfo info = new UserInfo();
		info.setUserId(222);
		info.setUserEmailId("lakshmi@gmail.com");
		info.setUserName("Sri");
		info.setUserPassword("sril");
		info.setNoOfBooksBorrowed(1);
		
		boolean status = dao.register(info);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testDeleteBook() {
		boolean status = dao.deleteBook(222);
		Assertions.assertTrue(status);
		
	}
	
	@Test
	public void testShowBooks() {
		List<BookInfo> list = dao.showBooks();
		Assertions.assertNotNull(list);
	}
	
	
	
	@Test
	public void testShowUsers() {
		List<UserInfo> list = dao.showUsers();
		Assertions.assertNotNull(list);
	}
	
	@Test
	public void testShowUsersEmpty() {
		List<UserInfo> list = dao.showUsers();
		Assertions.assertNull(list);
	}
	
	@Test
	public void testRequest() {		
		boolean status = dao.bookRequest(111, 111);
//		RequestInfo info = new RequestInfo();
//		info.setIssued(false);
		Assertions.assertTrue(status);		
	}
	
	@Test
	public void testShowReqs() {
		List<RequestInfo> list = dao.showRequests();
		Assertions.assertNotNull(list);
	}
	
	@Test
	public void testIssue() {
		boolean status = dao.bookIssue(111, 111);
		Assertions.assertTrue(status);		
	}
	
	@Test
	public void testReturn() {
		boolean status = dao.bookIssue(111, 111);
		Assertions.assertTrue(status);		
	}
	
	@Test
	public void testReceive() {
		boolean status = dao.bookIssue(111, 111);
		Assertions.assertTrue(status);		
	}
	
	
	
	@Test
	public void testUserLogin() {
		boolean status = dao.userAuthentication("sri@gmail.com", "sril");
		Assertions.assertTrue(status);		
	}
	
	@Test
	public void testChangePassword() {
		boolean status = dao.changePassword(111, "sril","lakshmi");
		Assertions.assertTrue(status);		
	}
	
	@Test
	public void testAdminLogin() {
		boolean status = dao.adminAuthentication("sri@gmail.com", "sril");
		Assertions.assertTrue(status);		
	}

}






