package com.capgemini.librarymanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.LMSException;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;
import com.capgemini.librarymanagementsystem.service.LibraryService;
import com.capgemini.librarymanagementsystem.validation.LibraryValidation;

public class LibraryController {
	private static final LibraryService SERVICE = LMSFactory.getLibraryServiceDAO();
	private static final LibraryValidation VALIDATION = new LibraryValidation();
	public static Scanner scanner = new Scanner(System.in);

	public static int checkChoice() {
		boolean flag = false;
		int choice = 0;
		do {
			try {
				choice = scanner.nextInt();
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Choice should contails only digits(0-9) ");
				scanner.next();
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return choice;
	}

	public static int checkId() {
		boolean flag = false;
		int id = 0;
		do {
			try {
				id = scanner.nextInt();
				VALIDATION.validateId(id);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Id Should contains only digits(0-9)");
				scanner.next();
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		return id;
	}

	public static String checkName() {
		String name = null;
		boolean flag = false;
		do {
			try {
				name = scanner.nextLine();
				VALIDATION.validateName(name);
				flag = true;
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		// return userName.toLowerCase();
		return name;

	}

	public static String checkEmailId() {
		String emailId = null;
		boolean flag = false;
		do {
			try {
				emailId = scanner.next();
				VALIDATION.validateEmail(emailId);
				flag = true;
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return emailId;
	}

	public static String checkPassword() {
		String password = null;
		boolean flag = false;
		do {
			try {
				password = scanner.next();
				VALIDATION.validatePassword(password);
				flag = true;
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return password;
	}

	private static Double checkPrice() {
		boolean flag = false;
		double price = 0;
		do {
			try {
				price = scanner.nextInt();
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Price should contails only digits ");
				scanner.next();
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return price;
	}

	private static boolean checkAvailability() {
		boolean isAvail = false;
		boolean flag = false;
		do {
			try {
				isAvail = scanner.nextBoolean();
				flag = true;
			} catch (InputMismatchException e) {
				System.err.println("Enter Boolean value true/false");
				flag = false;
				scanner.next();
			}
		} while (!flag);
		return isAvail;
	}

	public static void main(String[] args) {
		UserInfo userInfo = null;
		BookInfo bookInfo = null;
		int choice = 0;
		int check = 0;
		int userChoice = 0;
		int userId = 0;
		int bookId = 0;
		String emailId = null;
		String password = null;
		String name = null;
		String bookTitle = null;
		Double price = 0.0;
		boolean isAvail = false;

		do {
			System.out.println("1.Amin Login");
			System.out.println("2. User Login");
			System.out.println("Enter your choice");
			choice = checkChoice();

			switch (choice) {
			case 1:
				System.out.println("-----------------");
				System.out.println("Enter Admin Email id");
				emailId = checkEmailId();
				System.out.println("Enter Admin password");
				password = checkPassword();

				try {
					SERVICE.adminAuthentication(emailId, password);
					System.out.println("Admin logged in");

					do {
						System.out.println("1. Register");
						System.out.println("2. Add Book");
						System.out.println("3. Remove Book");
						System.out.println("4. Search Books");
						System.out.println("5. Show All Books");
						System.out.println("6. Show Users");
						System.out.println("7. Show Requests");
						System.out.println("8. Book Issue");
						System.out.println("9. Receive Returned Book");
						System.out.println("0. Exit");
						System.out.println("Enter your choice");
						check = checkChoice();

						switch (check) {
						case 1:
							System.out.println("Enter your Registration Details");
							System.out.println("Enter user id :");
							userId = checkId();
							scanner.nextLine();
							System.out.println("Enter user name");
							name = checkName();
							System.out.println("Enter User Email Id");
							emailId = checkEmailId();
							System.out.println("Enter password");
							password = checkPassword();

							userInfo = new UserInfo();
							userInfo.setUserId(userId);
							userInfo.setUserName(name);
							userInfo.setUserEmailId(emailId);
							userInfo.setUserPassword(password);

							try {
								SERVICE.register(userInfo);
								System.out.println("user Registered");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;
							
						case 2:
							System.out.println("Add Book Details: ");
							System.out.println("Enter book Id: ");
							bookId = checkId();
							System.out.println("Enter book Authour Name: ");
							scanner.nextLine();
							name = checkName();
							System.out.println("Enter Book Title: ");
							bookTitle = checkName();
							System.out.println("Enter Book Price: ");
							price = checkPrice();
							System.out.println("Is Book Available for Borrowing");
							isAvail = checkAvailability();

							bookInfo = new BookInfo();
							bookInfo.setIsbn(bookId);
							bookInfo.setAuthourName(name);
							bookInfo.setBookTitle(bookTitle);
							bookInfo.setPrice(price);
							bookInfo.setAvailable(isAvail);

							try {
								SERVICE.addBook(bookInfo);
								System.out.println("book is added");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 3:
							bookInfo = new BookInfo();
							System.out.println("Enter Book Id To Remove");
							bookId = checkId();
							bookInfo.setIsbn(bookId);

							try {
								SERVICE.deleteBook(bookId);
								System.out.println("Book Removed");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;
							
						case 4:
							booksSearch();
							break;

						case 5:
							try {
								List<BookInfo> allBooks = SERVICE.showBooks();
								System.out.println("Books present in library are :");
								System.out.println("-------------------------------");

								for (BookInfo book : allBooks) {
									System.out.println("Book id ----------> " + book.getIsbn());
									System.out.println("Book Name --------> " + book.getBookTitle());
									System.out.println("Book Authour------> " + book.getAuthourName());
									System.out.println("Book Price -------> " + book.getPrice());
									System.out.println("Book Available ---> " + book.isAvailable());
									System.out.println("-------------------------------");
								}
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 6:
							try {
								List<UserInfo> userInfos = SERVICE.showUsers();
								System.out.println("Users of Library are :");
								System.out.println("-------------------------------");

								for (UserInfo info : userInfos) {
									System.out.println("User id -----------------------> " + info.getUserId());
									System.out.println("User Name----------------------> " + info.getUserName());
									System.out.println("User Email -------------------->" + info.getUserEmailId());
									System.out
											.println("No Of Books Borrowed ----------> " + info.getNoOfBooksBorrowed());
									System.out.println("-------------------------------");
								}
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 7:
							try {
								List<RequestInfo> requestInfos = SERVICE.showRequests();
								System.out.println("Requests for Books are :");
								System.out.println("-------------------------------");

								for (RequestInfo info : requestInfos) {
									System.out.println("Book id ------------------> " + info.getBookId());
									System.out.println("User id ------------------> " + info.getUserId());
									System.out.println("Book Issued --------------> " + info.isIssued());
									System.out.println("Book Returned ------------> " + info.isReturned());
									System.out.println("Book IssuedDate ----------> " + info.getIssuedDate());
									System.out.println("Expected Returned Date ---> " + info.getExpectedReturnedDate());
									System.out.println("Book ReturnedDate --------> " + info.getReturnedDate());
									System.out.println("-------------------------------");
								}
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;


						case 8:
							System.out.println("Book Issue");
							System.out.println("Enter User Id");
							userId = checkId();
							System.out.println("Enter Book Id :");
							bookId = checkId();

							try {
								SERVICE.bookIssue(userId, bookId);
								System.out.println("Book Issued");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;
							
						case 9:
							System.out.println("Receive Returned Book");
							System.out.println("-----------------------");
							System.out.println("Enter User Id");
							userId = checkId();
							System.out.println("Enter Book Id");
							bookId = checkId();

							try {
								SERVICE.isBookReceived(userId, bookId);
								System.out.println(" Received Returned book");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 0:
							break;

						default:
							System.err.println("Choice Should Be in Between 1 to 9");
							break;

						}
					} while (check != 0); // do while for Admin options // Admin activities end
				} catch (LMSException e) {
					System.err.println(e.getMessage());
				}
				break;

			// User Page

			case 2:
				System.out.println("Enter User Email id");
				emailId = checkEmailId();
				System.out.println("Enter User password");
				password = checkPassword();

				try {
					SERVICE.userAuthentication(emailId, password);
					System.out.println("User logged in");
					do {
						System.out.println("1. Books in Library");
						System.out.println("2. Search a Book");
						System.out.println("3. Request a Book");
						System.out.println("4. Return Book");
						System.out.println("0. Exit");
						System.out.println("Enter your choice");
						userChoice = checkChoice();

						switch (userChoice) {
						case 1:
							try {
								List<BookInfo> allBooks = SERVICE.showBooks();
								System.out.println("Books present in library are :");
								System.out.println("-------------------------------");

								for (BookInfo book : allBooks) {
									System.out.println("Book Id:--------------------> " + book.getIsbn());
									System.out.println("Book Title:-----------------> " + book.getBookTitle());
									System.out.println("Book Authour:---------------> " + book.getAuthourName());
									System.out.println("Book Price:-----------------> " + book.getPrice());
									System.out.println("Book is Available ----------> " + book.isAvailable());
									System.out.println("------------------------------------------------------");
								}
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 2:
							booksSearch();
							break;

						case 3:
							System.out.println("Requesting a Book");
							System.out.println("Enter user id");
							userId = checkId();
							System.out.println("Enter book id");
							bookId = checkId();

							try {
								SERVICE.bookRequest(userId, bookId);
								System.out.println("Request placed to admin");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 4:
							System.out.println("Returning a book:");
							System.out.println("------------------");
							System.out.println("Enter User Id");
							userId = checkId();
							System.out.println("Enter Book Id");
							bookId = checkId();

							try {
								SERVICE.bookReturn(userId, bookId);
								System.out.println("Book is Returning to Admin");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						default:
							System.out.println("Invalid option");
							break;
						}
					} while (userChoice != 0);// user while ends

				} catch (LMSException e) {
					System.err.println(e.getMessage());
				}
				break;

			default:
				System.err.println("Choice should be in beween 1 and 2");
				break;

			}// Switch case end

		} while (true);// Main and outer most do while

	}// End Of Main

	public static void booksSearch() {
		int searchBookBy;
		int bookId;
		String bookTitle;
		String authourName;

		do {
			System.out.println("1. Search Book By Id");
			System.out.println("2. Search Book By Book Name");
			System.out.println("3. Search Book By Authour Name");
			System.out.println("0. Search Exit");
			System.out.println("Enter Your Choice");
			searchBookBy = checkChoice();
			BookInfo bookInfo = new BookInfo();

			switch (searchBookBy) {
			case 1:
				System.out.println("Enter Book ID To Search:");
				bookId = checkId();
				bookInfo.setIsbn(bookId);

				try {
					List<BookInfo> books = SERVICE.searchBook(bookInfo);

					for (BookInfo bookInfo2 : books) {
						System.out.println("Book Id -----------------------------> " + bookInfo2.getIsbn());
						System.out.println("Book Title --------------------------> " + bookInfo2.getBookTitle());
						System.out.println("Authour Name ------------------------> " + bookInfo2.getAuthourName());
						System.out.println("Book price --------------------------> " + bookInfo2.getPrice());
						System.out.println("Book Available ----------------------> " + bookInfo2.isAvailable());
						System.out.println("-------------------------------------------------------------------------");
					}
				} catch (LMSException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				scanner.nextLine();
				System.out.println("Enter Book Title");
				bookTitle = checkName();
				bookInfo.setBookTitle(bookTitle);

				try {
					List<BookInfo> books = SERVICE.searchBook(bookInfo);
					for (BookInfo bookInfo2 : books) {
						System.out.println("Book Id -----------------------------> " + bookInfo2.getIsbn());
						System.out.println("Book Title --------------------------> " + bookInfo2.getBookTitle());
						System.out.println("Authour Name ------------------------> " + bookInfo2.getAuthourName());
						System.out.println("Book price --------------------------> " + bookInfo2.getPrice());
						System.out.println("Book Available ----------------------> " + bookInfo2.isAvailable());
						System.out.println("-------------------------------------------------------------------------");
					}
				} catch (LMSException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3:
				scanner.nextLine();
				System.out.println("Enter Authour Name ");
				authourName = checkName();
				

				try {
					bookInfo.setAuthourName(authourName);
					List<BookInfo> books = SERVICE.searchBook(bookInfo);
					for (BookInfo bookInfo2 : books) {
						System.out.println("Book Id -----------------------------> " + bookInfo2.getIsbn());
						System.out.println("Book Title --------------------------> " + bookInfo2.getBookTitle());
						System.out.println("Authour Name ------------------------> " + bookInfo2.getAuthourName());
						System.out.println("Book price --------------------------> " + bookInfo2.getPrice());
						System.out.println("Book Available ----------------------> " + bookInfo2.isAvailable());
						System.out.println("-------------------------------------------------------------------------");
					}
				} catch (LMSException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 0:
				break;

			default:
				System.out.println("Choice Must Be In Between 0 to 3");
				break;
			}

		} while (searchBookBy != 0);

	}// End Of BooksSearch

}// End Of Library Controller
