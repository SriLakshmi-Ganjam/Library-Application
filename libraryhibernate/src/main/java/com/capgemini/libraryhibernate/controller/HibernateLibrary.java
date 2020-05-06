package com.capgemini.libraryhibernate.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.libraryhibernate.dto.BookInfo;
import com.capgemini.libraryhibernate.dto.LibraryUsers;
import com.capgemini.libraryhibernate.dto.RequestInfo;
import com.capgemini.libraryhibernate.exception.LibraryException;
import com.capgemini.libraryhibernate.factory.LibraryFactory;
import com.capgemini.libraryhibernate.service.LibraryService;
import com.capgemini.libraryhibernate.validation.Validation;

public class HibernateLibrary {
	private static final LibraryService SERVICE = LibraryFactory.getLibraryService();
	private static final Validation VALIDATION = new Validation();
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
				System.err.println("Invalid Choice, It Should Contails Only Digits");
				scanner.next();
			}
		} while (!flag);
		return choice;
	}

	public static int checkRequest() {
		boolean flag = false;
		int choice = 0;
		do {
			try {
				choice = scanner.nextInt();
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Invalid Request, It Should Contails Only Digits");
				scanner.next();
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
				System.err.println("Id Should contains only Digits");
				scanner.next();
			} catch (LibraryException e) {
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
			} catch (LibraryException e) {
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
			} catch (LibraryException e) {
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
			} catch (LibraryException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return password;
	}

	public static Double checkPrice() {
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
			} catch (LibraryException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return price;
	}

	public static boolean checkAvailability() {
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

	public static String checkRole() {
		String role = null;
		boolean flag = false;

		do {
			role = scanner.next();
			if (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("user")) {
				flag = true;
			} else {
				flag = false;
				System.err.println("Role Must Be Admin Or User");
			}
		} while (!flag);

		return role.toLowerCase();
	}

	public static void libraryOperations() {
		LibraryUsers LibraryUsers = null;
		BookInfo bookInfo = null;
		int choice = 0;
		int check = 0;
		int userChoice = 0;
		int userId = 0;
		int reqUserId = 0;
		int bookId = 0;
		int requestId = 0;
		String emailId = null;
		String password = null;
		String newPassword = null;
		String name = null;
		String role;
		String bookTitle = null;
		Double price = 0.0;
		boolean isAvail = false;
		boolean flag = false;
		boolean result = false;

		do {
			System.out.println("************** Welcome To Library **************");
			System.out.println("1.Amin Login");
			System.out.println("2. User Login");
			System.out.println("Enter your choice");
			choice = checkChoice();

			switch (choice) {
			case 1:
				System.out.println("Admin Log In Page");
				System.out.println("-----------------");
				System.out.println("Enter Admin id");
				userId = checkId();
				System.out.println("Enter Admin password");
				password = checkPassword();

				try {
					SERVICE.adminAuthentication(userId, password);
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
							System.out.println("Enter User Registration Details");
							userId = (int) (Math.random() * 1000);
							if (userId <= 100) {
								userId = userId + 100;
							}
							System.out.println("user Id:" + userId);
//							System.out.println("Enter user id :");
//							userId = checkId();
							scanner.nextLine();
							System.out.println("Enter user name");
							name = checkName();
							System.out.println("Enter User Email Id");
							emailId = checkEmailId();
							System.out.println("Enter password");
							password = checkPassword();
							System.out.println("Enter Role");
							role = checkRole();

							LibraryUsers = new LibraryUsers();
							LibraryUsers.setId(userId);
							LibraryUsers.setName(name);
							LibraryUsers.setEmailId(emailId);
							LibraryUsers.setPassword(password);
							LibraryUsers.setRole(role);

							try {
								result = SERVICE.register(LibraryUsers);
								if (result)
									System.out.println("User Registered Succesfully");
							} catch (LibraryException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 2:
							System.out.println("Adding Book To Library ");
							System.out.println("-------------------------");
//							System.out.println("Enter book Id: ");
//							bookId = checkId();
							bookId = (int) (Math.random() * 1000);
							if (bookId <= 100) {
								bookId = bookId + 100;
							}
							System.out.println("Book Id : " + bookId);

							System.out.println("Enter book Book Title: ");
							scanner.nextLine();
							bookTitle = checkName();
							System.out.println("Enter Authour Name: ");
							name = checkName();
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
								result = SERVICE.addBook(bookInfo);
								if (result)
									System.out.println("Book is added Sucessfully");
							} catch (LibraryException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 3:
							System.out.println("Removing Book From Library ");
							System.out.println("-------------------------");
							bookInfo = new BookInfo();
							System.out.println("Enter Book Id To Remove");
							bookId = checkId();
							bookInfo.setIsbn(bookId);

							try {
								SERVICE.deleteBook(bookId);
								System.out.println("Book Removed Successfully");
							} catch (LibraryException e) {
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
								System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", "BOOK ID",
										"BOOK NAME", "AUTHOUR", "PRICE", "AVAILABILITY"));

								for (BookInfo book : allBooks) {

									System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", book.getIsbn(),
											book.getBookTitle(), book.getAuthourName(), book.getPrice(),
											book.isAvailable()));
								}
								System.out.println();

//								for (BookInfo book : allBooks) {
//									System.out.println("Book id ----------> " + book.getIsbn());
//									System.out.println("Book Name --------> " + book.getBookTitle());
//									System.out.println("Book Authour------> " + book.getAuthourName());
//									System.out.println("Book Price -------> " + book.getPrice());
//									System.out.println("Book Available ---> " + book.isAvailable());
//									System.out.println("-------------------------------");
//								}
							} catch (LibraryException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 6:
							try {
								List<LibraryUsers> users = SERVICE.showUsers();
								System.out.println("Users of Library are :");
								System.out.println("-------------------------------");

								System.out.println(String.format("%-10s %-20s %-30s %-25s %-5s %-5s", "USER ID", "NAME",
										"EMAIL ID", "NO OF BOOKS BORROWED", "FINE", "ROLE"));

								for (LibraryUsers info : users) {

									System.out.println(String.format("%-10s %-20s %-30s %-25s %-5s %-5s", info.getId(),
											info.getName(), info.getEmailId(), info.getNoOfBooksBorrowed(),
											info.getFine(), info.getRole()));
								}
								System.out.println();

//								for (LibraryUsers info : users) {
//									System.out.println("User id -----------------------> " + info.getId());
//									System.out.println("User Name----------------------> " + info.getName());
//									System.out.println("User Email -------------------->" + info.getEmailId());
//									System.out
//											.println("No Of Books Borrowed ----------> " + info.getNoOfBooksBorrowed());
//									System.out.println("Fine ------------------------> " + info.getFine());
//									System.out.println("Role ------------------------> " + info.getRole());
//									System.out.println("-------------------------------");
//								}
							} catch (LibraryException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 7:
							try {
								List<RequestInfo> requestInfos = SERVICE.showRequests();
								System.out.println("Requests for Books are :");
								System.out.println("-------------------------------");

								System.out.println(
										String.format("%-15s %-15s %-15s %-40s %-40s %-40s", "REQUEST ID", "USER ID",
												"BOOK ID", "ISSUED DATE", "EXPECTED RETURNED DATE", "RETURNED DATE"));

								for (RequestInfo info : requestInfos) {

									System.out.println(
											String.format("%-15s %-15s %-15s %-40s %-40s %-40s", info.getRequestId(),
													info.getUserId(), info.getBookId(), info.getIssuedDate(),
													info.getExpectedReturnDate(), info.getReturnedDate()));
								}
								System.out.println();

//								for (RequestInfo info : requestInfos) {
//									System.out.println("Request Id ------------------> " + info.getRequestId());
//									System.out.println("Book Id ---------------------> " + info.getBookId());
//									System.out.println("User Id ---------------------> " + info.getUserId());
//									System.out.println("Book IssuedDate -------------> " + info.getIssuedDate());
//									System.out
//											.println("Expected Return Date --------> " + info.getExpectedReturnDate());
//									System.out.println("Book ReturnedDate -----------> " + info.getReturnedDate());
//									System.out.println("-------------------------------");
//								}
							} catch (LibraryException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 8:
							System.out.println("Issuing a Book");
							System.out.println("------------------");
							System.out.println("Enter Request Id");
							requestId = checkRequest();

							try {
								SERVICE.isBookIssued(requestId);
								;
								System.out.println("Book Issued");
							} catch (LibraryException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 9:
							System.out.println("Receive Returned Book");
							System.out.println("-----------------------");
							System.out.println("Enter Request Id");
							requestId = checkRequest();

							try {

								boolean isreceive = SERVICE.isBookReceived(requestId);
								if (isreceive)
									System.out.println(" Received Returned book Sucessfully");
							} catch (LibraryException e) {
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
				} catch (LibraryException e) {
					System.err.println(e.getMessage());
				}
				break;

			// User Page

			case 2:
				System.out.println("User Log In Page");
				System.out.println("-----------------");
				System.out.println("Enter User id: ");
				userId = checkId();
				System.out.println("Enter User password: ");
				password = checkPassword();

				try {
					SERVICE.userAuthentication(userId, password);
					System.out.println("User logged in");
					do {
						System.out.println("1. Books in Library");
						System.out.println("2. Search a Book");
						System.out.println("3. Request a Book");
						System.out.println("4. Return Book");
						System.out.println("5. Change Password");
						System.out.println("0. Exit");
						System.out.println("Enter your choice");
						userChoice = checkChoice();

						switch (userChoice) {
						case 1:
							try {
								List<BookInfo> allBooks = SERVICE.showBooks();
								System.out.println("Books present in library are :");
								System.out.println("-------------------------------");

								System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", "BOOK ID",
										"BOOK NAME", "AUTHOUR", "PRICE", "AVAILABILITY"));

								for (BookInfo book : allBooks) {

									System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", book.getIsbn(),
											book.getBookTitle(), book.getAuthourName(), book.getPrice(),
											book.isAvailable()));
								}
								System.out.println();

//								for (BookInfo book : allBooks) {
//									System.out.println("Book Id:--------------------> " + book.getIsbn());
//									System.out.println("Book Title:-----------------> " + book.getBookTitle());
//									System.out.println("Book Authour:---------------> " + book.getAuthourName());
//									System.out.println("Book Price:-----------------> " + book.getPrice());
//									System.out.println("Book is Available ----------> " + book.isAvailable());
//									System.out.println("------------------------------------------------------");
//								}
							} catch (LibraryException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 2:
							booksSearch();
							break;

						case 3:
							System.out.println("Requesting a Book");
							System.out.println("--------------------");
							System.out.println("Enter user id");
							do {
								reqUserId = checkId();
								if (reqUserId == userId) {
									flag = true;
								} else {
									flag = false;
									System.err.println("Enter Your User Id");
								}
							} while (!flag);

							System.out.println("Enter book id");
							bookId = checkId();

							try {
								SERVICE.bookRequest(userId, bookId);
								System.out.println("Request placed to Admin Succesfully");
							} catch (LibraryException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 4:
							System.out.println("Returning a book:");
							System.out.println("------------------");
							System.out.println("Enter User Id");
							do {
								reqUserId = checkId();
								if (reqUserId == userId) {
									flag = true;
								} else {
									flag = false;
									System.err.println("Enter Your User Id");
								}
							} while (!flag);

							System.out.println("Enter Book Id");
							bookId = checkId();

							try {
								SERVICE.bookReturn(userId, bookId);
								System.out.println("Book is Returning to Admin Successfully");
							} catch (LibraryException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 5:
							System.out.println("Enter User id: ");
							do {
								reqUserId = checkId();
								if (reqUserId == userId) {
									flag = true;
								} else {
									flag = false;
									System.err.println("Enter Your User Id");
								}
							} while (!flag);
							System.out.println("Enter User password: ");
							password = checkPassword();
							System.out.println("Enter New Password: ");
							newPassword = checkPassword();

							try {
								SERVICE.changePassword(reqUserId, password, newPassword);
								System.out.println("Password Changed Successfully");
							} catch (Exception e) {
								System.err.println(e.getMessage());
							}
							break;

						case 0:
							break;

						default:
							System.out.println("Invalid Choice, It Should be in between 0-5");
							break;
						}
					} while (userChoice != 0);// user while ends

				} catch (LibraryException e) {
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
					List<BookInfo> allBooks = SERVICE.searchBook(bookInfo);

					System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", "BOOK ID", "BOOK NAME", "AUTHOUR",
							"PRICE", "AVAILABILITY"));

					for (BookInfo book : allBooks) {

						System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", book.getIsbn(),
								book.getBookTitle(), book.getAuthourName(), book.getPrice(), book.isAvailable()));
					}
					System.out.println();

//					for (BookInfo bookInfo2 : books) {
//						System.out.println("Book Id -----------------------------> " + bookInfo2.getIsbn());
//						System.out.println("Book Title --------------------------> " + bookInfo2.getBookTitle());
//						System.out.println("Authour Name ------------------------> " + bookInfo2.getAuthourName());
//						System.out.println("Book price --------------------------> " + bookInfo2.getPrice());
//						System.out.println("Book Available ----------------------> " + bookInfo2.isAvailable());
//						System.out.println("-------------------------------------------------------------------------");
//					}
				} catch (LibraryException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				scanner.nextLine();
				System.out.println("Enter Book Title");
				bookTitle = checkName();
				bookInfo.setBookTitle(bookTitle);

				try {
					List<BookInfo> allBooks = SERVICE.searchBook(bookInfo);

					System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", "BOOK ID", "BOOK NAME", "AUTHOUR",
							"PRICE", "AVAILABILITY"));

					for (BookInfo book : allBooks) {

						System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", book.getIsbn(),
								book.getBookTitle(), book.getAuthourName(), book.getPrice(), book.isAvailable()));
					}
					System.out.println();

//					for (BookInfo bookInfo2 : books) {
//						System.out.println("Book Id -----------------------------> " + bookInfo2.getIsbn());
//						System.out.println("Book Title --------------------------> " + bookInfo2.getBookTitle());
//						System.out.println("Authour Name ------------------------> " + bookInfo2.getAuthourName());
//						System.out.println("Book price --------------------------> " + bookInfo2.getPrice());
//						System.out.println("Book Available ----------------------> " + bookInfo2.isAvailable());
//						System.out.println("-------------------------------------------------------------------------");
//					}
				} catch (LibraryException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3:
				scanner.nextLine();
				System.out.println("Enter Authour Name ");
				authourName = checkName();
				bookInfo.setAuthourName(authourName);

				try {

					List<BookInfo> allBooks = SERVICE.searchBook(bookInfo);
					System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", "BOOK ID", "BOOK NAME", "AUTHOUR",
							"PRICE", "AVAILABILITY"));

					for (BookInfo book : allBooks) {

						System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", book.getIsbn(),
								book.getBookTitle(), book.getAuthourName(), book.getPrice(), book.isAvailable()));
					}
					System.out.println();
				} catch (LibraryException e) {
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
