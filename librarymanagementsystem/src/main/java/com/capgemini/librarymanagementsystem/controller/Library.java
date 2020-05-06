package com.capgemini.librarymanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem.db.DataBase;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.LMSException;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;
import com.capgemini.librarymanagementsystem.service.LibraryService;
import com.capgemini.librarymanagementsystem.validation.LibraryValidation;

public class Library {
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
				System.err.println("Invalid Choice, It should contails only digits");
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
				System.err.println("Invalid Id,It should contails only digits");
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
		emailId.toLowerCase();
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

	public static void libraryOperations() {

		DataBase.addToDB();

		UserInfo userInfo = null;
		BookInfo bookInfo = null;
		int choice = 0;
		int check = 0;
		int userChoice = 0;
		int userId = 0;
		int bookId = 0;
		String emailId = null;
		String password = null;
		String newPassword = null;
		String name = null;
		String bookTitle = null;
		Double price = 0.0;
		boolean isAvail = false;
		
		do {
			System.out.println("************* Welcome To Library *************");
			System.out.println("1.Admin Login");
			System.out.println("2. User Login");
			System.out.println("Enter your choice");
			choice = checkChoice();

			switch (choice) {
			case 1:
				System.out.println("Admin LogIn Page");
				System.out.println("---------------------------");
				System.out.println("Enter Admin Email id");
				emailId = checkEmailId();
				System.out.println("Enter Admin password");
				password = checkPassword();

				try {
					SERVICE.adminAuthentication(emailId, password);
					System.out.println("Admin logged in");
					System.out.println("---------------------------");

					do {
						System.out.println("1. Register");
						System.out.println("2. Add Book");
						System.out.println("3. Remove Book");
						System.out.println("4. Search Books");
						System.out.println("5. View All Books");
						System.out.println("6. View All Users");
						System.out.println("7. View All Requests");
						System.out.println("8. Book Issue");
						System.out.println("9. Receive Returned Book");
						System.out.println("0. Log Out");
						System.out.println("Enter your choice");
						check = checkChoice();

						switch (check) {
						case 1:
							System.out.println("Enter User Registration Details");
							System.out.println("---------------------------------");
//							System.out.println("Enter User id :");
//							userId = checkId();
//							userId = rand.nextInt(1000); 
							userId = (int) (Math.random()*1000);
							if(userId <= 100) {
								userId =userId + 100;
							}
							System.out.println("User Id : "+ userId);
							scanner.nextLine();
							System.out.println("Enter User name");
							name = checkName();
							System.out.println("Enter User Email Id");
							emailId = checkEmailId();
							System.out.println("Enter User password");
							password = checkPassword();

							userInfo = new UserInfo();
							userInfo.setUserId(userId);
							userInfo.setUserName(name);
							userInfo.setUserEmailId(emailId);
							userInfo.setUserPassword(password);

							try {
								SERVICE.register(userInfo);
								System.out.println("User Registered Sucessfully");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 2:
							System.out.println("Add Book Details: ");
							System.out.println("---------------------------");
//							System.out.println("Enter book Id: ");
//							bookId = checkId();
//							bookId = rand.nextInt(1000);
							bookId = (int) (Math.random()*1000);
							if(bookId <= 100) {
								bookId =bookId + 100;
							}
							System.out.println("Book Id : "+bookId);
							
							System.out.println("Enter book Book Title: ");
							scanner.nextLine();
							bookTitle = checkName();
							System.out.println("Enter Authour Name: ");
							name = checkName();
							System.out.println("Enter Book Price: ");
							price = checkPrice();
							System.out.println("Is Book Available for Borrowing: ");
							isAvail = checkAvailability();

							bookInfo = new BookInfo();
							bookInfo.setIsbn(bookId);
							bookInfo.setAuthourName(name);
							bookInfo.setBookTitle(bookTitle);
							bookInfo.setPrice(price);
							bookInfo.setAvailable(isAvail);

							try {
								SERVICE.addBook(bookInfo);
								System.out.println("Book is a Added Sucessfully");
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
								System.out.println("Book Removed Sucessfully");
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

								System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", "BOOK ID",
										"BOOK NAME", "AUTHOUR", "PRICE", "AVAILABILITY"));

								for (BookInfo book : allBooks) {

									System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", book.getIsbn(),
											book.getBookTitle(), book.getAuthourName(), book.getPrice(),
											book.isAvailable()));
								}
								System.out.println();

							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 6:
							try {
								List<UserInfo> userInfos = SERVICE.showUsers();
								System.out.println("Users of Library are :");
								System.out.println("----------------------");

								System.out.println(String.format("%-10s %-20s %-30s %-25s %-5s", "USER ID", "NAME",
										"EMAIL ID", "NO OF BOOKS BORROWED", "FINE"));

								for (UserInfo info : userInfos) {

									System.out.println(String.format("%-10s %-20s %-30s %-25s %-5s", info.getUserId(),
											info.getUserName(), info.getUserEmailId(), info.getNoOfBooksBorrowed(),
											info.getFine()));
								}
								System.out.println();

							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 7:
							try {
								List<RequestInfo> requestInfos = SERVICE.showRequests();
								System.out.println("Requests for Books are :");
								System.out.println("-----------------------");

								System.out.println(String.format("%-10s %-10s %-15s %-15s %-35s %-35s %-35s", "USER ID",
										"BOOK ID", "IS ISSUED", "IS RETURNED", "ISSUED DATE", "EXPECTED RETURNED DATE",
										"RETURNED DATE"));

								for (RequestInfo info : requestInfos) {

									System.out.println(String.format("%-10s %-10s %-15s %-15s %-35s %-35s %-35s",
											info.getUserId(), info.getBookId(), info.isIssued(), info.isReturned(),
											info.getIssuedDate(), info.getExpectedReturnedDate(),
											info.getReturnedDate()));
								}
								System.out.println();

//
//								for (RequestInfo info : requestInfos) {
//									System.out.println("Book id ------------------> " + info.getBookId());
//									System.out.println("User id ------------------> " + info.getUserId());
//									System.out.println("Book Issued --------------> " + info.isIssued());
//									System.out.println("Book Returned ------------> " + info.isReturned());
//									System.out.println("Book IssuedDate ----------> " + info.getIssuedDate());
//									System.out.println("Expected Returned Date ---> " + info.getExpectedReturnedDate());
//									System.out.println("Book ReturnedDate --------> " + info.getReturnedDate());
//									System.out.println("-------------------------------");
//								}
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 8:
							System.out.println("Book Issue");
							System.out.println("----------------");
							System.out.println("Enter User Id");
							userId = checkId();
							System.out.println("Enter Book Id :");
							bookId = checkId();

							try {
								SERVICE.bookIssue(userId, bookId);
								System.out.println("Book Issued Sucessfully");
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
								System.out.println(" Received Returned book Sucessfully");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 0:
							break;

						default:
							System.err.println("Choice Should Be in Between 0 to 9");
							break;

						}
					} while (check != 0); // do while for Admin options // Admin activities end
				} catch (LMSException e) {
					System.err.println(e.getMessage());
				}
				break;

			// User Page

			case 2:
				System.out.println("User LogIn Page");
				System.out.println("---------------------------");
				System.out.println("Enter User Email id");
				emailId = checkEmailId();
				System.out.println("Enter User password");
				password = checkPassword();

				try {
					SERVICE.userAuthentication(emailId, password);
					System.out.println("User logged in");
					System.out.println("---------------------------");
					do {
						System.out.println("1. Books in Library");
						System.out.println("2. Search a Book");
						System.out.println("3. Request a Book");
						System.out.println("4. Return a Book");
						System.out.println("5. Change Password");
						System.out.println("0. Log Out");
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
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 2:
							booksSearch();
							break;

						case 3:
							System.out.println("Requesting a Book");
							System.out.println("-----------------------");
							System.out.println("Enter User Id");
							userId = checkId();
							System.out.println("Enter Book Id");
							bookId = checkId();

							try {
								SERVICE.bookRequest(userId, bookId);
								System.out.println("Request Placed to Admin Sucessfully");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 4:
							System.out.println("Returning a book:");
							System.out.println("---------------------");
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

						case 5:
							System.out.println("Chainging Password");
							System.out.println("-------------------");
							System.out.println("Enter User Id");
							userId = checkId();
							scanner.nextLine();
							System.out.println("Enter Old Password");
							password = checkPassword();
							System.out.println("Enter New Password");
							newPassword = checkPassword();

							try {
								SERVICE.changePassword(userId, password, newPassword);
								System.out.println("Password Changed Sucessfully");
							} catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 0:
							break;

						default:
							System.out.println("Invalid Choice, Choice Must be in Between 0 to 5");
							break;
						}
					} while (userChoice != 0);// user while ends

				} catch (LMSException e) {
					System.err.println(e.getMessage());
				}
				break;

			default:
				System.err.println("Invalid Choice, Choice Must be in beween 1 and 2");
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

					System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", "BOOK ID",
							"BOOK NAME", "AUTHOUR", "PRICE", "AVAILABILITY"));

					for (BookInfo book : books) {

						System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", book.getIsbn(),
								book.getBookTitle(), book.getAuthourName(), book.getPrice(),
								book.isAvailable()));
					}
					System.out.println();
					
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
					
					System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", "BOOK ID",
							"BOOK NAME", "AUTHOUR", "PRICE", "AVAILABILITY"));

					for (BookInfo book : books) {
						System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", book.getIsbn(),
								book.getBookTitle(), book.getAuthourName(), book.getPrice(),
								book.isAvailable()));
					}
					System.out.println();
					
				} catch (LMSException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3:
				scanner.nextLine();
				System.out.println("Enter Authour Name ");
				authourName = checkName();
				bookInfo.setAuthourName(authourName);

				try {

					List<BookInfo> books = SERVICE.searchBook(bookInfo);
					
					System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", "BOOK ID",
							"BOOK NAME", "AUTHOUR", "PRICE", "AVAILABILITY"));

					for (BookInfo book : books) {
						System.out.println(String.format("%-10s %-35s %-25s %-10s %-10s", book.getIsbn(),
								book.getBookTitle(), book.getAuthourName(), book.getPrice(),
								book.isAvailable()));
					}
					System.out.println();
				} catch (LMSException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 0:
				break;

			default:
				System.out.println("Invali Choice, Choice Must Be In Between 0 to 3");
				break;
			}

		} while (searchBookBy != 0);

	}// End Of BooksSearch

}// End Of Library Controller
