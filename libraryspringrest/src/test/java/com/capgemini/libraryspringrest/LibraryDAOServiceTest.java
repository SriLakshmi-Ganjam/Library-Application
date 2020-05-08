package com.capgemini.libraryspringrest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.libraryspringrest.dto.BookInfo;
import com.capgemini.libraryspringrest.dto.LibraryUsers;
import com.capgemini.libraryspringrest.dto.RequestInfo;
import com.capgemini.libraryspringrest.service.LibraryService;

public class LibraryDAOServiceTest {
	@Autowired
	private LibraryService dao;

	@Test
	public void testAddBook() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn(201);
		bookInfo.setAuthourName("Savi Sharma");
		bookInfo.setBookTitle("Every One Has A Story");
		bookInfo.setPrice(250);
		bookInfo.setAvailable(true);
		boolean status = dao.addBook(bookInfo);
		Assertions.assertTrue(status);
	}

	public void testAddBook2() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn(202);
		bookInfo.setAuthourName("Savi Sharma");
		bookInfo.setBookTitle("Every One Has A Story");
		bookInfo.setPrice(250);
		bookInfo.setAvailable(true);
		boolean status = dao.addBook(bookInfo);
		Assertions.assertTrue(status);
	}

	@Test
	public void testDeleteBook() {
		boolean status = dao.deleteBook(201);
		Assertions.assertTrue(status);

	}

	@Test
	public void testRegister() {
		LibraryUsers info = new LibraryUsers();
		info.setId(202);
		info.setEmailId("saig@gmail.com");
		info.setName("Sai");
		info.setPassword("sril");
		info.setRole("Admin");

		boolean status = dao.register(info);
		Assertions.assertTrue(status);
	}

	@Test
	public void testShowBooks() {
		List<BookInfo> list = dao.showBooks();
		Assertions.assertNotNull(list);
	}

	@Test
	public void testShowUsers() {
		List<LibraryUsers> list = dao.showUsers();
		Assertions.assertNotNull(list);
	}

	@Test
	public void testShowUsersEmpty() {
		List<LibraryUsers> list = dao.showUsers();
		Assertions.assertNull(list);
	}

	@Test
	public void testShowRequests() {
		List<RequestInfo> list = dao.showRequests();
		Assertions.assertNotNull(list);
	}

	@Test
	public void testRequest() {
		boolean status = dao.bookRequest(201, 201);
		Assertions.assertTrue(status);
	}

	@Test
	public void testIssue() {
		boolean status = dao.isBookIssued(18);
		Assertions.assertTrue(status);
	}

	@Test
	public void testReturn() {
		boolean status = dao.bookReturn(201, 201);
		Assertions.assertTrue(status);
	}

//
	@Test
	public void testReceive() {
		boolean status = dao.isBookReceived(18);
		Assertions.assertTrue(status);
	}

	@Test
	public void testUserLogin() {
		boolean status = dao.userAuthentication(333, "padma");
		Assertions.assertTrue(status);
	}
}