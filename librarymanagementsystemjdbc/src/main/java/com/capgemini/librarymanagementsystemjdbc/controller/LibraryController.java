package com.capgemini.librarymanagementsystemjdbc.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystemjdbc.dto.BookInfo;
import com.capgemini.librarymanagementsystemjdbc.dto.LibraryUsers;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestInfo;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryException;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryFactory;
import com.capgemini.librarymanagementsystemjdbc.service.LibraryService;
import com.capgemini.librarymanagementsystemjdbc.validation.Validation;

public class LibraryController {
	public static void main(String[] args) {
		LibraryService service = LibraryFactory.getLibraryService();
		Validation validation = new Validation();

		int id = 0;
		int userId = 0;
		int choice = 0;
		int adminChoice = 0;
		int userChoice = 0;
		int searchBook = 0;
		int isbn = 0;
		int requestId = 0;

		String name = null;
		String emailId = null;
		String password = null;
		String role = null;
		String authourName = null;
		String bookTitle = null;

		double price = 0.0;

		boolean isAvailable = false;
		boolean result = false;
		boolean flag = false;

		try (Scanner scanner = new Scanner(System.in);) {

			do {

				do {
					try {
						System.out.println("1. Register User");
						System.out.println("2. Login");
//						System.out.println("3. Exit");
						System.out.println("Enter Your Choice");
						choice = scanner.nextInt();
						flag = true;

					} catch (InputMismatchException e) {
						System.err.println("Choice Should Contain Only Digits");
						flag = false;
						scanner.next();
					}
				} while (!flag);

				switch (choice) {
				case 1:
					LibraryUsers info = new LibraryUsers();

					do {
						try {
							System.out.println("Enter Id:");
							id = scanner.nextInt();
							validation.validatedId(id);
							flag = true;
						} catch (InputMismatchException e) {
							System.err.println("ID Should Contains Only Digits");
							flag = false;
							scanner.next();
						} catch (LibraryException e) {
							System.err.println(e.getMessage());
							flag = false;
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter Name:");
							name = scanner.next();
							validation.validatedName(name);
							flag = true;
						} catch (LibraryException e) {
							System.err.println(e.getMessage());
							flag = false;
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter Email Id:");
							emailId = scanner.next();
							validation.validatedEmail(emailId);
							flag = true;
						} catch (LibraryException e) {
							System.err.println(e.getMessage());
							flag = false;
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter Password:");
							password = scanner.next();
							validation.validatedPassword(password);
							flag = true;
						} catch (LibraryException e) {
							System.err.println(e.getMessage());
							flag = false;
						}
					} while (!flag);

					System.out.println("Enter Role:");
					role = scanner.next();

					info.setId(id);
					info.setName(name);
					info.setEmailId(emailId);
					info.setPassword(password);
					info.setRole(role);

					try {
						result = service.register(info);
						if (result) {
							System.out.println("Registration Completed");
						} else {
							System.err.println("Registration Failed");
						}
					} catch (LibraryException e) {
						System.err.println(e.getMessage());
					}

					break;
				case 2:
					LibraryUsers users = new LibraryUsers();

					do {
						try {
							System.out.println("Enter User Id ");
							userId = scanner.nextInt();
							validation.validatedId(userId);
							flag = true;
						} catch (InputMismatchException e) {
							System.err.println("ID Should Contains Only Digits");
							flag = false;
							scanner.next();
						} catch (LibraryException e) {
							System.err.println(e.getMessage());
							flag = false;
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter Password");
							password = scanner.next();
							validation.validatedPassword(password);
							flag = true;
						} catch (LibraryException e) {
							System.err.println(e.getMessage());
							flag = false;
						}
					} while (!flag);

					try {

						users = service.authentication(userId, password);
						if (users != null) {
							System.out.println(users.getRole() + " Logged in");

							if (users.getRole().equalsIgnoreCase("admin")) {
								do {
									System.out.println("1. Add Book");
									System.out.println("2. Delete Book");
									System.out.println("3. Show Books");
									System.out.println("4. Show Users");
									System.out.println("5. Show Requests");
									System.out.println("6. Search Books");
									System.out.println("7. Issue Book");
									System.out.println("8. Receive Book");

									System.out.println("0. Main Menu");

									System.out.println("Enter Your Choice:");
									adminChoice = scanner.nextInt();

									switch (adminChoice) {
									case 1:
										BookInfo book = new BookInfo();

										do {
											try {
												System.out.println("Enter book id");
												isbn = scanner.nextInt();
												validation.validatedId(isbn);
												flag = true;
											} catch (InputMismatchException e) {
												System.err.println("ID Should Contains Only Digits");
												flag = false;
												scanner.next();
											} catch (LibraryException e) {
												System.err.println(e.getMessage());
												flag = false;
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Book Title");
												bookTitle = scanner.next();
												validation.validatedName(bookTitle);
												flag = true;
											} catch (LibraryException e) {
												System.err.println(e.getMessage());
												flag = false;
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Authour Name");
												authourName = scanner.next();
												validation.validatedName(authourName);
												flag = true;
											} catch (LibraryException e) {
												System.err.println(e.getMessage());
												flag = false;
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Book Price");
												price = scanner.nextDouble();
												flag = true;
											} catch (InputMismatchException e) {
												System.err.println("ID Should Contains Only Digits");
												flag = false;
												scanner.next();
											} 
										} while (!flag);

										do {
											try {
												System.out.println("Is Book Available");
												isAvailable = scanner.nextBoolean();

												flag = true;
											} catch (InputMismatchException e) {
												System.err.println("Enter Boolean value true/false");
												flag = false;
												scanner.next();
											} 
										} while (!flag);

										book.setIsbn(isbn);
										book.setBookTitle(bookTitle);
										book.setAuthourName(authourName);
										book.setPrice(price);
										book.setAvailable(isAvailable);

										try {
											result = service.addBook(book);
											if (result) {
												System.out.println("Book is added to the library");
											} else {
												System.err.println("Book Connot Be Added");
											}
										} catch (LibraryException e) {
											System.err.println(e.getMessage());
										}

										break;
									case 2:

										do {
											try {
												System.out.println("Enter Book ID To Remove:");
												isbn = scanner.nextInt();
												validation.validatedId(isbn);
												flag = true;
											} catch (InputMismatchException e) {
												System.err.println("ID Should Contains Only Digits");
												flag = false;
												scanner.next();
											} catch (LibraryException e) {
												System.err.println(e.getMessage());
												flag = false;
											}
										} while (!flag);

										try {
											result = service.deleteBook(isbn);
											if (result) {
												System.out.println("Book is Removed From The Library");
											} else {
												System.out.println("Book Cannot be Removed From The Library");
											}
										} catch (LibraryException e) {
											System.err.println(e.getMessage());
										}
										break;
									case 3:
										System.out.println("Books In Library Are:");
										try {
											List<BookInfo> books = service.showBooks();

											for (BookInfo bookInfo : books) {
												System.out.println(
														"Book Id -----------------------------> " + bookInfo.getIsbn());
												System.out.println("Book Title --------------------------> "
														+ bookInfo.getBookTitle());
												System.out.println("Authour Name ------------------------> "
														+ bookInfo.getAuthourName());
												System.out.println("Book price --------------------------> "
														+ bookInfo.getPrice());
												System.out.println("Is Available ------------------------> "
														+ bookInfo.isAvailable());
												System.out.println(
														"-------------------------------------------------------------------------");

											}

										} catch (LibraryException e) {
											System.err.println(e.getMessage());
										}
										break;
									case 4:
										System.out.println("Users Of Library Are:");
										try {
											List<LibraryUsers> libraryUsers = service.showUsers();

											for (LibraryUsers user : libraryUsers) {
												System.out.println(
														"user Id -----------------------------> " + user.getId());
												System.out.println(
														"user Name ---------------------------> " + user.getName());
												System.out.println(
														"user Email Id -----------------------> " + user.getEmailId());
												System.out.println("Books Borrowed ----------------------> "
														+ user.getNoOfBooksBorrowed());
												System.out.println(
														"Role --------------------------------> " + user.getRole());
												System.out.println(
														"-------------------------------------------------------------------------");

											}

										} catch (LibraryException e) {
											System.err.println(e.getMessage());
										}
										break;
									case 5:
										System.out.println("Request For Books Are:");
										try {
											List<RequestInfo> requestInfos = service.showRequests();

											for (RequestInfo requestInfo : requestInfos) {
												System.out.println("request Id -----------------------------> "
														+ requestInfo.getRequestId());
												System.out.println("User Id --------------------------------> "
														+ requestInfo.getUserId());
												System.out.println("Book id --------------------------------> "
														+ requestInfo.getBookId());
												System.out.println("Issued Date ----------------------------> "
														+ requestInfo.getIssuedDate());
												System.out.println("Expected Return Date -------------------> "
														+ requestInfo.getExpectedReturnedDate());
												System.out.println("Returned Date --------------------------> "
														+ requestInfo.getReturnedDate());
												System.out.println("Fine -----------------------------------> "
														+ requestInfo.getFine());
												System.out.println(
														"-------------------------------------------------------------------------");

											}

										} catch (LibraryException e) {
											System.err.println(e.getMessage());
										}
										break;
									case 6:
										do {
											System.out.println("1. Search Book By Id");
											System.out.println("2. Search Book By Book Name");
											System.out.println("3. Search Book By Authour Name");
											System.out.println("0. Search Exit");

											do {
												try {
													System.out.println("Enter Your Choice");
													searchBook = scanner.nextInt();
													flag = true;
												} catch (InputMismatchException e) {
													System.err.println("ID Should Contains Only Digits");
													flag = false;
													scanner.next();
												}
											} while (!flag);

											
											BookInfo bookInfo = new BookInfo();
											// List<BookInfo> list = new LinkedList<BookInfo>();

											switch (searchBook) {
											case 1:
												do {
													try {
														System.out.println("Enter Book ID To Remove:");
														isbn = scanner.nextInt();
														validation.validatedId(isbn);
														flag = true;
													} catch (InputMismatchException e) {
														System.err.println("ID Should Contains Only Digits");
														flag = false;
														scanner.next();
													} catch (LibraryException e) {
														System.err.println(e.getMessage());
														flag = false;
													}
												} while (!flag);

												try {
													// list = service.
													List<BookInfo> books = service.search(bookInfo);

													for (BookInfo bookInfo2 : books) {
														System.out.println("Book Id -----------------------------> "
																+ bookInfo2.getIsbn());
														System.out.println("Book Title --------------------------> "
																+ bookInfo2.getBookTitle());
														System.out.println("Authour Name ------------------------> "
																+ bookInfo2.getAuthourName());
														System.out.println("Book price --------------------------> "
																+ bookInfo2.getPrice());
														System.out.println("Is Available ------------------------> "
																+ bookInfo2.isAvailable());
														System.out.println(
																"-------------------------------------------------------------------------");

													}

												} catch (LibraryException e) {
													System.err.println(e.getMessage());
												}

												break;
											case 2:
												do {
													try {
														System.out.println("Enter Book Title");
														bookTitle = scanner.next();
														validation.validatedName(bookTitle);
														flag = true;
													} catch (LibraryException e) {
														System.err.println(e.getMessage());
														flag = false;
													}
												} while (!flag);

												bookInfo.setBookTitle(bookTitle);
												try {
													// list = service.
													List<BookInfo> books = service.search(bookInfo);

													for (BookInfo bookInfo2 : books) {
														System.out.println("Book Id -----------------------------> "
																+ bookInfo2.getIsbn());
														System.out.println("Book Title --------------------------> "
																+ bookInfo2.getBookTitle());
														System.out.println("Authour Name ------------------------> "
																+ bookInfo2.getAuthourName());
														System.out.println("Book price --------------------------> "
																+ bookInfo2.getPrice());
														System.out.println("Is Available ------------------------> "
																+ bookInfo2.isAvailable());
														System.out.println(
																"-------------------------------------------------------------------------");

													}

												} catch (LibraryException e) {
													System.err.println(e.getMessage());
												}

												break;

											case 3:
												do {
													try {
														System.out.println("Enter Authour Name ");
														authourName = scanner.next();
														validation.validatedName(authourName);
														
														flag = true;
													} catch (LibraryException e) {
														System.err.println(e.getMessage());
														flag = false;
													}
												} while (!flag);

												bookInfo.setAuthourName(authourName);
												try {
													// list = service.
													List<BookInfo> books = service.search(bookInfo);

													for (BookInfo bookInfo2 : books) {
														System.out.println("Book Id -----------------------------> "
																+ bookInfo2.getIsbn());
														System.out.println("Book Title --------------------------> "
																+ bookInfo2.getBookTitle());
														System.out.println("Authour Name ------------------------> "
																+ bookInfo2.getAuthourName());
														System.out.println("Book price --------------------------> "
																+ bookInfo2.getPrice());
														System.out.println("Is Available ------------------------> "
																+ bookInfo2.isAvailable());
														System.out.println(
																"-------------------------------------------------------------------------");

													}

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

										} while (searchBook != 0);
										break;
									case 7:
										do {
											try {
												System.out.println("Enter Request Id");
												requestId = scanner.nextInt();

												flag = true;
											} catch (InputMismatchException e) {
												System.err.println("ID Should Contains Only Digits");
												flag = false;
												scanner.next();
											} 
										} while (!flag);

										try {
											result = service.isBookIssued(requestId);
											if (result) {
												System.out.println("Book Issued");
											} else {
												System.out.println("Unable to issue Book");
											}
										} catch (LibraryException e) {
											System.err.println(e.getMessage());
										}
										break;

									case 8:
										do {
											try {
												System.out.println("Enter Request Id");
												requestId = scanner.nextInt();

												flag = true;
											} catch (InputMismatchException e) {
												System.err.println("ID Should Contains Only Digits");
												flag = false;
												scanner.next();
											} 
										} while (!flag);
										try {
											result = service.isBookReceived(requestId);
											if (result) {
												System.out.println("Book Received");
											} else {
												System.out.println("Unable to Receive Book");
											}
										} catch (LibraryException e) {
											System.err.println(e.getMessage());
										}

										break;
									case 0:
										break;
									default:
										System.out.println("Out Of Range");
										break;
									}

								} while (adminChoice != 0);

							} // End of admin if
							else if (users.getRole().equalsIgnoreCase("student")
									|| users.getRole().equalsIgnoreCase("teacher")
									|| users.getRole().equalsIgnoreCase("reader")) {
								do {
									System.out.println("1. Show Books");
									System.out.println("2. Search Books");
									System.out.println("3. Request Book");
									System.out.println("4. Return Book");
									System.out.println("0. User Log Out ");

									do {
										try {
											System.out.println("Enter Your Choice");
											userChoice = scanner.nextInt();
											flag = true;
										} catch (InputMismatchException e) {
											System.err.println("ID Should Contains Only Digits");
											flag = false;
											scanner.next();
										} 
									} while (!flag);

									
									switch (userChoice) {
									case 1:
										System.out.println("Books In Library Are:");
										try {
											List<BookInfo> books = service.showBooks();

											for (BookInfo bookInfo : books) {
												System.out.println(
														"Book Id -----------------------------> " + bookInfo.getIsbn());
												System.out.println("Book Title --------------------------> "
														+ bookInfo.getBookTitle());
												System.out.println("Authour Name ------------------------> "
														+ bookInfo.getAuthourName());
												System.out.println("Book price --------------------------> "
														+ bookInfo.getPrice());
												System.out.println("Is Available ------------------------> "
														+ bookInfo.isAvailable());
												System.out.println(
														"-------------------------------------------------------------------------");

											}

										} catch (LibraryException e) {
											System.err.println(e.getMessage());
										}
										break;
									case 2:
										do {
											System.out.println("1. Search Book By Id");
											System.out.println("2. Search Book By Book Name");
											System.out.println("3. Search Book By Authour Name");
											System.out.println("0. Search Exit");
											do {
												try {
													System.out.println("Enter Your Choice");
													searchBook = scanner.nextInt();
													flag = true;
												} catch (InputMismatchException e) {
													System.err.println("ID Should Contains Only Digits");
													flag = false;
													scanner.next();
												} 
											} while (!flag);

											
											BookInfo bookInfo = new BookInfo();
											// List<BookInfo> list = new LinkedList<BookInfo>();

											switch (searchBook) {
											case 1:
												do {
													try {

														System.out.println("Enter Book Id");
														isbn = scanner.nextInt();
														validation.validatedId(isbn);
														flag = true;
													} catch (InputMismatchException e) {
														System.err.println("ID Should Contains Only Digits");
														flag = false;
														scanner.next();
													} catch (LibraryException e) {
														System.err.println(e.getMessage());
														flag = false;
													}
												} while (!flag);

												bookInfo.setIsbn(isbn);
												try {
													// list = service.
													List<BookInfo> books = service.search(bookInfo);

													for (BookInfo bookInfo2 : books) {
														System.out.println("Book Id -----------------------------> "
																+ bookInfo2.getIsbn());
														System.out.println("Book Title --------------------------> "
																+ bookInfo2.getBookTitle());
														System.out.println("Authour Name ------------------------> "
																+ bookInfo2.getAuthourName());
														System.out.println("Book price --------------------------> "
																+ bookInfo2.getPrice());
														System.out.println("Is Available ------------------------> "
																+ bookInfo2.isAvailable());
														System.out.println(
																"-------------------------------------------------------------------------");

													}

												} catch (LibraryException e) {
													System.err.println(e.getMessage());
												}

												break;
											case 2:
												do {
													try {
														System.out.println("Enter Book Title");
														bookTitle = scanner.next();
														validation.validatedName(name);
														flag = true;
													} catch (InputMismatchException e) {
														System.err.println("ID Should Contains Only Digits");
														flag = false;
														scanner.next();
													} catch (LibraryException e) {
														System.err.println(e.getMessage());
														flag = false;
													}
												} while (!flag);

												
												bookInfo.setBookTitle(bookTitle);
												try {
													// list = service.
													List<BookInfo> books = service.search(bookInfo);

													for (BookInfo bookInfo2 : books) {
														System.out.println("Book Id -----------------------------> "
																+ bookInfo2.getIsbn());
														System.out.println("Book Title --------------------------> "
																+ bookInfo2.getBookTitle());
														System.out.println("Authour Name ------------------------> "
																+ bookInfo2.getAuthourName());
														System.out.println("Book price --------------------------> "
																+ bookInfo2.getPrice());
														System.out.println("Is Available ------------------------> "
																+ bookInfo2.isAvailable());
														System.out.println(
																"-------------------------------------------------------------------------");

													}

												} catch (LibraryException e) {
													System.err.println(e.getMessage());
												}

												break;

											case 3:
												do {
													try {
														System.out.println("Enter Authour Name ");
														authourName = scanner.next();
														bookInfo.setAuthourName(authourName);
														validation.validatedName(authourName);
														flag = true;
													} catch (InputMismatchException e) {
														System.err.println("ID Should Contains Only Digits");
														flag = false;
														scanner.next();
													} catch (LibraryException e) {
														System.err.println(e.getMessage());
														flag = false;
													}
												} while (!flag);

												
												
												try {
													// list = service.
													List<BookInfo> books = service.search(bookInfo);

													for (BookInfo bookInfo2 : books) {
														System.out.println("Book Id -----------------------------> "
																+ bookInfo2.getIsbn());
														System.out.println("Book Title --------------------------> "
																+ bookInfo2.getBookTitle());
														System.out.println("Authour Name ------------------------> "
																+ bookInfo2.getAuthourName());
														System.out.println("Book price --------------------------> "
																+ bookInfo2.getPrice());
														System.out.println("Is Available ------------------------> "
																+ bookInfo2.isAvailable());
														System.out.println(
																"-------------------------------------------------------------------------");

													}

												} catch (LibraryException e) {
													System.err.println(e.getMessage());
												}

												break;
											case 0:
												break;

											default:
												System.out.println("Search Choice Must Be In Between 0 to 3");
												break;
											}

										} while (searchBook != 0);
										break;
									case 3:
										do {
											try {
												System.out.println("Enter User Id");
												id = scanner.nextInt();
												validation.validatedId(id);
												if(id == userId) {
													flag = true;
												}else {
													System.err.println("Enter Your Id");
													flag = false;
												}
												
											} catch (InputMismatchException e) {
												System.err.println("ID Should Contains Only Digits");
												flag = false;
												scanner.next();
											} catch (LibraryException e) {
												System.err.println(e.getMessage());
												flag = false;
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Book Id");
												isbn = scanner.nextInt();
												validation.validatedId(isbn);
												flag = true;
											} catch (InputMismatchException e) {
												System.err.println("ID Should Contains Only Digits");
												flag = false;
												scanner.next();
											} catch (LibraryException e) {
												System.err.println(e.getMessage());
												flag = false;
											}
										} while (!flag);

										

										LibraryUsers libraryUsers = new LibraryUsers();
										libraryUsers.setId(id);

										BookInfo bookInfo = new BookInfo();
										bookInfo.setIsbn(isbn);

										try {
											RequestInfo requestInfo = new RequestInfo();
											requestInfo = service.bookRequest(id, isbn);
											if (requestInfo != null) {
												System.out.println("Record Inserted");

											} else {
												System.out.println("Unable to Insert");

											}

										} catch (LibraryException e) {
											System.err.println(e.getMessage());
										}

										break;
									case 4:
										do {
											try {
												System.out.println("Enter User Id");
												id = scanner.nextInt();
												validation.validatedId(id);
												if(id == userId) {
													flag = true;
												}else {
													System.err.println("Enter Your Id");
													flag = false;
												}
												
											} catch (InputMismatchException e) {
												System.err.println("ID Should Contains Only Digits");
												flag = false;
												scanner.next();
											} catch (LibraryException e) {
												System.err.println(e.getMessage());
												flag = false;
											}
										} while (!flag);
										do {
											try {
												System.out.println("Enter Book Id");
												isbn = scanner.nextInt();
												validation.validatedId(isbn);
												flag = true;
											} catch (InputMismatchException e) {
												System.err.println("ID Should Contains Only Digits");
												flag = false;
												scanner.next();
											} catch (LibraryException e) {
												System.err.println(e.getMessage());
												flag = false;
											}
										} while (!flag);


										try {
											result = service.bookReturn(id, isbn);
											if (result) {
												System.out.println("Returning request placed to Admin");
											} else {
												System.out.println("Invalid Returning");
											}
										} catch (LibraryException e) {
											System.err.println(e.getMessage());
										}

									case 0:
										break;

									default:
										System.out.println("Range Should be in Between  0 to 4");
										break;
									}

								} while (userChoice != 0); // End Of Users do while
							} // End Of Users Else If

						} else {
							System.err.println("User Unable to Login / Invalid MailId or Password");
						}
					} catch (LibraryException e) {
						System.err.println(e.getMessage());
					} // End Of try Authentication
					break;
//				case 0:
//					break;

				default:
					System.err.println("Choice Should within in the Range");
					break;
				}

			} while (true);

		} // End of Scanner Try resource
	}// End of Main
}// End of Class
