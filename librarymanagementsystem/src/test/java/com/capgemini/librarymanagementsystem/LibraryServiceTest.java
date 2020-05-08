package com.capgemini.librarymanagementsystem;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.service.LibraryService;
import com.capgemini.librarymanagementsystem.service.LibraryServiceImplementation;

public class LibraryServiceTest {
	
private LibraryService dao = new LibraryServiceImplementation();
	
	@Test
	public void testShowBooksEmpty() {
		List<BookInfo> list = dao.showBooks();
		Assertions.assertNull(list);
	}

	@Test
	public void testAddBook() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn(567);
		bookInfo.setAuthourName("Savi Sharma");
		bookInfo.setBookTitle("This not your Story");
		bookInfo.setPrice(250);
		bookInfo.setAvailable(true);
		boolean status = dao.addBook(bookInfo);
		Assertions.assertTrue(status);
	}
	

	@Test
//	(expected = LMSException.class)
	public void testAddBook2() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn(765);
		bookInfo.setAuthourName("Savi Sharma");
		bookInfo.setBookTitle("Every One Has A Story");
		bookInfo.setPrice(250);
		bookInfo.setAvailable(true);
		boolean status = dao.addBook(bookInfo);
		Assertions.assertTrue(status);
		
	}
	
	@Test
	public void testRegister() {
		UserInfo info = new UserInfo();
		info.setUserId(901);
		info.setUserEmailId("sril@gmail.com");
		info.setUserName("Sri");
		info.setUserPassword("sril");
		info.setNoOfBooksBorrowed(1);
		
		boolean status = dao.register(info);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testRegister2() {
		UserInfo info = new UserInfo();
		info.setUserId(902);
		info.setUserEmailId("lakshmig@gmail.com");
		info.setUserName("Sri");
		info.setUserPassword("sril");
		info.setNoOfBooksBorrowed(1);
		
		boolean status = dao.register(info);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testDeleteBook() {
		boolean status = dao.deleteBook(765);
		Assertions.assertTrue(status);
		
	}
	
	@Test
	public void testShowBooks() {
		List<BookInfo> list = dao.showBooks();
		Assertions.assertNotNull(list);
	}
	
	
	
	@Test
	public void testRequest() {		
		boolean status = dao.bookRequest(901, 567);
//		RequestInfo info = new RequestInfo();
//		info.setIssued(false);
		Assertions.assertTrue(status);		
	}
	
	
	@Test
	public void testIssue() {
		boolean status = dao.bookIssue(901, 567);
		Assertions.assertTrue(status);		
	}
	
	@Test
	public void testReturn() {
		boolean status = dao.bookIssue(901, 567);
		Assertions.assertTrue(status);		
	}
	
	@Test
	public void testReceive() {
		boolean status = dao.bookIssue(901, 567);
		Assertions.assertTrue(status);		
	}
	
	
	
	@Test
	public void testUserLogin() {
		boolean status = dao.userAuthentication("sril@gmail.com", "sril");
		Assertions.assertTrue(status);		
	}
	
	@Test
	public void testChangePassword() {
		boolean status = dao.changePassword(901, "sril","lakshmi");
		Assertions.assertTrue(status);		
	}
	
}

