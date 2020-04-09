//package com.capgemini.librarymanagementsystem.controller;
//
//import java.util.InputMismatchException;
//import java.util.List;
//import java.util.Scanner;
//
//import com.capgemini.librarymanagementsystem.dto.BookInfo;
//import com.capgemini.librarymanagementsystem.dto.RequestInfo;
//import com.capgemini.librarymanagementsystem.dto.UserInfo;
//import com.capgemini.librarymanagementsystem.exception.LMSException;
//import com.capgemini.librarymanagementsystem.factory.LMSFactory;
//import com.capgemini.librarymanagementsystem.service.Service;
//import com.capgemini.librarymanagementsystem.service.UserService;
//import com.capgemini.librarymanagementsystem.validation.LibraryValidation;
//
//public class AdminCopy {
//	public static void main(String[] args) {
//		Service service = LMSFactory.getServiceDAO();
//		UserService userService = LMSFactory.getUserServiceDAO();
//		Scanner scanner = new Scanner(System.in);
//		UserInfo userBean = new UserInfo();
//		BookInfo bookBean = new BookInfo();
//		LibraryValidation validation = new LibraryValidation();
//		String adminEmailId = null;
//		boolean flag = false;
//		int regId = 0;
//		int choice = 0;
//
//		int check, userChoice;
//		do {// main do while outermost
//
//			do { // do while for Main choice scanner
//				try {
//					System.out.println("1.Amin Login");
//					System.out.println("2. User Login");
//					System.out.println("Enter your choice");
//					choice = scanner.nextInt();
//					flag = true;
//
//				} catch (InputMismatchException e) {
//					System.err.println("Choice Should Contain Only Digits");
//					flag = false;
//					scanner.next();
//				}
//			} while (!flag); // do while for Main choice scanner
//
//			switch (choice) {
//
//			case 1:
//				System.out.println("-----------------");
////				//do {
////				//	try {
////						
////						validation.validatedEmail(adminEmailId);
////						flag = true;
////					//} catch (InputMismatchException e) {
////						System.err.println("Input Should Contain Only Digits");
////						flag = false;
////					//} catch (LMSException e) {
////						System.err.println(e.getMessage());
////						flag = false;
////					}
////				} while (flag);
//
//				System.out.println("Enter Admin Email id");
//				adminEmailId = scanner.next();
//				System.out.println("Enter Admin password");
//				String adminPassword = scanner.next();
//
//				try {
//					 service.authentication(adminEmailId, adminPassword);
//					System.out.println("Admin logged in");
//					do {
//						System.out.println("1. Register");
//						System.out.println("2. Search");
//						System.out.println("3. Add Book");
//						System.out.println("4. Remove Book");
//						System.out.println("5. Show All Books");
//						System.out.println("6. Book Issue");
//						System.out.println("7. Show Users");
//						System.out.println("8. Show Requests");
//						System.out.println("9. Receive Returned Book");
//						System.out.println("0. Exit");
//
//						System.out.println("Enter your choice");
//						check = scanner.nextInt();
//
//						switch (check) {
//						case 1:
//							System.out.println("Enter your Registration Details");
//							// System.out.println("Enter user id");
//
//							do {
//								try {
//									System.out.println("Enter user id");
//									regId = scanner.nextInt();
//									boolean ValidateById = validation.validatedId(regId);
//									if (ValidateById) {
//										flag = true;
//										break;
//
//									}
//									// throw new LMSException("please enter valid data");
//								} catch (InputMismatchException e) {
//									scanner.next();
//									System.err.println("Please enter digits");
//									flag = false;
//
//								} catch (LMSException lms) {
//									System.err.println("please enter valid ID");
//									flag = false;
////									regId = scanner.nextInt();
////									if(validation.validatedId(regId)) {
////										break;
////									}
//								}
//							} while (!flag);
//
//							System.out.println("Enter user name");
//							String regName = scanner.next();
//							System.out.println("Enter Email Id");
//							String regEmailId = scanner.next();
//							System.out.println("Enter password");
//							String regPassword = scanner.next();
//
//							UserInfo userBean1 = new UserInfo();
//							userBean1.setUserId(regId);
//							userBean1.setUserName(regName);
//							userBean1.setUserEmailId(regEmailId);
//							userBean1.setUserPassword(regPassword);
//							boolean result = service.register(userBean1);
//
//							if (result) {
//								System.out.println("user Registered");
//							} else {
//								System.out.println("user already Exsits");
//							}
//							break;
//
//						case 2:
//							System.out.println("Search a Book");
//							System.out.println("Enter book Id");
//							int searchBookId = scanner.nextInt();
//							try {
//								BookInfo bookSearch = service.search(searchBookId);
//								System.out.println("Book found");
//								System.out.println(bookSearch.getIsbn());
//								System.out.println(bookSearch.getBookTitle());
//								System.out.println(bookSearch.getAuthourName());
//
//							} catch (Exception e) {
//								System.out.println("Book not found");
//
//							}
//							break;
//
//						case 3:
//							System.out.println("Add Book Details");
//							System.out.println("Enter Book id");
//							int bookId = scanner.nextInt();
//							System.out.println("Enter Author name");
//							String authourName = scanner.next();
//							System.out.println("Enter Book Title");
//							String bookTitle = scanner.next();
//							System.out.println("Enter Book Price");
//							Double price = scanner.nextDouble();
//
//							BookInfo bookBean1 = new BookInfo();
//
//							bookBean1.setIsbn(bookId);
//							bookBean1.setAuthourName(authourName);
//							bookBean1.setBookTitle(bookTitle);
//							bookBean1.setPrice(price);
//							boolean bookAdded = service.addBook(bookBean1);
//							System.out.println(bookAdded);
//
//							if (bookAdded) {
//								System.out.println("book is added");
//							} else {
//								System.out.println("This is an existing book");
//							}
//
//							break;
//						case 4:
//							System.out.println("Enter book id to remove ");
//							int removeBookId = scanner.nextInt();
//							bookBean.setIsbn(removeBookId);
//							boolean bookRemoved = service.deleteBook(removeBookId);
//							if (bookRemoved) {
//								System.out.println("Book Removed");
//							} else {
//								System.out.println("Invalid book to remove");
//							}
//							break;
//
//						case 5:
//
//							try {
//								System.out.println("Books present in library are :");
//								System.out.println("-------------------------------");
//
//								List<BookInfo> allBooks = service.showBooks();
//								for (BookInfo book : allBooks) {
//
//									System.out.println("Book id ---------- " + book.getIsbn());
//									System.out.println("Book Name -------- " + book.getBookTitle());
//									System.out.println("Book Authour------ " + book.getAuthourName());
//									System.out.println("Book Price ------- " + book.getPrice());
//									System.out.println("-------------------------------");
//								}
//							} catch (Exception e) {
//								System.out.println("no books present in library");
//							}
//							break;
//
//						case 6:
//							UserInfo userBean2 = new UserInfo();
//							BookInfo bookBean2 = new BookInfo();
//							System.out.println("enter Book Id");
//							int bId = scanner.nextInt();
//							// bookBean.setIsbn(bId);
//							System.out.println("enter User Id");
//							int uId = scanner.nextInt();
//
//							bookBean2.setIsbn(bId);
//							userBean2.setUserId(uId);
//							// userBean.setUserId(uId);
//							try {
//								boolean isIssued = service.bookIssue(userBean2, bookBean2);
//								if (isIssued) {
//									System.out.println("Book Issued");
//								} else {
//									System.out.println("Book cannot be issued");
//								}
//
//							} catch (Exception e) {
//								System.out.println("Invalid data request book cannot be issued");
//							}
//							break;
//
//						case 7:
//							try {
//								System.out.println("Users of Library are :");
//								System.out.println("-------------------------------");
//
//								List<UserInfo> userInfos = service.showUsers();
//								for (UserInfo info : userInfos) {
//
//									System.out.println("User id ---------- " + info.getUserId());
//									System.out.println("User Name -------- " + info.getUserName());
//									System.out.println("User Email------ " + info.getUserEmailId());
//									System.out.println(
//											"User No Of Books Borrowed ------- " + info.getNoOfBooksBorrowed());
//									System.out.println("-------------------------------");
//								}
//							} catch (Exception e) {
//								System.out.println("no books present in library");
//							}
//							break;
//						case 8:
//							try {
//								System.out.println("Requests for Books are :");
//								System.out.println("-------------------------------");
//
//								List<RequestInfo> requestInfos = service.showRequests();
//								for (RequestInfo info : requestInfos) {
//
//									System.out.println("Book id ---------- " + info.getBookInfo().getIsbn());
//									System.out.println("Book Name -------- " + info.getBookInfo().getBookTitle());
//									System.out.println("User id----------- " + info.getUserInfo().getUserId());
//									System.out.println("User Name -------- " + info.getUserInfo().getUserName());
//									System.out.println("Book Issued ------" + info.isIssued());
//									System.out.println("Book Returned------" + info.isReturned());
//									System.out.println("Book IssuedDate-----" + info.getIssuedDate());
//									System.out.println("Expected Returned Date--" + info.getExpectedReturnedDate());
//									System.out.println("Book ReturnedDate---" + info.getReturnedDate());
//									System.out.println("-------------------------------");
//								}
//							} catch (Exception e) {
//								System.out.println("no books present in library");
//							}
//							break;
//						case 9:
//							System.out.println("Receive Returned Book");
//							System.out.println("-----------------------");
//							System.out.println("Enter User Id");
//							int user1 = scanner.nextInt();
//							System.out.println("Enter Book Id");
//							int book1 = scanner.nextInt();
//
//							bookBean.setIsbn(user1);
//							userBean.setUserId(book1);
//							boolean isReceive = service.isBookReceived(userBean, bookBean);
//							if (isReceive) {
//								System.out.println(" Received Returned book");
//							} else {
//								System.out.println("Invalid returning Admin unable to receive");
//							}
//
//						}
//
//					} while (check != 0); // Admin activities end
//
//				} catch (Exception e) {
//					System.out.println("Exception due to invalid credentials");
//				}
//				break;
//			case 2:
//				System.out.println("-----------------");
//				System.out.println("Enter User Email id");
//				String userEmailId1 = scanner.next();
//				System.out.println("Enter User password");
//				String userPassword1 = scanner.next();
//
//				try {
//					UserInfo info =userService.userLogin(userEmailId1, userPassword1);
//					System.out.println("User logged in");
//					do {
//						System.out.println("1. Books in Library");
//						System.out.println("2. Search a Book");
//						System.out.println("3. Request a Book");
//						System.out.println("4. Return Book");
//						System.out.println("0. Exit");
//						System.out.println("Enter your choice");
//						userChoice = scanner.nextInt();
//						switch (userChoice) {
//						case 1:
//							try {
//								System.out.println("Books present in library are :");
//								System.out.println("-------------------------------");
//
//								List<BookInfo> allBooks = service.showBooks();
//								for (BookInfo book : allBooks) {
//
//									System.out.println(book.getIsbn());
//									System.out.println(book.getBookTitle());
//									System.out.println(book.getAuthourName());
//									System.out.println(book.getPrice());
//									System.out.println("-------------------------------");
//								}
//							} catch (Exception e) {
//								System.out.println("no books present in library");
//							}
//							break;
//						case 2:
//							System.out.println("Search a Book");
//							System.out.println("Enter book Id");
//							int searchBookId = scanner.nextInt();
//							try {
//								BookInfo bookSearch = service.search(searchBookId);
//								System.out.println("Book found");
//								System.out.println(bookSearch.getIsbn());
//								System.out.println(bookSearch.getBookTitle());
//								System.out.println(bookSearch.getAuthourName());
//								System.out.println(bookSearch.getPrice());
//
//							} catch (Exception e) {
//								System.out.println("Book not found");
//
//							}
//							break;
//
//						case 3:
//							System.out.println("Enter book id");
//							int bookId = scanner.nextInt();
//							// System.out.println("Enter Book Name");
//							// String bookName = scanner.next();
//							bookBean.setIsbn(bookId);
//							// bookBean.setBookTitle(bookName);
//
//							System.out.println("Enter user id");
//							int userId = scanner.nextInt();
//							// System.out.println("Enter User Name");
//							// String userName = scanner.next();
//							userBean.setUserId(userId);
//							// userBean.setUserName(userName);
//
//							try {
//								RequestInfo request = userService.bookRequest(userBean, bookBean);
//								System.out.println("Request placed to admin");
//								System.out.println("User Id-----" + request.getUserInfo().getUserId());
//								System.out.println("User name---" + request.getUserInfo().getUserName());
//								System.out.println("Book Id-----" + request.getBookInfo().getIsbn());
//								System.out.println("Book Name---" + request.getBookInfo().getBookTitle());
//
//							} catch (Exception e) {
//
//								System.out.println("Enter valid data or Invalid Request");
//							}
//							break;
//						case 4:
//							System.out.println("Returning a book:");
//							System.out.println("------------------");
//							System.out.println("Enter User Id");
//							int user = scanner.nextInt();
//							System.out.println("Enter Book Id");
//							int book = scanner.nextInt();
//							userBean.setUserId(user);
//							bookBean.setIsbn(book);
//
//							try {
//								RequestInfo requestInfo = userService.bookReturn(userBean, bookBean);
//								System.out.println("Book is Returning to Admin");
//								System.out.println("User Id ------" + requestInfo.getUserInfo().getUserId());
//								System.out.println("Book Id ------" + requestInfo.getBookInfo().getIsbn());
//								System.out.println("Is Returning --" + requestInfo.isReturned());
//								System.out.println("Returning date--" + requestInfo.getReturnedDate());
//
//							} catch (Exception e) {
//								System.out.println("Invalid Return");
//							}
//							break;
//
//						default:
//							System.out.println("Invalid option");
//							break;
//						}
//					} while (userChoice != 0);// user while ends
//
//				} catch (Exception e) {
//					System.out.println("User cannot log in");
//				}
//			default: System.err.println("Choice should be in beween 1 and 2");
//
//			}
//			//scanner.close();
//
//		} while (true);// home page while outmost, admin user login page
//		
//	}
//	
//}
