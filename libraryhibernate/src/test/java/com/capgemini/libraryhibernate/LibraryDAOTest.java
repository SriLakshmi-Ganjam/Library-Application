package com.capgemini.libraryhibernate;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.libraryhibernate.dao.LibraryDAO;
import com.capgemini.libraryhibernate.dao.LibraryDAOImplementation;
import com.capgemini.libraryhibernate.dto.BookInfo;
import com.capgemini.libraryhibernate.dto.LibraryUsers;
import com.capgemini.libraryhibernate.dto.RequestInfo;

public class LibraryDAOTest {
	private LibraryDAO dao = new LibraryDAOImplementation();

	@Test
	public void testAddBook() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn(999);
		bookInfo.setAuthourName("Savi Sharma");
		bookInfo.setBookTitle("Every One Has A Story");
		bookInfo.setPrice(250);
		bookInfo.setAvailable(true);
		boolean status = dao.addBook(bookInfo);
		Assertions.assertTrue(status);
	}

	public void testAddBook2() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn(888);
		bookInfo.setAuthourName("Savi Sharma");
		bookInfo.setBookTitle("Every One Has A Story");
		bookInfo.setPrice(250);
		bookInfo.setAvailable(true);
		boolean status = dao.addBook(bookInfo);
		Assertions.assertTrue(status);
	}

	@Test
	public void testDeleteBook() {
		boolean status = dao.deleteBook(888);
		Assertions.assertTrue(status);

	}

	@Test
	public void testRegister() {
		LibraryUsers info = new LibraryUsers();
		info.setId(901);
		info.setEmailId("sai@gmail.com");
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
		boolean status = dao.bookRequest(444, 333);
		Assertions.assertTrue(status);
	}

	@Test
	public void testIssue() {
		boolean status = dao.isBookIssued(18);
		Assertions.assertTrue(status);
	}

	@Test
	public void testReturn() {
		boolean status = dao.bookReturn(444, 333);
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

	@Test
	public void testChangePassword() {
		boolean status = dao.changePassword(111, "sril", "lakshmi");
		Assertions.assertTrue(status);
	}

	@Test
	public void testSearchById() {
		BookInfo info = new BookInfo();
		info.setIsbn(111);
		List<BookInfo> list = dao.searchBook(info);

		Assertions.assertNotNull(list);
	}

	@Test
	public void testSearchByName() {
		BookInfo info = new BookInfo();
		info.setBookTitle("life");
		List<BookInfo> list = dao.searchBook(info);

		Assertions.assertNotNull(list);
	}

	@Test
	public void testSearchByAuthour() {
		BookInfo info = new BookInfo();
		info.setAuthourName("sri");
		List<BookInfo> list = dao.searchBook(info);

		Assertions.assertNotNull(list);
	}

}
