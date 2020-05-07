package com.capgemini.libraryspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.libraryspringrest.dto.BookInfo;
import com.capgemini.libraryspringrest.dto.LibraryResponse;
import com.capgemini.libraryspringrest.dto.LibraryUsers;
import com.capgemini.libraryspringrest.dto.RequestInfo;
import com.capgemini.libraryspringrest.service.LibraryService;

@RestController
public class LibraryRestController {

	@Autowired
	private LibraryService service;

//	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST, consumes = {
//			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
//					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

//	@PostMapping(path = "/adminLogin", consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
//					MediaType.APPLICATION_XML_VALUE })
//	public LibraryResponse adminLogin(@RequestBody int id, @RequestBody String password) {
//		boolean isLogin = service.adminAuthentication(id, password);
//
//		LibraryResponse response = new LibraryResponse();
//		if (isLogin) {
//			response.setMessage("User Added Successfully");
//		} else {
//			response.setError(true);
//			response.setMessage("User Already Exists");
//		}
//		return response;
//	}

//	@PostMapping(path = "/adminLogin", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//	public LibraryResponse adminLogin(@RequestBody Map<Integer,String> inputJson) {
////			@RequestBody Map<String, String> inputJson2) {
////		int id = inputJson.get("id");

	@PostMapping(path = "/adminLogin", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse adminLogin(@RequestParam int id, String password) {

		boolean isLogin = service.adminAuthentication(id, password);

		LibraryResponse response = new LibraryResponse();
		if (isLogin) {
			response.setMessage("Admin Logged in Successfully");
		} else {
			response.setError(true);
			response.setMessage("Admin Details was invalid, Unable to login");
		}
		return response;
	}
	
	@PostMapping(path = "/userLogin", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse userLogin(@RequestParam int id, String password) {

		boolean isLogin = service.userAuthentication(id, password);

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
			response.setMessage("record deleted for id" + isbn);
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

	@GetMapping(path = "/requestBook/{userId}/{bookId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse requestBook(@PathVariable(name = "userId") int userId,
			@PathVariable(name = "bookId") int bookId) {
		boolean isRequested = service.bookRequest(userId, bookId);
		LibraryResponse response = new LibraryResponse();
		if (isRequested) {
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
			;
		} else {
			response.setError(true);
			response.setMessage("No Books Found In the Library");
		}

		return response;
	}

	@GetMapping(path = "/issueBook/{reqId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse issueBook(@PathVariable(name = "reqId") int requestId) {
		boolean isIssued = service.isBookIssued(requestId);

		LibraryResponse response = new LibraryResponse();
		if (isIssued) {
			response.setMessage("Book Request Placed Successfully");
		} else {
			response.setError(true);
			response.setMessage("Request Can't Be Placed to Admin");
		}
		return response;
	}

	@GetMapping(path = "/returnBook/{userId}/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse returnBook(@PathVariable(name = "userId") int userId,
			@PathVariable(name = "bookId") int bookId) {
		boolean isReturned = service.bookReturn(userId, bookId);
		LibraryResponse response = new LibraryResponse();
		if (isReturned) {
			response.setMessage("Book returned To Admin Successfully");
		} else {
			response.setError(true);
			response.setMessage(" Can't Returned The Book To Admin");
		}
		return response;
	}

	@GetMapping(path = "/receiveBook/{reqId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryResponse receiveBook(@PathVariable(name = "reqId") int requestId) {
		boolean isIssued = service.isBookReceived(requestId);

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

}
