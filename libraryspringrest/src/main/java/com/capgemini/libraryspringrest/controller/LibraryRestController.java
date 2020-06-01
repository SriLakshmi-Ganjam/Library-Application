package com.capgemini.libraryspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.libraryspringrest.dto.BookInfo;
import com.capgemini.libraryspringrest.dto.LibraryHistory;
import com.capgemini.libraryspringrest.dto.LibraryResponse;
import com.capgemini.libraryspringrest.dto.LibraryUsers;
import com.capgemini.libraryspringrest.dto.RequestInfo;
import com.capgemini.libraryspringrest.service.LibraryService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class LibraryRestController {

	@Autowired
	private LibraryService service;

	@GetMapping(path = "/getReqBooks", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse getReqBooks() {
		List<RequestInfo> requestInfo = service.getRequestedBooks();

		LibraryResponse response = new LibraryResponse();
		if ((requestInfo != null) && (!requestInfo.isEmpty())) {
			response.setMessage("Book Request Placed Successfully");
			response.setRequestList(requestInfo);
		} else {
			response.setError(true);
			response.setMessage("Request Can't Be Placed to Admin");
		}
		return response;
	}

	@GetMapping(path = "/getReturnedBooks", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse getReturnedBooks() {
		List<RequestInfo> requestInfo = service.getReturnedBooks();

		LibraryResponse response = new LibraryResponse();
		if ((requestInfo != null) && (!requestInfo.isEmpty())) {
			response.setMessage("Books Returned");
			response.setRequestList(requestInfo);
		} else {
			response.setError(true);
			response.setMessage("Request Can't Be Placed to Admin");
		}
		return response;
	}

	@GetMapping(path = "/userReq/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse userTakenBooks(@PathVariable int userId) {
		List<RequestInfo> requestInfo = service.userTakenBooks(userId);
		LibraryResponse response = new LibraryResponse();
		if ((requestInfo != null) && (!requestInfo.isEmpty())) {
			response.setMessage("Books Borrowed by User");
			response.setRequestList(requestInfo);
		} else {
			response.setError(true);
			response.setMessage("No Books Borrowed By User");
		}
		return response;
	}

	@PostMapping(path = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse adminLogin(@RequestBody LibraryUsers libraryUsers) {

		boolean isLogin = service.adminAuthentication(libraryUsers.getEmailId(), libraryUsers.getPassword());

		LibraryResponse response = new LibraryResponse();
		if (isLogin) {
			// need to get user details from Db
			LibraryUsers loginUser = service.getUser(libraryUsers.getEmailId());
			if (loginUser != null) {
				response.setError(false);
				response.setLibraryUsers(loginUser);
				response.setMessage(" Logged in Successfully");
			} else {
				response.setError(true);
				response.setMessage("Invalid Login Credentials");
			}

		} else {
			response.setError(true);
			response.setMessage("Admin Details was invalid, Unable to login");
		}
		return response;
	}

	@PostMapping(path = "/userLogin", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse userLogin(@RequestBody LibraryUsers libraryUsers) {

		boolean isLogin = service.userAuthentication(libraryUsers.getEmailId(), libraryUsers.getPassword());

		LibraryResponse response = new LibraryResponse();
		if (isLogin) {
			response.setMessage("User Logged in Successfully");
		} else {
			response.setError(true);
			response.setMessage("User Details was invalid, Unable to login");
		}
		return response;
	}

	@PostMapping(path = "/addUser", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse addUser(@RequestBody LibraryUsers libraryUsers) {
		boolean isAdded = service.register(libraryUsers);
		LibraryResponse response = new LibraryResponse();
		if (isAdded) {
			response.setMessage("User Added Successfully");
		} else {
			response.setError(true);
			response.setMessage("User Already Exists");
		}
		return response;
	}// End Of Add Book

	@GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse getAllUsers() {
		List<LibraryUsers> userList = service.showUsers();
		LibraryResponse response = new LibraryResponse();
		if (userList != null && !userList.isEmpty()) {
			response.setUserList(userList);
		} else {
			response.setError(true);
			response.setMessage("No Users Found");
		}

		return response;
	}

	@PostMapping(path = "/addBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse addBook(@RequestBody BookInfo bookInfo) {
		boolean isAdded = service.addBook(bookInfo);
		LibraryResponse response = new LibraryResponse();
		if (isAdded) {
			response.setMessage("Book Added Successfully");
		} else {
			response.setError(true);
			response.setMessage("Book Details which was given is already present. Unable to add book");
		}
		return response;
	}

	@DeleteMapping(path = "/deleteBook/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse bookDelete(@PathVariable(name = "bookId") int isbn) {
		LibraryResponse response = new LibraryResponse();
		boolean isDeleted = service.deleteBook(isbn);
		if (isDeleted) {
			response.setMessage("Book Id " + isbn + " deleted Sucessfully");
		} else {
			response.setError(true);
			response.setMessage("No Records found to delete/unble to delete " + isbn);
		}
		return response;
	}// End of Delete

	@GetMapping(path = "/getAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse getAllBooks() {
		List<BookInfo> bookList = service.showBooks();
		LibraryResponse response = new LibraryResponse();
		if (bookList != null && !bookList.isEmpty()) {
			response.setBookList(bookList);
		} else {
			response.setError(true);
			response.setMessage("No Books Found In the Library");
		}

		return response;
	}

//	

	@PostMapping(path = "/requestBook/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse requestBook(@RequestBody BookInfo requestInfo, @PathVariable int userId) {
		boolean isRequested = service.bookRequest(userId, requestInfo.getIsbn());

		LibraryResponse response = new LibraryResponse();
		if (isRequested) {
			response.setError(false);
			response.setMessage("Book Request Placed Successfully");
		} else {
			response.setError(true);
			response.setMessage("Request Can't Be Placed to Admin");
		}
		return response;
	}

	@GetMapping(path = "/getAllRequests", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse getAllRequests() {
		List<RequestInfo> requestList = service.showRequests();

		LibraryResponse response = new LibraryResponse();
		if (requestList != null && !requestList.isEmpty()) {
			response.setRequestList(requestList);

		} else {
			response.setError(true);
			response.setMessage("No Books Found In the Library");
		}

		return response;
	}

	@PostMapping(path = "/issueBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse issueBook(@RequestBody RequestInfo requestInfo) {
		boolean isIssued = service.isBookIssued(requestInfo.getRequestId());

		LibraryResponse response = new LibraryResponse();
		if (isIssued) {
			response.setMessage("BookIssued Successfully");
		} else {
			response.setError(true);
			response.setMessage("Book Can't be Issued");
		}
		return response;
	}

	@PostMapping(path = "/returnBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse returnBook(@RequestBody RequestInfo requestInfo) {
		boolean isReturned = service.bookReturn(requestInfo.getUserId(), requestInfo.getBookId());
		LibraryResponse response = new LibraryResponse();
		if (isReturned) {
			response.setMessage("Book returned To Admin Successfully");
		} else {
			response.setError(true);
			response.setMessage(" Can't Returned The Book To Admin");
		}
		return response;
	}

	@PostMapping(path = "/receiveBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse receiveBook(@RequestBody RequestInfo requestInfo) {
		boolean isIssued = service.isBookReceived(requestInfo.getRequestId());

		LibraryResponse response = new LibraryResponse();
		if (isIssued) {
			response.setMessage("Book Received Successfully");
		} else {
			response.setError(true);
			response.setMessage("Unable to Receive, Invalid Request");
		}
		return response;
	}

	@PostMapping(path = "/searchBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse searchBook(@RequestBody BookInfo bookInfo) {
		List<BookInfo> bookList = service.searchBook(bookInfo);

		LibraryResponse response = new LibraryResponse();
		if ((bookList != null) && (!bookList.isEmpty())) {
			response.setBookList(bookList);
		} else {
			response.setError(true);
			response.setMessage("Unable to Search, Invalid Searching");
		}
		return response;
	}

	@PostMapping(path = "/updateBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse updateBook(@RequestBody BookInfo bookInfo) {
		BookInfo book = service.updateBook(bookInfo);

		LibraryResponse response = new LibraryResponse();
		if ((book != null)) {
			response.setError(false);
			response.setBookInfo(book);
		} else {
			response.setError(true);
			response.setMessage("Unable to Update");
		}
		return response;
	}

	@GetMapping(path = "/getAllHistory", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse getAllHistory() {
		List<LibraryHistory> libHistory = service.getLibHistory();

		LibraryResponse response = new LibraryResponse();
		if (libHistory != null && !libHistory.isEmpty()) {
			response.setHistoryList(libHistory);

		} else {
			response.setError(true);
			response.setMessage("No Books History Found");
		}
		return response;
	}

	@GetMapping(path = "/userHistory/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse userHistory(@PathVariable int userId) {
		List<LibraryHistory> userHistory = service.getUserHistory(userId);
		LibraryResponse response = new LibraryResponse();
		if ((userHistory != null) && (!userHistory.isEmpty())) {
			response.setMessage("Requests Books lists");
			response.setHistoryList(userHistory);
		} else {
			response.setError(true);
			response.setMessage("No History Found for User");
		}
		return response;
	}
}
