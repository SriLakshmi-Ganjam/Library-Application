package com.capgemini.librarymanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.LMSException;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;
import com.capgemini.librarymanagementsystem.service.Service;
import com.capgemini.librarymanagementsystem.service.UserService;
import com.capgemini.librarymanagementsystem.validation.LibraryValidation;

public class AdminController {
	public static void main(String[] args) {
		Service service = LMSFactory.getServiceDAO();
		UserService userService = LMSFactory.getUserServiceDAO();

		try (Scanner scanner = new Scanner(System.in);) { // Try with resource

			UserInfo userBean = new UserInfo();
			BookInfo bookBean = new BookInfo();
			LibraryValidation validation = new LibraryValidation();

			boolean flag = false;

			int choice = 0;
			int check = 0;
			int userChoice = 0;
			int userId = 0;
			int bookId = 0;

			String emailId = null;
			String password = null;
			String name = null;

			Double price = 0.0;

			do {// 1. Main and outer most do while for Home Page

				do { // 2. Scanner do while for Home Page
					try {
						System.out.println("1.Amin Login");
						System.out.println("2. User Login");
						System.out.println("Enter your choice");
						choice = scanner.nextInt();
						flag = true;
					} catch (InputMismatchException e) {
						System.err.println("Choice Must Be In Digits");
						flag = false;
						scanner.next();

					}

				} while (!flag);// 2. Scanner do while for Home Page

				switch (choice) {

				case 1:
					System.out.println("-----------------");
					do { // 3. Scanner do while for valid Email Id
						try {
							System.out.println("Enter Admin Email id");
							emailId = scanner.next();
							validation.validatedEmail(emailId);
							flag = true;
						} catch (LMSException e) {
							System.err.println(e.getMessage());
							flag = false;
						}
					} while (!flag); // 3. Scanner do while for valid Email Id

					do { // 4. Scanner do while for Password Validation
						try {
							System.out.println("Enter Admin password");
							password = scanner.next();
							validation.validatedPassword(password);
							flag = true;

						} catch (LMSException e) {
							System.err.println(e.getMessage());
							flag = false;
						}

					} while (!flag); // 4. Scanner do while for Password Validation

					try {
						// AdminInfo adminInfo = service.authentication(adminEmailId, adminPassword);
						service.authentication(emailId, password);
						System.out.println("Admin logged in");
						do { // 5. do while for Admin options
							System.out.println("1. Register");
							System.out.println("2. Search");
							System.out.println("3. Add Book");
							System.out.println("4. Remove Book");
							System.out.println("5. Show All Books");
							System.out.println("6. Book Issue");
							System.out.println("7. Show Users");
							System.out.println("8. Show Requests");
							System.out.println("9. Receive Returned Book");
							System.out.println("0. Exit");

							do {
								try {
									System.out.println("Enter your choice");
									check = scanner.nextInt();
									flag = true;

								} catch (InputMismatchException e) {
									System.err.println("Enter Only Digits");
									flag = false;
									scanner.next();

								} catch (LMSException e) {
									System.err.println(e.getMessage());
									flag = false;
								}

							} while (!flag);

							switch (check) {
							case 1:
								System.out.println("Enter your Registration Details");
								do { // Scanner do while for User Id
									try {
										System.out.println("Enter user id");
										userId = scanner.nextInt();
										validation.validatedId(userId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while for User Id

								do { // Scanner do while for User name
									try {
										System.out.println("Enter user name");
										//name = scanner.nextLine();
										name = scanner.next();
										validation.validatedName(name);
										flag = true;
									}
//									 catch (InputMismatchException e) {
//										System.err.println("Name Should Contains Only Alphabets");
//										flag = false;
//										scanner.next();
//									} 
									catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while for User Name

								do { // 3. Scanner do while for valid User Email Id
									try {
										System.out.println("Enter User Email Id");
										emailId = scanner.next();
										validation.validatedEmail(emailId);
										flag = true;
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // 3. Scanner do while for valid user Email Id

								do { // 4. Scanner do while for User Password Validation
									try {
										System.out.println("Enter password");
										password = scanner.next();
										validation.validatedPassword(password);
										flag = true;

									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}

								} while (!flag); // 4. Scanner do while for User Password Validation

								UserInfo userBean1 = new UserInfo();
								userBean1.setUserId(userId);
								userBean1.setUserName(name);
								userBean1.setUserEmailId(emailId);
								userBean1.setUserPassword(password);
								boolean result = service.register(userBean1);

								if (result) {
									System.out.println("user Registered");
								} else {
									System.out.println("user already Exsits");
								}
								break;

							case 2:
								System.out.println("Search a Book");
								do { // Scanner do while for Book Id
									try {
										System.out.println("Enter book Id");
										bookId = scanner.nextInt();
										validation.validatedId(bookId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while for Book Id

								try {
									BookInfo bookSearch = service.search(bookId);
									System.out.println("Book found");
									System.out.println("Book Id ----------------- " + bookSearch.getIsbn());
									System.out.println("Book Title -------------- " + bookSearch.getBookTitle());
									System.out.println("Book Authour ------------ " + bookSearch.getAuthourName());

								} catch (Exception e) {
									System.out.println("Book not found");

								}
								break;

							case 3:
								System.out.println("Add Book Details");
								do { // Scanner do while for Book Id
									try {
										System.out.println("Enter book Id");
										bookId = scanner.nextInt();
										validation.validatedId(bookId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while for Book Id

								do { // Scanner do while for Book Authour Name
									try {
										System.out.println("Enter book Authour Name");
										name = scanner.next();
										validation.validatedName(name);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Alphabets");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while for Book Authour Name

								System.out.println("Enter Book Title");
								String bookTitle = scanner.next();

								do { // Scanner do while for Book price
									try {
										System.out.println("Enter Book Price");
										price = scanner.nextDouble();
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									}
								} while (!flag); // Scanner do while for Book Price

								BookInfo bookBean1 = new BookInfo();

								bookBean1.setIsbn(bookId);
								bookBean1.setAuthourName(name);
								bookBean1.setBookTitle(bookTitle);
								bookBean1.setPrice(price);
								boolean bookAdded = service.addBook(bookBean1);
								System.out.println(bookAdded);

								if (bookAdded) {
									System.out.println("book is added");
								} else {
									System.out.println("This is an existing book");
								}

								break;
							case 4:

								do { // Scanner do while for Book Remove
									try {
										System.out.println("Enter Book Id To Remove");
										bookId = scanner.nextInt();
										validation.validatedId(bookId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while for Book Remove

								bookBean.setIsbn(bookId);
								boolean bookRemoved = service.deleteBook(bookId);
								if (bookRemoved) {
									System.out.println("Book Removed");
								} else {
									System.out.println("Invalid book to remove");
								}
								break;

							case 5:

								try {
									System.out.println("Books present in library are :");
									System.out.println("-------------------------------");

									List<BookInfo> allBooks = service.showBooks();
									for (BookInfo book : allBooks) {

										System.out.println("Book id ---------- " + book.getIsbn());
										System.out.println("Book Name -------- " + book.getBookTitle());
										System.out.println("Book Authour------ " + book.getAuthourName());
										System.out.println("Book Price ------- " + book.getPrice());
										System.out.println("-------------------------------");
									}
								} catch (Exception e) {
									System.out.println("no books present in library");
								}
								break;

							case 6:
								UserInfo userBean2 = new UserInfo();
								BookInfo bookBean2 = new BookInfo();

								do { // Scanner do while for Book ID fo Book Issue
									try {
										System.out.println("Enter Book Id :");
										bookId = scanner.nextInt();
										validation.validatedId(bookId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while for Book Id for Book Issue

								do { // Scanner do while for User Id for Book Issue
									try {
										System.out.println("Enter User Id");
										userId = scanner.nextInt();
										validation.validatedId(userId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while for Book Remove

								bookBean2.setIsbn(bookId);
								userBean2.setUserId(userId);
								// userBean.setUserId(uId);
								try {
									boolean isIssued = service.bookIssue(userBean2, bookBean2);
									if (isIssued) {
										System.out.println("Book Issued");
									} else {
										System.out.println("Book cannot be issued");
									}

								} catch (Exception e) {
									System.out.println("Invalid data request book cannot be issued");
								}
								break;

							case 7:
								try {
									System.out.println("Users of Library are :");
									System.out.println("-------------------------------");

									List<UserInfo> userInfos = service.showUsers();
									for (UserInfo info : userInfos) {

										System.out.println("User id ---------- " + info.getUserId());
										System.out.println("User Name -------- " + info.getUserName());
										System.out.println("User Email------ " + info.getUserEmailId());
										System.out.println(
												"User No Of Books Borrowed ------- " + info.getNoOfBooksBorrowed());
										System.out.println("-------------------------------");
									}
								} catch (Exception e) {
									System.out.println("no books present in library");
								}
								break;
							case 8:
								try {
									System.out.println("Requests for Books are :");
									System.out.println("-------------------------------");

									List<RequestInfo> requestInfos = service.showRequests();
									for (RequestInfo info : requestInfos) {

										System.out.println("Book id ---------- " + info.getBookInfo().getIsbn());
										System.out.println("Book Name -------- " + info.getBookInfo().getBookTitle());
										System.out.println("User id----------- " + info.getUserInfo().getUserId());
										System.out.println("User Name -------- " + info.getUserInfo().getUserName());
										System.out.println("Book Issued ------" + info.isIssued());
										System.out.println("Book Returned------" + info.isReturned());
										System.out.println("Book IssuedDate-----" + info.getIssuedDate());
										System.out.println("Expected Returned Date--" + info.getExpectedReturnedDate());
										System.out.println("Book ReturnedDate---" + info.getReturnedDate());
										System.out.println("-------------------------------");
									}
								} catch (Exception e) {
									System.out.println("no books present in library");
								}
								break;
							case 9:
								System.out.println("Receive Returned Book");
								System.out.println("-----------------------");
								do { // Scanner do while for userId for Book receive
									try {
										System.out.println("Enter User Id");
										userId = scanner.nextInt();
										validation.validatedId(userId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while userId for Book receive

								do { // Scanner do while for BookId for Book receive
									try {
										System.out.println("Enter Book Id");
										bookId = scanner.nextInt();
										validation.validatedId(bookId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while BookID for Book receive

								bookBean.setIsbn(userId);
								userBean.setUserId(bookId);
								boolean isReceive = service.isBookReceived(userBean, bookBean);
								if (isReceive) {
									System.out.println(" Received Returned book");
								} else {
									System.out.println("Invalid returning Admin unable to receive");
								}
								break;
							case 0:
								break;
							default:
								System.err.println("Choice Should Be in Between 1 to 9");
								break;

							}

						} while (check != 0); // 5. do while for Admin options // Admin activities end

					} catch (Exception e) {
						System.out.println("Exception due to invalid credentials");
					}
					break;
				case 2:
					System.out.println("-----------------");
					do { 								// 3. Scanner do while for valid Email Id
						try {
							System.out.println("Enter User Email id");
							emailId = scanner.next();
							validation.validatedEmail(emailId);
							flag = true;
						} catch (LMSException e) {
							System.err.println(e.getMessage());
							flag = false;
						}
					} while (!flag);					 // 3. Scanner do while for valid Email Id

					do { 								// 4. Scanner do while for Password Validation
						try {
							System.out.println("Enter User password");
							password = scanner.next();
							validation.validatedPassword(password);
							flag = true;

						} catch (LMSException e) {
							System.err.println(e.getMessage());
							flag = false;
						}

					} while (!flag); 						// 4. Scanner do while for Password Validation
					
					

					try {
						// UserInfo userInfo = userService.userLogin(emailId, password);
						userService.userLogin(emailId, password);
						System.out.println("User logged in");
						do {
							System.out.println("1. Books in Library");
							System.out.println("2. Search a Book");
							System.out.println("3. Request a Book");
							System.out.println("4. Return Book");
							System.out.println("0. Exit");
							System.out.println("Enter your choice");
							userChoice = scanner.nextInt();
							switch (userChoice) {
							case 1:
								try {
									System.out.println("Books present in library are :");
									System.out.println("-------------------------------");

									List<BookInfo> allBooks = service.showBooks();
									for (BookInfo book : allBooks) {

										System.out.println("Book Id:-------------------- " + book.getIsbn());
										System.out.println("Book Title:----------------- " + book.getBookTitle());
										System.out.println("Book Authour:--------------- " + book.getAuthourName());
										System.out.println("Book Price:----------------- " + book.getPrice());
										System.out.println("-------------------------------");
									}
								} catch (Exception e) {
									System.out.println("no books present in library");
								}
								break;
							case 2:
								System.out.println("Search a Book");
								do { // Scanner do while for BookId for Book Search
									try {
										System.out.println("Enter Book Id");
										bookId = scanner.nextInt();
										validation.validatedId(bookId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while BookID for Book search
								try {
									BookInfo bookSearch = service.search(bookId);
									System.out.println("Book found");
									System.out.println("Book Id:-------------------- " + bookSearch.getIsbn());
									System.out.println("Book Title:----------------- " + bookSearch.getBookTitle());
									System.out.println("Book Authour:--------------- " + bookSearch.getAuthourName());
									System.out.println("Book Price:----------------- " + bookSearch.getPrice());

								} catch (Exception e) {
									System.out.println("Book not found");

								}
								break;

							case 3:
								System.out.println("Enter book id");
								bookId = scanner.nextInt();
								// System.out.println("Enter Book Name");
								// String bookName = scanner.next();
								bookBean.setIsbn(bookId);
								// bookBean.setBookTitle(bookName);

								System.out.println("Enter user id");
								userId = scanner.nextInt();
								// System.out.println("Enter User Name");
								// String userName = scanner.next();
								userBean.setUserId(userId);
								// userBean.setUserName(userName);

								try {
									RequestInfo request = userService.bookRequest(userBean, bookBean);
									System.out.println("Request placed to admin");
									System.out.println("User Id-----" + request.getUserInfo().getUserId());
									System.out.println("User name---" + request.getUserInfo().getUserName());
									System.out.println("Book Id-----" + request.getBookInfo().getIsbn());
									System.out.println("Book Name---" + request.getBookInfo().getBookTitle());

								} catch (Exception e) {

									System.out.println("Enter valid data or Invalid Request");
								}
								break;
							case 4:
								System.out.println("Returning a book:");
								System.out.println("------------------");
								do { // Scanner do while for BookId for Book return
									try {
										System.out.println("Enter Book Id");
										bookId = scanner.nextInt();
										validation.validatedId(bookId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while BookID for Book return

								do { // Scanner do while for userId for Book return
									try {
										System.out.println("Enter User Id");
										userId = scanner.nextInt();
										validation.validatedId(userId);
										flag = true;
									} catch (InputMismatchException e) {
										System.err.println("ID Should Contains Only Digits");
										flag = false;
										scanner.next();
									} catch (LMSException e) {
										System.err.println(e.getMessage());
										flag = false;
									}
								} while (!flag); // Scanner do while userId for Book return

								userBean.setUserId(userId);
								bookBean.setIsbn(bookId);

								try {
									RequestInfo requestInfo = userService.bookReturn(userBean, bookBean);
									System.out.println("Book is Returning to Admin");
									System.out.println("User Id ------" + requestInfo.getUserInfo().getUserId());
									System.out.println("Book Id ------" + requestInfo.getBookInfo().getIsbn());
									System.out.println("Is Returning --" + requestInfo.isReturned());
									System.out.println("Returning date--" + requestInfo.getReturnedDate());

								} catch (Exception e) {
									System.out.println("Invalid Return");
								}
								break;

							default:
								System.out.println("Invalid option");
								break;
							}
						} while (userChoice != 0);// user while ends

					} catch (Exception e) {
						System.out.println("User cannot log in");
					}
					break;
				default:
					System.err.println("Choice should be in beween 1 and 2");
					break;

				}// Switch case end

			} while (true);// // 1. Main and outer most do while
		} // Scanner Try with Resource end
	}
}
